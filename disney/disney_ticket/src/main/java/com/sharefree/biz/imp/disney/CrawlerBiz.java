package com.sharefree.biz.imp.disney;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.sharefree.biz.itf.disney.ICrawlerBiz;
import com.sharefree.biz.itf.disney.IEtermBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.model.JsonResult;
import com.sharefree.model.SocketRender;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.OrderRequestModel;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristDetailModel;
import com.sharefree.model.disney.TouristTicketModel;
import com.sharefree.model.plane.PlaneOrderModel;
import com.sharefree.model.plane.PlanePriceModel;
import com.sharefree.utils.DateUtil;
import com.sharefree.utils.StringUtil;
import com.sharefree.utils.URLConnUtils;
import com.sharefree.websocket.disney.DisneySocket;

@IocBean
public class CrawlerBiz implements ICrawlerBiz {

	private static final Logger log = Logger.getLogger(CrawlerBiz.class);

	private static final DecimalFormat df = new DecimalFormat("0.00");

	@Inject
	private IEtermBiz etermBiz;

	private String getAllTouristInfo(OccupyDetailModel model) {
		StringBuilder allTouristInfo = new StringBuilder("");
		allTouristInfo.append(DateUtil.parseDateToString(model.getVisitDate(), DateUtil.FORMAT1)).append("DISNEY");
		allTouristInfo.append("ADT").append("DISNEY");
		allTouristInfo.append(model.getOccupyName()).append("DISNEY");
		allTouristInfo.append(model.getIdcNo()).append("DISNEY");
		allTouristInfo.append("0").append("DISNEY");
		allTouristInfo.append(model.getOccupyNum() - 1).append("DISNEY");
		allTouristInfo.append("0").append("DISNEY");
		allTouristInfo.append(model.getTelephone()).append("DISNEY");
		allTouristInfo.append(model.getEmail()).append("END");
		return allTouristInfo.toString();
	}

	@Override
	public String order_occupy(OccupyDetailModel model) throws CommonException {
		String platOrderNo = null;
		// 初始化请求参数
		OrderRequestModel reqModel = new OrderRequestModel();
		// 使用航司大编码
		reqModel.setPnr_name(model.getBigPnr());
		reqModel.setAllTouristInfo(getAllTouristInfo(model));
		reqModel.setParkDate(new String[] { DateUtil.parseDateToString(model.getVisitDate(), DateUtil.FORMAT1) });
		reqModel.setContact_name(model.getOccupyName());
		reqModel.setContact_mobile(model.getTelephone());
		reqModel.setContact_email(model.getEmail());
		// 获取运价信息
		PlaneOrderModel pom = etermBiz.analysisPAT(model.getPnr());
		if (pom != null && pom.getPrices() != null && pom.getPrices().size() > 0) {
			// 占位时默认取最低运价
			PlanePriceModel price = pom.getPrices().get(0);
			BigDecimal occupyNum = new BigDecimal(model.getOccupyNum());
			reqModel.setTicketPrice(df.format(price.getFacePrice().multiply(occupyNum)));
			reqModel.setTotalTaxes(df.format(price.getAirportCstFee().multiply(occupyNum)));
			reqModel.setTotalCosts(df.format(price.getFuelFee().multiply(occupyNum)));
			// 请求参数进行序列化
			String param = Json.toJson(reqModel, JsonFormat.compact());
			log.debug("请求参数: " + param);
			// 发送请求并接受回执
			log.debug("执行占位操作");
			String resp = URLConnUtils.sendPost(DisneyConst.CRAWLER_REQUEST_URL + DisneyConst.CRAWLER_SERVICE_CODE_ORDER_OCCUPY, param, 30000, 30000);
			log.debug("回复数据: " + resp);
			if (StringUtil.isNotEmpty(resp)) {
				// 解析返回数据
				try {
					JsonResult result = Json.fromJson(JsonResult.class, resp);
					// 请求是否成功
					if (result.getSuccess()) {
						String content = result.getResults().toString().trim();
						platOrderNo = content.substring(content.indexOf("BO"));
						log.debug("执行占位成功,订单号:[" + platOrderNo + "]");
						DisneySocket.broadcast(SocketRender.broadInfoResult("DISNEY下单占位", "订单[" + model.getOrderNo() + "]成功占位[" + model.getOccupyNum() + "]"));
					}
				} catch (Exception e) {
					log.error(resp);
					throw new CommonException("返回数据不符合规范：" + resp);
				}
			} else {
				DisneySocket.broadcast(SocketRender.broadErrorResult("DISNEY下单占位", "执行下单占位操作无返回"));
			}
		}
		return platOrderNo;
	}

