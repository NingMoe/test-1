package com.sharefree.module.ctrip;

import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.POST;

import com.sharefree.biz.itf.ctrip.IWebCtripFlightBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;
import com.sharefree.model.ctrip.CtripQueryFlightModel;

/**
 * Title: CtripInterFlightModule
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 17, 2016
 *
 */
@IocBean
@At("/ctrip")
@Fail("http:404")
public class CtripInterFlightModule {

    @Inject
    private IWebCtripFlightBiz webCtripFlightBiz;

    @POST
    @At
    public JsonResult query(CtripQueryFlightModel cqfm) {
    	try {
    		Map<String, Object> result =  webCtripFlightBiz.shopping(cqfm);
    		return ResultRender.renderResult("CTRIP国际航班查询成功", result);
		} catch (CommonException e) {
			return ResultRender.renderErrorResult(e);
		} catch (Exception e) {
			CommonException exception = new CommonException("CTRIP国际航班查询失败", e);
			return ResultRender.renderErrorResult(exception);
		}
    }

    @POST
    @At
    public JsonResult check(CtripQueryFlightModel cqfm) {
    	try {
    		Map<String, Object> result =  webCtripFlightBiz.check(cqfm);
    		return ResultRender.renderResult("CTRIP国际航班核价请求成功", result);
		} catch (CommonException e) {
			return ResultRender.renderErrorResult(e);
		} catch (Exception e) {
			CommonException exception = new CommonException("CTRIP国际航班核价请求失败", e);
			return ResultRender.renderErrorResult(exception);
		}
    }

}
