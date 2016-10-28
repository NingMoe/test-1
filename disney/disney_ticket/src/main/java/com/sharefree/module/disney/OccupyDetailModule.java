package com.sharefree.module.disney;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.PairAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.PUT;
import org.nutz.mvc.annotation.Param;

import com.sharefree.biz.itf.disney.IOccupyDetailBiz;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;
import com.sharefree.model.disney.OccupyDetailModel;

/**
 * 
 * Title: OccupyDetailModule
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
@At("/occupyDetail")
public class OccupyDetailModule {

	@Inject
	private IOccupyDetailBiz occupyDetailBiz;

	@Inject
	private IDisneyFront disneyFront;

	/**
	 * 占座详情查询
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("")
	@AdaptBy(type = PairAdaptor.class)
	public JsonResult query(@Param("..") OccupyDetailModel model) {
		model = (model == null ? new OccupyDetailModel() : model);
		List<OccupyDetailModel> models = occupyDetailBiz.query(model);
		int total = occupyDetailBiz.count(model);
		return ResultRender.renderPagedResult("操作成功", models, total);
	}

	/**
	 * 取消占位
	 * 
	 * @param occupyId
	 * @return
	 */
	@PUT
	@At("/cencel/?")
	public JsonResult query(Long occupyId) {
		disneyFront.cancel_occupy(occupyId);
		return ResultRender.renderResult("操作成功");
	}

	/**
	 * 确认修复异常取消
	 * 
	 * @param occupyId
	 * @return
	 */
	@PUT
	@At("/anomalyCancelRepair/?")
	public JsonResult repair(Long occupyId) {
		occupyDetailBiz.repair(occupyId);
		return ResultRender.renderResult("操作成功");
	}

}
