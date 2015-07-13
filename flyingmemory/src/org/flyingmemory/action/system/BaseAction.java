package org.flyingmemory.action.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.flyingmemory.base.Constants;
import org.flyingmemory.base.util.JSONBean;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Title:
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年1月29日下午2:37:33
 * 
 * version: 1.0
 */
public abstract class BaseAction extends ActionSupport {
	
	private static final long serialVersionUID = -1588665113629279442L;
	
	protected String method;
	
	protected String SUC = Constants.SUCCESS_HEADER;

	public String execute() {
		
		try {
			subExecute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
		
	}
	
	/**
	 * 所有子类实现该方法实现业务逻辑
	 * @return
	 * @throws Exception
	 */
	protected abstract void subExecute() throws Exception;
	
	/**
	 * 将JSON信息返回到客户端
	 * @param message
	 * @throws IOException
	 */
	protected void writeMessage(String message) throws IOException {
		PrintWriter printWriter = ServletActionContext.getResponse().getWriter();
		printWriter.write(message);
		printWriter.flush();
		printWriter.close();
	}
	/**
	 * 输出成功信息
	 * @param msg
	 * @throws IOException 
	 */
	protected void  writeSuccessMsg(String msg) throws IOException {
		JSONBean jsonBean = new JSONBean();
		jsonBean.addJSONElement(Constants.SUCCESS_HEADER, true);
		jsonBean.addJSONElement(Constants.PROMPT_MSG, msg);
		writeMessage(jsonBean.toString());
	}
	
	/**
	 * 输出失败信息
	 * @param msg
	 * @throws IOException
	 */
	protected void  writeErrorMsg(String msg) throws IOException {
		JSONBean jsonBean = new JSONBean();
		jsonBean.addJSONElement(Constants.SUCCESS_HEADER, false);
		jsonBean.addJSONElement(Constants.PROMPT_MSG, msg);
		writeMessage(jsonBean.toString());
	}
	
	/**
	 * 获得request对象
	 * @return
	 * 2010-12-9 上午10:24:32
	 * Shuang.Pan
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	/**
	 * 设置request的attribute
	 * @param name
	 * @param value
	 */
	protected void setRequestAttribute(String name,Object value) {
		getRequest().setAttribute(name, value);
	}
	
	/**
	 * 获得request的attribute
	 * @param name
	 */
	protected Object getRequestAttribute(String name) {
		return getRequest().getAttribute(name);
	}
	
	/**
	 * 获得session的attribute
	 * @param name
	 */
	protected Object getSessionAttribute(String name) {
		return getRequest().getSession().getAttribute(name);
	}
	
	/**
	 * 设置session的attribute
	 * @param name
	 * @param value
	 */
	protected void setSessionAttribute(String name,Object value) {
		getRequest().getSession().setAttribute(name, value);
	}
	
	/**
	 * 删除session内attribute
	 * @param name
	 * 2010-8-31下午10:11:37
	 */
	protected void removeSessionAttribute(String name) {
		getRequest().getSession().removeAttribute(name);
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

}
