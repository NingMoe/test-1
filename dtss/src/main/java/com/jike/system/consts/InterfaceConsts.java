package com.jike.system.consts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 
 * Title: InterfaceConsts
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 12, 2015
 *
 */
public class InterfaceConsts {
	
	// 是否进行接口检测
	public static boolean IS_DETECT = false;
	
	// 待检测接口列表
	public static List<Map<String, Object>> INTREFACES_TO_DETECT = new ArrayList<Map<String, Object>>();

	// 接口检测配置项key
/*	public static String ITF_ID = "ITF_ID"; // 接口编号
	public static String ITF_URL= "ITF_URL"; // 接口地址
	public static String ITF_PARAMS = "ITF_PARAMS"; // 接口参数
	public static String REQUEST_METHOD = "REQUEST_METHOD"; // 请求方式
	public static String CHECK_VALUE= "CHECK_VALUE"; // 返回数据校验值
	public static String DETECT_FREQUENCY = "DETECT_FREQUENCY"; // 检测频率（毫秒）
	public static String LAST_DETECT = "LAST_DETECT"; // 上次检查时间（毫秒）
	public static String THRESHOLD_VALUE= "THRESHOLD_VALUE"; // 阈值（连续检测失败次数，隔天调零）
	public static String NOTICE_PHONES= "NOTICE_PHONES"; // 待通知手机号（多个以|隔开）
	public static String LAST_NOTICE = "LAST_NOTICE"; // 上次通知时间（毫秒）
	public static String BY_PROXY = "BY_PROXY"; // 是否代理
	public static String PROXY_IP = "PROXY_IP"; // 代理地址
	public static String PROXY_PORT = "PROXY_PORT"; // 代理端口号
	public static String PROXY_USERNAME = "PROXY_USERNAME"; // 代理用户名
	public static String PROXY_PASSWORD = "PROXY_PASSWORD"; // 代理密码
	public static String IS_ENABLE= "IS_ENABLE"; // 是否启用
*/
	public static String ITF_DETECT_STATE_CLOSE= "0"; // 待检测接口状态：关闭
	public static String ITF_DETECT_STATE_RUN= "1"; // 待检测接口状态：启用
	public static String ITF_DETECT_STATE_STOP= "2"; // 待检测接口状态：暂停
	
	// 接口参数变量
	public static String ITF_PARAMS_DATE = "${date}"; // 接口参数变量:日期（new Date(),需处理为当日零点）
	public static String ITF_PARAMS_TIME = "${time}"; // 接口参数变量:日期（new Date()）
	// 通知对象分隔符
	public static String NOTICE_OBJECT_SPLIT = "|";
	// 请求编码
	public static String REQUEST_ENCODECHARSET = "UTF-8";
	// 请求方式
	public static String REQUEST_METHOD_GET = "GET";
	public static String REQUEST_METHOD_POST = "POST";
	public static String REQUEST_METHOD_WEBSERVICE = "WEBSERVICE";
	// 接口检测结果
	public static String DETECT_RESULT_SUCCESS = "SUCCESS"; // 接口检测结果:成功
	public static String DETECT_RESULT_FAILURE = "FAILURE"; // 接口检测结果:失败
	
}
