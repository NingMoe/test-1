package com.sharefree.front.imp;

import java.util.Date;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.itf.disney.ICrawlerBiz;
import com.sharefree.biz.itf.disney.IDisneyOrderBiz;
import com.sharefree.biz.itf.disney.IEtermBiz;
import com.sharefree.biz.itf.disney.IOccupyDetailBiz;
import com.sharefree.biz.itf.disney.ITicketStockBiz;
import com.sharefree.biz.itf.disney.ITouristOrderBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.OccupyDetailSelector;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristTicketModel;
import com.sharefree.model.plane.PlaneOrderModel;
import com.sharefree.model.plane.TicketPassengerModel;
import com.sharefree.service.itf.ISystemService;
import com.sharefree.utils.CommonUtil;

@IocBean
public class DisneyFront extends BaseFront implements IDisneyFront {

	@Inject
	private ITicketStockBiz ticketStockBiz;

	@Inject
	private IDisneyOrderBiz disneyOrderBiz;

	@Inject
	private ITouristOrderBiz touristOrderBiz;

	@Inject
	private IOccupyDetailBiz occupyDetailBiz;

	@Inject
	private IEtermBiz etermBiz;

	@Inject
	private ICrawlerBiz crawlerBiz;

	@Inject
	protected ISystemService systemService;

	@Override
	public List<TicketStockModel> check(Date visitDateF, Date visitDateT) throws CommonException {
		TicketStockModel model = new TicketStockModel();
		model.setVisitDateF(visitDateF);
		model.setVisitDateT(visitDateT);
		return ticketStockBiz.check(model);
	}

	@Override
	public void check_occupy(Date visitDateF, Date visitDateT) throws CommonException {
		// Step 1 检查门票库存Job
		List<TicketStockModel> models = check(visitDateF, visitDateT);
		if (DisneyConst.ORDER_OCCUPY_RUN) {
			// Step 2 执行占位Job
			disneyOrderBiz.check_occupy(models);
		}
	}

	@Override
	public String cancel_occupy(Long occupyId) throws CommonException {
		// 回填取消信息
		String status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL_ORDER_ERROR;
		OccupyDetailModel model = occupyDetailBiz.selectById(occupyId);
		if (model != null) {
			if (DisneyConst.OCCUPY_DETAIL_STATUS_UNUSE.equals(model.getStatus())) {
				// 先取消平台订单
				boolean cancelOrder = crawlerBiz.cancelOrder(model.getPlatOrderNo());
				// 取消成功才能取消PNR
				boolean cancelPNR = false;
				if (cancelOrder) {
					// 再取消PNR
					cancelPNR = etermBiz.cancelPNR(model.getPnr());
					if (cancelPNR) {
						status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL;
					} else {
						status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL_PNR_ERROR;
					}
				}
				model = new OccupyDetailModel();
				model.setOccupyId(occupyId);
				model.setCancelTime(systemService.getTime());
				model.setStatus(status);
				// 更新状态
				occupyDetailBiz.update(model);
				if (!cancelOrder || !cancelPNR)
					clientPoint("取消占位异常[" + status + "]");
			}
		} else {
			clientPoint("占位信息不存在");
		}
		return status;
	}

	@Override
	public void cancel_occupys(Long orderId) throws CommonException {
		OccupyDetailModel cnd = new OccupyDetailModel();
		cnd.setOrderId(orderId);
		List<OccupyDetailModel> models = occupyDetailBiz.query(cnd);
		if (models != null && models.size() > 0) {
			for (OccupyDetailModel model : models) {
				cancel_occupy(model.getOccupyId());
			}
		}

	}

	@Override
	public void check_pay(TouristTicketModel model) throws CommonException {
		Date visitDate = model.getVisitDate();
		// 查询当天库存
		List<TicketStockModel> stocks = check(visitDate, visitDate);
		model.setStocks(stocks);
		// 检查库存与占位
		OccupyDetailSelector selector = disneyOrderBiz.check_pay(model);
		// 取消占位信息
		// 累计取消占位数
		Integer cancelSum = 0;
		// 全部取消成功标识
		boolean cancelAll = true;
		// 提前占位锁
		boolean occupyLock = false;
		if (selector != null) {
			for (OccupyDetailModel detail : selector.getSelections()) {
				// 释放占位订单
				String cancelFlag = cancel_occupy(detail.getOccupyId());
				if (DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL_ORDER_ERROR.equals(cancelFlag)) {
					cancelAll = false;
					break;
				}
				cancelSum = cancelSum + detail.getOccupyNum();
				// 提前占位
				if (!occupyLock && selector.getOccupyNum() != null && selector.getOccupyNum() > 0 && cancelSum >= selector.getOccupyNum()) {
					// 如果释放数超过出票数，立即占回超出量（不受本地执行记录数的限制，但是需要累积和释放占位数）
					disneyOrderBiz.distribute_occupy(model.getOrderId(), model.getOrderNo(), model.getVisitDate(), selector.getOccupyNum(), true);
					occupyLock = true;
				}
			}
		}
		if (cancelAll) {
			// 立即下单
			Integer ticketNum = disneyOrderBiz.pay(model);
			if (ticketNum != null)
				cancelSum = ticketNum;
		} else {
			// 已提前占位
			if (occupyLock) {
				cancelSum = cancelSum - selector.getOccupyNum();
			}
		}
		// 如果下单支付或者释放订单失败，立即占回超出量（不受本地执行记录数的限制，但是需要累积和释放占位数）
		if (cancelSum > 0)
			disneyOrderBiz.distribute_occupy(model.getOrderId(), model.getOrderNo(), model.getVisitDate(), cancelSum, true);
	}

	@Override
	public PlaneOrderModel analysisPnr(String pnr) throws CommonException {
		PlaneOrderModel model = etermBiz.analysisPNR(pnr);
		if (model != null) {
			List<TicketPassengerModel> passengers = model.getPassengers();
			for (TicketPassengerModel passenger : passengers) {
				passenger.setTel(CommonUtil.getTel());
				passenger.setEmail(CommonUtil.getEmail(passenger.getIdcName()));
			}
		}
		model.setPriceCode(DisneyConst.CRAWLER_SERVICE_PATAM_FREIGHTNO);
		return model;
	}
}
