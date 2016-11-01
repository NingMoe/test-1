package com.sharefree.module;

import javax.servlet.http.HttpServletRequest;

import org.nutz.mvc.Mvcs;

import com.sharefree.common.CommonException;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.utils.WebSystemUtils;

public class BaseModule {

	/**
	 * 获取当前HttpServletRequest信息
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected HttpServletRequest getRequest() throws CommonException {
		return Mvcs.getReq();
	}

	/**
	 * 获取当前登陆操作员信息
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected OperatorModel currentOperator() throws CommonException {
		return WebSystemUtils.getLoginOpt(getRequest());
	}

}
