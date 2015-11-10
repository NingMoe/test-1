package com.jike.system.consts;

import com.jike.system.model.DetectAPIConfigModel;

/**
 * Title: APIConsts
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 6, 2015
 *
 */
public class APIConsts {
	
	// 携程爬虫数据--接口请求URL
	public static String CTRIP_URL = "http://114.80.224.47:3420/airfare";
	// 请求编码
	public static String REQUEST_ENCODECHARSET = "UTF-8";
    // 请求频率
	public static int REQUEST_SPEED = 6;

	// 返回结果类型定义
	public static String RESULT_TYPE_FULL_SUCCESS = "0";   // 正常 有数据且完全返回     Fail = null FinFlag = "T"
	public static String RESULT_TYPE_EMPTY_DATA = "1";     // 正常 完全返回却无数据     Fail = null FinFlag = "T"
	public static String RESULT_TYPE_TIME_OUT = "2";       // 正常 采集未完成(超时) 	   Fail = null FinFlag = "F"
	public static String RESULT_TYPE_DATA_ERROR = "3";     // 异常 数据缺失		 	   Fail != null Code = "63000" ErrMsg = "DATA ERROR!"
	public static String RESULT_TYPE_SYSTEM_BUSY = "4";    // 异常 没有数据		 	   Fail != null Code = "81000" ErrMsg = "SYSTEM IS BUSY!"
	public static String RESULT_TYPE_SOCKET_ERROR = "5";  // 异常 SOCKET通信异常
	public static String RESULT_TYPE_EXCEPTION = "6";  	// 异常 其它
	
	// 任务名称
	public static String JOB_NAME = "DETECT_API";
	public static String JOBGROUP_NAME = "DETECT_API_GROUP";
	public static String TRIGGER_NAME =  "DETECT_API_TRIGGER";
	public static String TRIGGERGROUP_NAME = "DETECT_API_TRIGGER_GROUP";
	
	// 航班查询策略
	public static DetectAPIConfigModel DETECT_API_CONFIG= new DetectAPIConfigModel();
	
	// 设置航班查询策略默认值
	static{
	    // 未来多少天之内
		DETECT_API_CONFIG.setFutureStartDate(0);
		DETECT_API_CONFIG.setFutureEndDate(60);
		// Http连接超时
		DETECT_API_CONFIG.setConnectTimeOut(3000);
		// Socket通信超时
		DETECT_API_CONFIG.setSocketTimeOut(11000);
		// 请求完全返回数据超时
		DETECT_API_CONFIG.setTimeOut(30000L);
	}
	
	
	
}
