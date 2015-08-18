package com.jike.system.consts;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统常量
 * @author Administrator
 *
 */
public class SysConsts {
	
	// 当日已发送警报的接口（隔天清空）
	public static List<String> CURRENT_IS_NOTICE = new ArrayList<String>();

	public static boolean MASTER_SWITCH_OPEN= false; // 定时任务总开关：false-关闭；true-开启

	public static String DETECT_STATE_CLOSE= "0"; // 待检测状态：关闭
	public static String DETECT_STATE_RUN= "1"; // 待检测状态：启用
	public static String DETECT_STATE_STOP= "2"; // 待检测状态：暂停
	
	// 通知对象分隔符
	public static String NOTICE_OBJECT_SPLIT = "|";
	
	// 接口检测结果
	public static String DETECT_RESULT_SUCCESS = "SUCCESS"; // 接口检测结果:成功
	public static String DETECT_RESULT_FAILURE = "FAILURE"; // 接口检测结果:失败

	// 数据库编码
	public static String DATABASE_ENCODING = "GBK";

	// 日志类型
	public static String LOG_TYPE_INTERFACE = "I";
	public static String LOG_TYPE_DATABASE = "D";

	static {
		
	}
}
