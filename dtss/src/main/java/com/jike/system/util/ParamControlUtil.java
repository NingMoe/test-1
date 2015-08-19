package com.jike.system.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public class ParamControlUtil {

	// 短信发送配置文件
	private static String SMS_PARAM = "config/smsParam";
	// 数据库检测数据配置文件
	private static String DETECT_DB_PARAM = "config/detectDbParam";
	
	/**
	 * 获得短信参数
	 * @param key
	 * @return
	 */
	public static String getSmsParam(String key) {
		return ResourceBundle.getBundle(SMS_PARAM).getString(key);
	}
	
	/**
	 * 获得数据库检测数据
	 * @param key
	 * @return
	 */
	public static List<String> getDetectDbParam() {
		List<String> ddList = new ArrayList<String>();
		ResourceBundle bundle = ResourceBundle.getBundle(DETECT_DB_PARAM);
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()){
			String dd = bundle.getString(keys.nextElement());
			ddList.add(dd);
		}
		return ddList;
	}
}

