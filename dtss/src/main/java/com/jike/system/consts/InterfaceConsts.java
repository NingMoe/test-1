package com.jike.system.consts;

import java.util.ArrayList;
import java.util.List;
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
	
	// 当日已发送警报的接口（隔天清空）
	public static List<String> CURRENT_IS_NOTICE = new ArrayList<String>();

	// 检测总开关
	public static boolean MASTER_SWITCH_OPEN= false; // 接口检测总开关：false-关闭；true-开启

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