	private String getAllTouristInfo(TouristDetailModel model) {
		StringBuilder touristInfo = new StringBuilder("");
		touristInfo.append(DateUtil.parseDateToString(model.getVisitDate(), DateUtil.FORMAT1)).append("DISNEY");
		touristInfo.append("ADT").append("DISNEY");
		touristInfo.append(model.getTouristName()).append("DISNEY");
		touristInfo.append(model.getIdcNo()).append("DISNEY");
		touristInfo.append("0").append("DISNEY");
		touristInfo.append(model.getTicketNum() - 1).append("DISNEY");
		touristInfo.append("0").append("DISNEY");
		touristInfo.append(model.getTelephone()).append("DISNEY");
		touristInfo.append(model.getEmail()).append("END");
		return touristInfo.toString();
	}

	@Override
	public String order_pay(TouristTicketModel model) throws CommonException {
		String platOrderNo = null;
		// 初始化请求参数
		OrderRequestModel reqModel = model.getRequest();
		// 使用航司大编码
		reqModel.setPnr_name(model.getBigPnr());
		// 格式化运价信息
		reqModel.setTicketPrice(df.format(new BigDecimal(reqModel.getTicketPrice())));
		reqModel.setTotalTaxes(df.format(new BigDecimal(reqModel.getTotalTaxes())));
		reqModel.setTotalCosts(df.format(new BigDecimal(reqModel.getTotalCosts())));
		// 格式化游客信息
		List<TouristDetailModel> tourists = model.getTourists();
		StringBuilder allTouristInfo = new StringBuilder("");
		String[] parkDate = new String[tourists.size()];
		for (int i = 0; i < tourists.size(); i++) {
			TouristDetailModel tourist = tourists.get(i);
			allTouristInfo.append(getAllTouristInfo(tourist));
			parkDate[i] = DateUtil.parseDateToString(tourist.getVisitDate(), DateUtil.FORMAT1);
		}
		reqModel.setAllTouristInfo(allTouristInfo.toString());
		reqModel.setParkDate(parkDate);
		// 联系人信息
		reqModel.setContact_name(model.getContactName());
		reqModel.setContact_mobile(model.getContactTel());
		reqModel.setContact_email(model.getContactEmail());
		// 请求参数进行序列化
		String param = Json.toJson(reqModel, JsonFormat.compact());
		log.debug("请求参数: " + param);
		// 发送请求并接受回执
		log.debug("执行下单支付操作");
		String resp = URLConnUtils.sendPost(DisneyConst.CRAWLER_REQUEST_URL + DisneyConst.CRAWLER_SERVICE_CODE_ORDER_PAY, param, 30000, 30000);
		log.debug("回复数据: " + resp);
		if (StringUtil.isNotEmpty(resp)) {
			// 解析返回数据
			try {
				JsonResult result = Json.fromJson(JsonResult.class, resp);
				// 请求是否成功
				if (result.getSuccess()) {
					String content = result.getResults().toString().trim();
					platOrderNo = content.substring(content.indexOf("BO"));
					log.debug("执行下单支付成功,订单号:[" + platOrderNo + "]");
				}
			} catch (Exception e) {
				log.error(resp);
				throw new CommonException("返回数据不符合规范：" + resp);
			}
		} else {
			DisneySocket.broadcast(SocketRender.broadErrorResult("DISNEY下单支付", "执行下单支付操作无返回"));
		}
		return platOrderNo;
	}

