package org.flyingmemory.action;

import org.flyingmemory.action.system.BaseAction;
import org.flyingmemory.base.util.ContextUtil;
import org.flyingmemory.beans.user.TblWeChatUser;
import org.flyingmemory.service.iface.TestService;
import org.flyingmemory.base.Constants;


/**
 * Title:核心请求处理类
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午3:56:08
 * 
 * version: 1.0
 */
public class TestAction extends BaseAction {

	private static final long serialVersionUID = -8728127126762555220L;

	private TestService testService = (TestService) ContextUtil.getBean("TestService");	
	
	private String username;
	private String password;
	
	@Override
	protected void subExecute() throws Exception {
		if("register".equals(method)){
			if(testService.checkUser(username)){
				writeErrorMsg("用户已存在！");
				return;
			}
	    	TblWeChatUser user = new TblWeChatUser();
	    	user.setUserId(username);
	    	user.setUserName(username);
	    	user.setPassWord(password);
	    	if(SUC.equals(testService.addUser(user))){
	    		writeSuccessMsg("用户注册成功！");
	    	}
		}
		if("login".equals(method)){
			if(!testService.checkUser(username)){
				writeErrorMsg("用户不存在！");
				return;
			}
	    	TblWeChatUser user = testService.getUser(username);
	    	if(!password.equals(user.getPassWord())){
				writeErrorMsg("密码错误！");
				return;
	    	}
	    	setSessionAttribute(Constants.USER_INFO, user);
	    	writeSuccessMsg("用户验证正确！");
		}
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
