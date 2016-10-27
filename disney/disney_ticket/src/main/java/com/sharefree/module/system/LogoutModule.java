package com.sharefree.module.system;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;

import com.sharefree.biz.itf.system.ILoginBiz;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;

/**
 * 
 * Title: LoginModule
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
@At("/logout")
public class LogoutModule {

	@Inject
	private ILoginBiz loginBiz;

	@GET
	@At("")
	public JsonResult logout() {
		loginBiz.logout();
		return ResultRender.renderResult("注销成功");
	}

}
