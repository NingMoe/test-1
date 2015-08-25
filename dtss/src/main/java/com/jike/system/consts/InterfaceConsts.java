package com.jike.system.consts;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title: InterfaceConsts
 *
 * Description: 接口检测静态数据
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 12, 2015
 *
 */
public class InterfaceConsts {

	// 接口检测默认组
	public static final String DEFAULT_GROUP = "DETECT_INTERFACE_DEFAULT_GROUP";

	// 接口参数变量
	public static String ITF_PARAMS_DATE = "${date}"; // 接口参数变量:日期（new Date(),需处理为当日零点）
	public static String ITF_PARAMS_TIME = "${time}"; // 接口参数变量:日期（new Date()）
	// 请求编码
	public static String REQUEST_ENCODECHARSET = "UTF-8";
	// 请求方式
	public static String REQUEST_METHOD_GET = "GET";
	public static String REQUEST_METHOD_POST = "POST";
	public static String REQUEST_METHOD_WEBSERVICE = "WEBSERVICE";
	// 任务编号头字符串
	public static String TASK_ID_HEAD_TASKS = "DI-TASKS";
	public static String TASK_ID_HEAD_GTASK = "DI-GTASK";

	// 当前接口检测各job连续失败次数(写在内存中是防止job执行频率太高时导致数据库表被锁，隔天调零)
	public static Map<String, Integer> FAILURE_TIME = new HashMap<String, Integer>();
	
}
