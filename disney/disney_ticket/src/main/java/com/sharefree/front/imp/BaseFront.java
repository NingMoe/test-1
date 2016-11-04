package com.sharefree.front.imp;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.Mvcs;

import com.sharefree.common.CommonException;
import com.sharefree.model.SocketRender;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.service.itf.ISystemService;
import com.sharefree.utils.WebSystemUtils;
import com.sharefree.websocket.disney.DisneySocket;

public class BaseFront {

	@Inject
	protected ISystemService systemService;

	/**
	 * 获取当前系统时间
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected Date getSystemTime() throws CommonException {
		return systemService.getTime();
	}

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

	/**
	 * 获取当前登陆token
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected String currentToken() throws CommonException {
		return WebSystemUtils.getToken(getRequest());
	}

	/**
	 * 获取当前登陆token
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected void clientPoint(String msg) throws CommonException {
		if (getRequest() != null) {
			String token = currentToken();
			DisneySocket.point(token, SocketRender.pointInfoResult(currentOperator().getOptName(), this.getClass().getSimpleName(), msg));
		}
	}

}
