package org.flyingmemory.service.iface;

import org.flyingmemory.beans.user.TblWeChatUser;

/**
 * Title:核心服务类
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午5:09:15
 * 
 * version: 1.0
 */
public interface TestService {
	
	/** 
	* 处理微信发来的请求 
	*  
	* @param request 
	* @return 
	*/  
	public String addUser(TblWeChatUser user);
	
	// 检测用户有效性
	public boolean checkUser(String username);
	
	// 获取用户
	public TblWeChatUser getUser(String username);
}