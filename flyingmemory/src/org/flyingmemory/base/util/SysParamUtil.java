package org.flyingmemory.base.util;

import java.util.ResourceBundle;

/**
 * Title:系统参数
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午4:00:07
 * 
 * version: 1.0
 */
public class SysParamUtil {

	private static ResourceBundle SYSPARAM_FILE = ResourceBundle.getBundle("SysParam");
	
//	private static ResourceBundle DBCPARAM_FILE = ResourceBundle.getBundle("DbcParam");
	
	/**
	 * 获得系统参数
	 * @param key
	 * @return
	 */
	public static String getSysParam(String key) {
		return SYSPARAM_FILE.getString(key);
	}
	
	/**
	 * 获得数据库连接参数
	 * @param key
	 * @return
	 */
/*	public static String getDbcParam(String key) {
		return DBCPARAM_FILE.getString(key);
	}*/
}
