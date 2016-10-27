package com.sharefree.module.disney;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.PairAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import com.sharefree.biz.itf.disney.ISystemBiz;
import com.sharefree.common.WithoutLoginCheck;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;
import com.sharefree.model.disney.TicketDistributionModel;
import com.sharefree.model.disney.TicketStockModel;

/**
 * 
 * Title: TicketStockModule
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
@At("/system")
public class SystemModule {

	@Inject
	private ISystemBiz systemBiz;

	@Inject
	private IDisneyFront disneyFront;

	/**
	 * 门票库存信息查询
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("/ticketDistribution")
	@AdaptBy(type = PairAdaptor.class)
	public JsonResult ticketDistributionModel(@Param("..") TicketDistributionModel model) {
		model = systemBiz.getTicketDistribution(model);
		return ResultRender.renderResult("操作成功", model);
	}

	@POST
	@At("/check_occupy")
	@WithoutLoginCheck
	public JsonResult order(TicketStockModel model) {
		if (model.getVisitDateF() != null && model.getVisitDateT() != null) {
			disneyFront.check_occupy(model.getVisitDateF(), model.getVisitDateT());
		}
		return ResultRender.renderResult("操作成功");
	}

}
