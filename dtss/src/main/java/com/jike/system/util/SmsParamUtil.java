package com.jike.system.util;

import java.util.ResourceBundle;

public class SmsParamUtil {


	private static String SMSPARAM_FILE = "config/smsParam";
	
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle(SMSPARAM_FILE);
	
	/**
	 * 获得短信参数
	 * @param key
	 * @return
	 */
	public static String getParam(String key) {
		return BUNDLE.getString(key);
	}
}

