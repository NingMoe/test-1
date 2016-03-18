package com.sharefree.utils;

import com.alibaba.fastjson.JSON;

/**
 * Title:POJO工具
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2010-5-28
 * 
 * 
 * @version 1.0
 */
public class BeanUtils {
	
	public static Object copyObject(Object source, Class<?> targetClass) {
		String sourceString = bean2Json(source);
		Object target = json2Bean(sourceString, targetClass);
		return target;
	}

	/**
	 * 
	 * 将待发送的数据转换为json格式
	 * 
	 * @param obj 待处理对象
	 * @return json格式数据
	 */
	public static String bean2Json(Object obj) {
		return JSON.toJSONString(obj);
	}

	/**
	 * 将接受的json格式数据转换为对象
	 * 
	 * @param msg  待处理信息
	 * @param targetObj 目标对象
	 * @return 返回信息对象
	 */
	public static Object json2Bean(String msg, Class<?> targetClass) {
		return JSON.toJavaObject(JSON.parseObject(msg), targetClass);
	}

}
