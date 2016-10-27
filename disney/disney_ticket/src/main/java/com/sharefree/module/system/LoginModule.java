package com.sharefree.module.system;

import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.POST;

import com.sharefree.biz.itf.system.ILoginBiz;
import com.sharefree.common.WithoutLoginCheck;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;
import com.sharefree.model.system.OperatorModel;

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
@At("/login")
public class LoginModule {

	@Inject
	private ILoginBiz loginBiz;

	@POST
	@At("/operator")
	@WithoutLoginCheck
	@Aop("loginInterceptor")
	public JsonResult byOptNo(OperatorModel model) {
		model = loginBiz.loginInByOptNo(model);
		return ResultRender.renderResult("操作成功", model);
	}

	@POST
	@At("/telephone")
	@WithoutLoginCheck
	@Aop("loginInterceptor")
	public JsonResult byTelephoneNo(OperatorModel model) {
		model = loginBiz.loginInByTelephoneNo(model);
		return ResultRender.renderResult("操作成功", model);
	}

	@POST
	@At("")
	@WithoutLoginCheck
	@Aop("loginInterceptor")
	public JsonResult byUserNo(OperatorModel model) {
		model = loginBiz.loginInByUserNo(model);
		return ResultRender.renderResult("操作成功", model);
	}

	@GET
	@At("/check")
	public JsonResult check() {
		return ResultRender.renderResult("操作成功");
	}
	
	

}
