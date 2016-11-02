package com.sharefree.module.disney;

import java.util.Date;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.PairAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.PUT;
import org.nutz.mvc.annotation.Param;

import com.sharefree.biz.itf.disney.ITouristOrderBiz;
import com.sharefree.common.CommonException;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;
import com.sharefree.model.disney.TouristOrderModel;
import com.sharefree.model.plane.PlaneOrderModel;
import com.sharefree.module.BaseModule;
import com.sharefree.runner.disney.CancelOccupyRunner;
import com.sharefree.utils.ThreadPoolUtil;

/**
 * 
 * Title: TouristOrderModule
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Jul 22, 2016
 *
 */
@IocBean
@At("/touristOrder")
public class TouristOrderModule extends BaseModule {

	@Inject
	private ITouristOrderBiz touristOrderBiz;

	@Inject
	private IDisneyFront disneyFront;

	/**
	 * 游客订单下单
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@POST
	@At("")
	public JsonResult order(TouristOrderModel model) {
		touristOrderBiz.order(model);
		// 查询条件
		Date visitDate = model.getVisitDate();
		// 立即检查
		disneyFront.check_occupy(visitDate, visitDate);
		return ResultRender.renderResult("操作成功");
	}

	/**
	 * 游客订单查询
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("")
	@AdaptBy(type = PairAdaptor.class)
	public JsonResult query(@Param("..") TouristOrderModel model) {
		model = (model == null ? new TouristOrderModel() : model);
		List<TouristOrderModel> models = touristOrderBiz.queryByCustomSQL(model);
		int total = touristOrderBiz.countByCustomSQL(model);
		return ResultRender.renderPagedResult("操作成功", models, total);
	}

	/**
	 * 游客订单及其明细查询
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("/?")
	public JsonResult queryByOrderId(Long orderId) {
		TouristOrderModel model = touristOrderBiz.selectByIdWithDetail(orderId);
		return ResultRender.renderResult("操作成功", model);
	}

	/**
	 * 游客订单修改
	 * 
	 * @param model
	 * @return
	 */
	@PUT
	@At("/?")
	public JsonResult update(Long orderId, TouristOrderModel model) {
		if (orderId == null)
			throw new CommonException("缺少参数{orderId}:订单ID");
		if (model == null)
			throw new CommonException("缺少参数:修改值");
		model.setOrderId(orderId);
		touristOrderBiz.update(model);
		return ResultRender.renderResult("操作成功");
	}

	/**
	 * 游客订单取消
	 * 
	 * @param model
	 * @return
	 */
	@PUT
	@At("/cancel/?")
	public JsonResult cancel(Long orderId) {
		if (orderId == null)
			throw new CommonException("缺少参数{orderId}:订单ID");
		touristOrderBiz.cancel(orderId);
		// 取消关联占位信息
		ThreadPoolUtil.execute(new CancelOccupyRunner(orderId));
		return ResultRender.renderResult("操作成功");
	}

	/**
	 * 解析pnr
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("/analysisPnr/?")
	public JsonResult analysisPnr(String pnr) {
		PlaneOrderModel model = disneyFront.analysisPnr(pnr);
		return ResultRender.renderResult("操作成功", model);
	}

}
