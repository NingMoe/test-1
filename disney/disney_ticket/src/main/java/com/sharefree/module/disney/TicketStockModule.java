package com.sharefree.module.disney;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.PairAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Param;

import com.sharefree.biz.itf.disney.ITicketStockBiz;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;
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
@At("/ticketStock")
public class TicketStockModule {

	@Inject
	private ITicketStockBiz ticketStockBiz;

	/**
	 * 门票库存信息查询
	 * 
	 * @param model
	 * @return
	 */
	@GET
	@At("")
	@AdaptBy(type=PairAdaptor.class)
	public JsonResult query(@Param("..") TicketStockModel model) {
		return ResultRender.renderResult("操作成功", model);
	}

}