	@Override
	public boolean cancelOrder(String platOrderNo) throws CommonException {
		boolean successFlag = false;
		if (StringUtil.isNotEmpty(platOrderNo)) {
			// 请求参数
			Map<String, String> paramObj = new HashMap<String, String>();
			paramObj.put("bigOrderNo", platOrderNo);
			paramObj.put("cancelRemark", "取消");
			// 请求参数进行序列化
			String param = Json.toJson(paramObj, JsonFormat.compact());
			log.debug("请求参数: " + param);
			// 发送请求并接受回执
			log.debug("执行取消订单操作");
			String resp = URLConnUtils.sendPost(DisneyConst.CRAWLER_REQUEST_URL + DisneyConst.CRAWLER_SERVICE_CODE_ORDER_CANCEL, param, 30000, 30000);
			log.debug("回复数据: " + resp);
			if (StringUtil.isNotEmpty(resp)) {
				// 解析返回数据
				try {
					JsonResult result = Json.fromJson(JsonResult.class, resp);
					// 请求是否成功
					if (result.getSuccess()) {
						successFlag = true;
						log.debug("执行取消订单成功");
						DisneySocket.broadcast(SocketRender.broadInfoResult("DISNEY取消订单", "执行取消订单[" + platOrderNo + "]成功"));
					} else {
						DisneySocket.broadcast(SocketRender.broadErrorResult("DISNEY取消订单", "执行取消订单[" + platOrderNo + "]失败"));
					}
				} catch (Exception e) {
					log.error("返回数据不符合规范：" + resp);
					// throw new CommonException("取消平台订单[" + platOrderNo +
					// "]，返回数据不符合规范：" + resp);
				}
			} else {
				DisneySocket.broadcast(SocketRender.broadErrorResult("DISNEY取消订单", "执行取消订单操作无返回"));
			}
		}
		return successFlag;
	}

	@Override
	public void ticket(String platOrderNo, String planeTicketNo) throws CommonException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<TicketStockModel> checkTicketStock(TicketStockModel model) throws CommonException {
		// 请求参数进行序列化
		String param = Json.toJson(model, JsonFormat.compact());
		log.debug("请求参数: " + param);
		// 发送请求并接受回执
		String resp = URLConnUtils.sendPost(DisneyConst.CRAWLER_REQUEST_URL + DisneyConst.CRAWLER_SERVICE_CODE_CHECK_STOCK, param, 30000, 30000);
		log.debug("回复数据: " + resp);
		List<TicketStockModel> models = null;
		if (StringUtil.isNotEmpty(resp)) {
			// 解析返回数据
			try {
				// JsonResult result = Json.fromJson(JsonResult.class, resp);
				// // 请求是否成功
				// if (result.getSuccess()) {
				//
				// }
				Iterator<LinkedHashMap> it = Json.fromJsonAsList(LinkedHashMap.class, resp).iterator();
				models = new ArrayList<TicketStockModel>();
				while (it.hasNext()) {
					Map<String, String> stock = it.next();
					model = new TicketStockModel();
					Date visitDate = DateUtil.parseStringToDate(stock.get("visitDate"), DateUtil.FORMAT16);
					model.setVisitDate(visitDate);
					model.setStock(Integer.valueOf(stock.get("stock")));
					models.add(model);
				}
				log.debug("解析成功: " + Json.toJson(models, JsonFormat.compact()));
			} catch (Exception e) {
				log.error(resp);
				throw new CommonException("检查库存失败：" + resp);
			}
		} else {
			DisneySocket.broadcast(SocketRender.broadErrorResult("DISNEY检查库存", "执行检查库存操作无返回"));
		}
		return models;
	}

	@Override
	public List<TicketStockModel> getGLACode(String platOrderNo) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws InterruptedException {
		// TicketStockModel model = new TicketStockModel();
		// model.setVisitDateF(DateUtil.parseStringToDate("2016-11-20",
		// DateUtil.FORMAT1));
		// model.setVisitDateT(DateUtil.parseStringToDate("2016-11-25",
		// DateUtil.FORMAT1));
		//
		// CrawlerBiz biz = new CrawlerBiz();
		// List<TicketStockModel> models = biz.checkTicketStock(model);

		String ss = "[{\"visitDate\":\"217-01-01\",\"stock\":\"0\"},{\"visitDate\":\"17-01-03\",\"stock\":\"0\"},{\"visitDate\":\"17-01-03\",\"stock\":\"0\"}]";
		List<TicketStockModel> models = Json.fromJsonAsList(TicketStockModel.class, ss);

		System.out.println(Json.toJson(models, JsonFormat.compact()));

		System.out.println(DateUtil.parseDateToString(new Date(1477663627000l), DateUtil.FORMAT7));
		System.out.println(DateUtil.parseDateToString(new Date(1477663854000l), DateUtil.FORMAT7));

	}
}
