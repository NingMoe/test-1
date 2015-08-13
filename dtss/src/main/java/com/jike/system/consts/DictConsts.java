package com.jike.system.consts;

import java.util.HashMap;
import java.util.Map;

public class DictConsts {

	public static Map<String, String> PASSENGER_TYPE_TTU = new HashMap<>();
	public static Map<String, String> PASSENGER_TYPE_TRAFREE = new HashMap<>();
	public static Map<String, String> PASSENGER_TYPE_CEAIR = new HashMap<>();

	static {
		PASSENGER_TYPE_TTU.put("ADT", "adult");
		PASSENGER_TYPE_TTU.put("CNN", "child");

		PASSENGER_TYPE_TRAFREE.put("ADT", "ADT");
		PASSENGER_TYPE_TRAFREE.put("STU", "STU");
		PASSENGER_TYPE_TRAFREE.put("CNN", "CNN");
		PASSENGER_TYPE_TRAFREE.put("INF", "INF");

		PASSENGER_TYPE_CEAIR.put("ADT", "ADT");
		PASSENGER_TYPE_CEAIR.put("CNN", "CHD");
		PASSENGER_TYPE_CEAIR.put("INF", "INF");

	}

	// 
	public static String COMPANY_CLASS = "COMPANY_CLASS";

	// 企业classType（采购商/供应商）
	public static String COMPANY_CLASS_TYPE = "COMPANY_CLASS_TYPE";
	public static String COMPANY_CLASS_TYPE_PUR = "1";// 采购商
	public static String COMPANY_CLASS_TYPE_SUP = "2";// 供应商
	public static String COMPANY_CLASS_TYPE_ALL = "3";// 即是采购商又是供应商

	// 身份证件种类
	public static String IDC_TYPE = "IDC_TYPE";
	public static String IDC_TYPE_IDENTITYCARD = "1"; // 身份证
	public static String IDC_TYPE_PASSPORT = "2"; // 护照

	// 密码加密自加字符串
	public static String PASSWORD_SECRET = "20150216";

	// 订单类型
	public static String ORDER_TYPE = "ORDER_TYPE";
	public static String ORDER_TYPE_PLANE_CIVIL = "1"; // 国内出票
	public static String ORDER_TYPE_PLANE_INTER = "2"; // 国际出票

	// 消息等级
	public static String MESSAGEQUEUE_LEVEL = "MESSAGEQUEUE_LEVEL";
	public static String MESSAGEQUEUE_LEVEL_INIT = "0";

	
	
}
