package com.sharefree.filter.system;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;

import com.sharefree.common.WithoutLoginCheck;
import com.sharefree.utils.WebSystemUtils;
import com.sharefree.utils.view.ExceptionView;
import com.sharefree.utils.view.ResultViewMaker;

/**
 * 
 * 通过token验证用户登录的有效性
 * 
 */
public class CheckRequestFilter implements ActionFilter {

	@Override
	public View match(ActionContext ac) {
		// 获取入口函数
		Method method = ac.getMethod();
		// 判断入口函数是否包含忽略登陆验证的注解
		if(method.getAnnotation(WithoutLoginCheck.class) != null)
			// 继续执行
			return null;
		
		// 用户登录超时验证
		HttpServletRequest req = ac.getRequest();
		// 验证
		if(!WebSystemUtils.validateLogin(req))
			return new ExceptionView(ResultViewMaker.format, "登录超时");
		return null;
	}

}
