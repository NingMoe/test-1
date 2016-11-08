package com.sharefree.biz.imp.disney;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.sharefree.biz.itf.disney.IEtermBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.model.JsonResult;
import com.sharefree.model.plane.PlaneOrderModel;
import com.sharefree.utils.StringUtil;
import com.sharefree.utils.URLConnUtils;

@IocBean
public class EtermBiz implements IEtermBiz {

	private static final Logger log = Logger.getLogger(EtermBiz.class);

	@Override
	public String[] createPNR(PlaneOrderModel order) throws CommonException {
		// 请求参数进行序列化
		String param = Json.toJson(order, JsonFormat.compact());
		log.debug("请求参数: " + param);
		// 发送请求并接受回执
		String resp = URLConnUtils.sendPost(DisneyConst.ETERM_REQUEST_URL + DisneyConst.ETERM_SERVICE_CODE_CREATE_PNR, param, 30000, 30000);
		log.debug("回复数据: " + resp);
		String pnr[] = null;
		if (StringUtil.isNotEmpty(resp)) {
			// 解析返回数据
			try {
				JsonResult result = Json.fromJson(JsonResult.class, resp);
				// 请求是否成功
				if (result.getSuccess()) {
					String[] results = result.getResults().toString().split("#");
					if (results.length > 1)
						pnr = results;
				}
			} catch (Exception e) {
				log.error(resp);
				throw new CommonException("返回数据不符合规范：" + resp);
			}
		}
		return pnr;
	}

	@Override
	public boolean cancelPNR(String pnr) throws CommonException {
		boolean successFlag = false;
		log.debug("请求参数: " + pnr);
		// 发送请求并接受回执
		String resp = URLConnUtils.sendGet(DisneyConst.ETERM_REQUEST_URL + DisneyConst.ETERM_SERVICE_CODE_CANCEL_PNR + pnr, null);
		log.debug("回复数据: " + resp);
		if (StringUtil.isNotEmpty(resp)) {
			// 解析返回数据
			try {
				JsonResult result = Json.fromJson(JsonResult.class, resp);
				// 请求是否成功
				if (result.getSuccess()) {
					successFlag = true;
					log.info("PNR编码[" + pnr + "]取消成功");
				} else {
					log.error("PNR编码[" + pnr + "]取消失败");
				}
			} catch (Exception e) {
				log.error("取消PNR编码[" + pnr + "]，返回数据不符合规范：" + resp);
				// throw new CommonException("取消PNR编码[" + pnr + "]，返回数据不符合规范：" +
				// resp);
			}
		} else {
			log.error("PNR编码[" + pnr + "]取消失败");
		}
		return successFlag;
	}

	@Override
	public PlaneOrderModel analysisPNR(String pnr) throws CommonException {
		log.debug("请求参数: " + pnr);
		// 发送请求并接受回执
		String resp = URLConnUtils.sendGet(DisneyConst.ETERM_REQUEST_URL + DisneyConst.ETERM_SERVICE_CODE_ANALYSIS_PNR + pnr, null);
		log.debug("回复数据: " + resp);
		PlaneOrderModel model = null;
		if (StringUtil.isNotEmpty(resp)) {
			// 解析返回数据
			try {
				JsonResult result = Json.fromJson(JsonResult.class, resp);
				// 请求是否成功
				if (result.getSuccess()) {
					log.info("解析PNR(RT&PAT)[" + pnr + "]成功");
					String obj = Json.toJson(result.getResults(), JsonFormat.compact());
					model = Json.fromJson(PlaneOrderModel.class, obj);
					// 运价排序
					model.sort(model.getPrices(), null);
				} else {
					log.error("解析PNR(RT&PAT)[" + pnr + "]失败" + result.getCustomMsg());
					throw new CommonException("解析PNR(RT&PAT)[" + pnr + "]失败" + result.getCustomMsg());
				}
			} catch (Exception e) {
				log.error(resp);
				throw new CommonException("解析PNR(RT&PAT)[" + pnr + "]，返回数据不符合规范：" + resp);
			}
		} else {
			log.error("解析PNR(RT&PAT)[" + pnr + "]失败");
		}
		return model;
	}

	@Override
	public PlaneOrderModel analysisRT(String pnr) throws CommonException {
		log.debug("请求参数: " + pnr);
		// 发送请求并接受回执
		String resp = URLConnUtils.sendGet(DisneyConst.ETERM_REQUEST_URL + DisneyConst.ETERM_SERVICE_CODE_ANALYSIS_RT + pnr, null);
		log.debug("回复数据: " + resp);
		PlaneOrderModel model = null;
		if (StringUtil.isNotEmpty(resp)) {
			// 解析返回数据
			try {
				JsonResult result = Json.fromJson(JsonResult.class, resp);
				// 请求是否成功
				if (result.getSuccess()) {
					log.info("解析RT信息[" + pnr + "]成功");
					String obj = Json.toJson(result.getResults(), JsonFormat.compact());
					model = Json.fromJson(PlaneOrderModel.class, obj);
				} else {
					log.error("解析RT信息[" + pnr + "]失败");
					throw new CommonException("解析RT信息[" + pnr + "]失败" + result.getCustomMsg());
				}
			} catch (Exception e) {
				log.error(resp);
				throw new CommonException("解析RT信息[" + pnr + "]，返回数据不符合规范：" + resp);
			}
		} else {
			log.error("解析RT信息[" + pnr + "]失败");
		}
		return model;
	}

	@Override
	public PlaneOrderModel analysisPAT(String pnr) throws CommonException {
		log.debug("请求参数: " + pnr);
		// 发送请求并接受回执
		String resp = URLConnUtils.sendGet(DisneyConst.ETERM_REQUEST_URL + DisneyConst.ETERM_SERVICE_CODE_ANALYSIS_PAT + pnr, null);
		log.debug("回复数据: " + resp);
		PlaneOrderModel model = null;
		if (StringUtil.isNotEmpty(resp)) {
			// 解析返回数据
			try {
				JsonResult result = Json.fromJson(JsonResult.class, resp);
				// 请求是否成功
				if (result.getSuccess()) {
					log.info("解析PAT信息[" + pnr + "]成功");
					String obj = Json.toJson(result.getResults(), JsonFormat.compact());
					model = Json.fromJson(PlaneOrderModel.class, obj);
					// 运价排序
					model.sort(model.getPrices(), null);
				} else {
					log.error("解析PAT信息[" + pnr + "]失败");
					throw new CommonException("解析PAT信息[" + pnr + "]失败" + result.getCustomMsg());
				}
			} catch (Exception e) {
				log.error(resp);
				throw new CommonException("解析PAT信息[" + pnr + "]，返回数据不符合规范：" + resp);
			}
		} else {
			log.error("解析PAT信息[" + pnr + "]失败");
		}
		return model;
	}

	@Override
	public String ticket(String pnr) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

}
