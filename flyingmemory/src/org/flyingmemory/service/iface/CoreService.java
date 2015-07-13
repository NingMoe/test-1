package org.flyingmemory.service.iface;

import java.util.Map;

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
public interface CoreService {
	
	/** 
	* 处理微信发来的请求 
	*  
	* @param request 
	* @return 
	*/  
	public String processRequest(Map<String, String> requestMap);
}