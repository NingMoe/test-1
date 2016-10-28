package com.sharefree.biz.imp.disney;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;

import com.sharefree.biz.imp.BaseBiz;
import com.sharefree.biz.itf.disney.ICrawlerBiz;
import com.sharefree.biz.itf.disney.IDisneyOrderBiz;
import com.sharefree.biz.itf.disney.IEtermBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.constant.SqlsConst;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.PassengerModel;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristOrderModel;
import com.sharefree.model.disney.TripModel;
import com.sharefree.model.plane.PlaneODModel;
import com.sharefree.model.plane.PlaneOrderModel;
import com.sharefree.model.plane.PlaneTripModel;
import com.sharefree.model.plane.TicketPassengerModel;
import com.sharefree.runner.disney.OrderOccupyRunner;
import com.sharefree.service.itf.disney.IOccupyDetailService;
import com.sharefree.service.itf.disney.IPassengerService;
import com.sharefree.service.itf.disney.ITouristDetailService;
import com.sharefree.service.itf.disney.ITouristOrderService;
import com.sharefree.service.itf.disney.ITripService;
import com.sharefree.utils.CommonUtil;
import com.sharefree.utils.DateUtil;
import com.sharefree.utils.DisneyUtil;
import com.sharefree.utils.StringUtil;
import com.sharefree.utils.ThreadPoolUtil;

@IocBean
public class DisneyOrderBiz extends BaseBiz<TouristOrderModel, Long> implements IDisneyOrderBiz {

	private static final Logger log = Logger.getLogger(DisneyOrderBiz.class);

	@Inject
	private ITouristOrderService touristOrderService;

	@Inject
	private ITouristDetailService touristDetailService;

	@Inject
	private IOccupyDetailService occupyDetailService;

	@Inject
	private IPassengerService passengerService;

	@Inject
	private ITripService tripService;

	@Inject
	private IEtermBiz etermBiz;

	@Inject
	private ICrawlerBiz crawlerBiz;

	@Override
	public void occupyList(List<TicketStockModel> stocks) throws CommonException {
		if (stocks != null && stocks.size() > 0) {
			// 获取日期库存对应数据
			Map<String, Integer> stockMap = new HashMap<String, Integer>();
			for (TicketStockModel stock : stocks) {
				String key = DateUtil.parseDateToString(stock.getVisitDate(), DateUtil.FORMAT1);
				Integer orderingNum = DisneyUtil.handle(key, DisneyUtil.Signal.OBTAIN, null);
				if (stock.getStock() > orderingNum) {
					stockMap.put(key, stock.getStock() - orderingNum);
				}
			}
			// 查询符合条件的游客订单
			TouristOrderModel model = new TouristOrderModel();
			// 确认入园日期
			model.setVisitDateIn(stockMap.keySet().toArray(new String[0]));
			model.setVisitDateF(DateUtil.getDateAfterDays(getSystemTime(), DisneyConst.PLANE_BEFORE_DSN_MIN));
			// 需要占位的订单
			model.setIsNeedOccupy(true);
			// 状态为[未出票；部分出票]的订单
			model.setStatusIn(new String[] { DisneyConst.TOURIST_ORDER_STATUS_UNTICKET, DisneyConst.TOURIST_ORDER_STATUS_TICKETING });
			// 排序
			model.setOrderByCustom("visitDate,priority");
			model.setSqlKey(SqlsConst.TOURIST_ORDER_QUERY);
			// 查询
			List<TouristOrderModel> models = touristOrderService.queryByCustomSQL(model);
			if (models != null && models.size() > 0) {
				// 需要执行的任务
				for (TouristOrderModel elem : models) {
					// 验证数据，确定需要占位数
					String visitDate = DateUtil.parseDateToString(elem.getVisitDate(), DateUtil.FORMAT1);
					// 当前库存
					Integer stock = stockMap.get(visitDate);
					// 计算占位需求
					int needOccupy = elem.getNeedOccupyNum() - (elem.getOccupyNum() + elem.getTicketingNum());
					// 实际可占位数量
					int canOccupy = 0;
					if (needOccupy > 0) {
						// 库存是否充足
						if (stock > needOccupy) {
							// 从当前库存减去需求
							stock = stock - needOccupy;
							canOccupy = needOccupy;
							stockMap.put(visitDate, stock);
						} else {
							// 取出全部库存
							canOccupy = stock;
							stock = 0;
							stockMap.put(visitDate, stock);
						}
					}
					// 计算占位订单数和订单包含票数
					Integer[] occupyOrderInfo = DisneyUtil.calculateOccupyOrder(canOccupy);
					if (occupyOrderInfo.length > 0) {
						for (Integer info : occupyOrderInfo) {
							OccupyDetailModel odm = new OccupyDetailModel();
							odm.setOrderId(elem.getOrderId());
							odm.setOrderNo(elem.getOrderNo());
							odm.setVisitDate(elem.getVisitDate());
							odm.setOccupyNum(info);
							odm.setStatus(DisneyConst.OCCUPY_DETAIL_STATUS_UNUSE);
							// 多线程执行，线程分发
							ThreadPoolUtil.execute(new OrderOccupyRunner(odm));
							// 此入园日期，下单执行数增加1次
							DisneyUtil.handle(visitDate, DisneyUtil.Signal.INCREASE, 1);
						}
					}
				}
			}
		}
	}

