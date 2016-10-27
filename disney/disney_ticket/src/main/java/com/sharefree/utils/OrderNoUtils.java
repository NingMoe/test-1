package com.sharefree.utils;

import com.sharefree.constant.DisneyConst;

/**
 * Title:订单编号生成工具类
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2016-10-18
 * 
 * 
 * @version 1.0
 */
public class OrderNoUtils {
	
	public static String touristOrderNoCreator(){
		return DisneyConst.TOURIST_ORDER_ORDER_NO_HEAD + DateUtil.getCurrentDate(DateUtil.FORMAT13);
	}
}
