package com.sharefree.module.disney;

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

import com.sharefree.biz.itf.disney.ITouristDetailBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;
import com.sharefree.model.disney.TouristDetailModel;
import com.sharefree.model.disney.TouristOrderModel;

/**
 * 
 * Title: TouristDetailModule
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
@At("/touristDetail")
public class TouristDetailModule {

	@Inject
	private ITouristDetailBiz touristDetailBiz;

	/**
	 * 录入游客详情
	 * 
	 * @param model
	 * @return
	 */
	@POST
	@At("")
	public JsonResult importTourist(TouristOrderModel model) {
		if(model == null || model.getTouristDetails() == null || model.getTouristDetails().size() == 0)
			throw new CommonException("缺少参数{touristDetails}:游客详情");
		touristDetailBiz.importTourist(model);
		return ResultRender.renderResult("操作成功");
	}

	/**
	 * 查询游客详情
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("")
	@AdaptBy(type=PairAdaptor.class)
	public JsonResult query(@Param("..") TouristDetailModel model) {
		model = (model == null?new TouristDetailModel():model);
		List<TouristDetailModel> models = touristDetailBiz.query(model);
		int total = touristDetailBiz.count(model);
		return ResultRender.renderPagedResult("操作成功", models, total);
	}

	/**
	 * 根据ID查询游客详情
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("/?")
	public JsonResult selectById(Long touristId) {
		TouristDetailModel model = touristDetailBiz.selectById(touristId);
		return ResultRender.renderResult("操作成功", model);
	}

	/**
	 * 游客详情修改
	 * 
	 * @param model
	 * @return
	 */
	@PUT
	@At("/?")
	public JsonResult update(Long touristId, TouristDetailModel model) {
		if(touristId == null)
			throw new CommonException("缺少参数{touristId}:游客详情ID");
		if(model == null)
			throw new CommonException("缺少参数:修改值");
		model.setTouristId(touristId);
		touristDetailBiz.update(model);
		return ResultRender.renderResult("操作成功");
	}

	/**
	 * 游客出票
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("/ticketing")
	public JsonResult ticketing(TouristDetailModel model) {
		// 需要提供有效PNR编码
		
		return ResultRender.renderResult("操作成功", model);
	}

}