	/**
	 * 获取随机信息生成PNR,并进行占位
	 * 
	 * @param model
	 */
	@Override
	public void occupy(OccupyDetailModel model) throws CommonException {
		Date visitDate = model.getVisitDate();
		try {
			// 占座编码，旅客信息，联系人信息，占位时间，平台订单编号
			Integer occupyNum = model.getOccupyNum();
			// 游客信息
			PassengerModel passenger = null;
			// 生成PNR
			String pnr[] = null;
			// 当前执行生成pnr次数
			int ct = 0;
			while (ct < DisneyConst.ORDER_OCCUPY_CREATE_PNR_LIMIT) {
				try {
					// 随机获取乘客信息
					List<PassengerModel> passengers = getPassengers(occupyNum);
					// 随机获取行程信息(无行程日期)
					TripModel trip = getTrip();
					// 生成PNR
					pnr = createPnr(trip, passengers, visitDate);
					// 是否成功
					if (pnr != null) {
						passenger = passengers.get(CommonUtil.getNum(0, occupyNum - 1));
						break;
					}
					log.error("执行占位操作:第" + ct + "次生成PNR为空");
				} catch (Exception e) {
					// 生成PNR失败
					log.error("执行占位操作:第" + ct + "次生成PNR失败");
				} finally {
					ct++;
				}
				continue;
			}
			// 若无法生成pnr,任务到此结束
			if (pnr != null) {
				try {
					// 补充信息
					model.setPnr(pnr[0]);
					model.setBigPnr(pnr[1]);
					// 游客信息
					model.setOccupyName(passenger.getName());
					model.setIdcType(passenger.getIdcType());
					model.setIdcNo(passenger.getIdcNo());
					model.setTelephone(passenger.getTel());
					model.setEmail(passenger.getEmail());
					// 联系人信息
					model.setContactName(passenger.getName());
					model.setContactTel(passenger.getTel());
					model.setContactEmail(passenger.getEmail());
					// 其他
					model.setOccupyTime(systemService.getTime());

					String platOrderNo = crawlerBiz.order_occupy(model);
					if (StringUtil.isNotEmpty(platOrderNo)) {
						// 下单占位成功
						model.setPlatOrderNo(platOrderNo);
						// 保存占位信息
						occupyDetailService.insert(model);
					} else {
						// 下单占位失败
						etermBiz.cancelPNR(pnr[0]);
					}
				} catch (Exception e) {
					// 取消PNR
					etermBiz.cancelPNR(pnr[0]);
				}
			}
		} catch (Exception e) {
		} finally {
			String key = DateUtil.parseDateToString(visitDate, DateUtil.FORMAT1);
			// 不管占位操作结果如何，减少此入园日期，下单执行数1次
			DisneyUtil.handle(key, DisneyUtil.Signal.REDUCE, 1);
		}
	}

	/**
	 * 生成PNR编码
	 * 
	 * @param pnr
	 * @param passengers
	 * @return
	 */
	public String[] createPnr(TripModel trip, List<PassengerModel> passengers, Date visitDate) {

		log.debug("生成PNR编码");
		String pnr[] = null;
		if (trip != null && passengers != null && passengers.size() > 0) {
			PlaneOrderModel order = new PlaneOrderModel();
			// 添加行程
			List<PlaneODModel> podms = new ArrayList<PlaneODModel>();
			PlaneODModel podm = new PlaneODModel();
			List<PlaneTripModel> ptms = new ArrayList<PlaneTripModel>();
			PlaneTripModel ptm = new PlaneTripModel();
			// 计算入园日期距离当日有多少天
			int between = DateUtil.betweenTwoDates(visitDate, getSystemTime());
			if (between > DisneyConst.PLANE_BEFORE_DSN_MAX)
				between = DisneyConst.PLANE_BEFORE_DSN_MAX;
			Date takeOffDate = DateUtil.getDateAfterDays(visitDate, CommonUtil.getNum(-between, -DisneyConst.PLANE_BEFORE_DSN_MIN));
			String takeOffDateStr = DateUtil.parseDateToString(takeOffDate, DateUtil.FORMAT12);
			Date takeOffTime = DateUtil.parseStringToDate(takeOffDateStr + trip.getDepartTime(), DateUtil.FORMAT17);
			Date arriveTime = DateUtil.parseStringToDate(takeOffDateStr + trip.getArriveTime(), DateUtil.FORMAT17);
			ptm.setDepartAirportCode(trip.getDepartAirportCode());
			ptm.setTakeOffTime(takeOffTime.getTime());
			ptm.setDepartTime(takeOffTime.getTime());
			ptm.setArriveAirportCode(trip.getArriveAirportCode());
			ptm.setArriveTime(arriveTime.getTime());
			ptm.setAirlineCode(trip.getAirlineCode());
			ptm.setFlightNo(trip.getFlightNo());
			String[] cabins = trip.getCabinArray().split(",");
			String cabin = cabins[CommonUtil.getNum(0, cabins.length - 1)];
			ptm.setCabin(cabin);

			ptms.add(ptm);
			podm.setSegments(ptms);
			podms.add(podm);
			order.setOds(podms);
			// 添加旅客
			List<TicketPassengerModel> tpms = new ArrayList<TicketPassengerModel>();
			for (PassengerModel passenger : passengers) {
				TicketPassengerModel tpm = new TicketPassengerModel();
				tpm.setIdcName(passenger.getName());
				tpm.setIdcType(passenger.getIdcType());
				tpm.setIdcNo(passenger.getIdcNo());
				tpms.add(tpm);
			}
			order.setPassengers(tpms);
			// 生成PNR编码
			pnr = etermBiz.createPNR(order);
		}
		return pnr;
	}

	/**
	 * 随机获取乘客信息
	 * 
	 * @return
	 */
	public List<PassengerModel> getPassengers(int num) {
		// 随机获取乘客id
		List<String> rowIdIn = new ArrayList<String>();
		while (rowIdIn.size() < num) {
			String id = String.valueOf(CommonUtil.getNum(1, DisneyConst.PASSENGETR_ROW_MAX));
			if (rowIdIn.contains(id))
				continue;
			rowIdIn.add(id);
		}
		PassengerModel cnd = new PassengerModel();
		cnd.setRowIdIn(rowIdIn.toArray(new String[num]));
		cnd.setSqlKey(SqlsConst.GET_PASSENGER_RANDOM);
		return passengerService.queryByCustomSQL(cnd);
	}

	/**
	 * 随机获取行程信息（航司必须为东航）
	 * 
	 * @return
	 */
	public TripModel getTrip() {
		// 随机获取行程id
		Long rowId = Long.valueOf(CommonUtil.getNum(1, DisneyConst.TRIP_ROW_MAX));
		TripModel cnd = new TripModel();
		cnd.setRowId(rowId);
		cnd.setSqlKey(SqlsConst.GET_TRIP_RANDOM);
		List<TripModel> models = tripService.queryByCustomSQL(cnd);
		return models.get(0);
	}

	@Override
	public void pay(String info) throws CommonException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		System.out.println(Json.toJson(DisneyUtil.calculateOccupyOrder(18)));
		System.out.println(Json.toJson(DisneyUtil.calculateOccupyOrder(0)));

		System.out.println(DateUtil.parseStringToDate("2016-11-26 08:00", DateUtil.FORMAT4).getTime());
	}
}
