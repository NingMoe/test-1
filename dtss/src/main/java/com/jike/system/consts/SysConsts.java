package com.jike.system.consts;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title: SysConsts
 *
 * Description: 静态数据
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 13, 2015
 *
 */
public class SysConsts {
	
	// 当日已发送警报的任务（隔天清空）
	public static List<String> CURRENT_IS_NOTICE = new ArrayList<String>();

	// 定时任务总开关：false-关闭；true-开启
	public static boolean MASTER_SWITCH_OPEN = false;

	public static String DETECT_STATE_CLOSE= "0"; // 待检测状态：关闭
	public static String DETECT_STATE_RUN= "1"; // 待检测状态：启用
	public static String DETECT_STATE_STOP= "2"; // 待检测状态：暂停
	
	// 通知对象分隔符
	public static String NOTICE_OBJECT_SPLIT = "|";
	
	// 检测结果
	public static String DETECT_RESULT_SUCCESS = "SUCCESS"; // 检测结果:成功
	public static String DETECT_RESULT_FAILURE = "FAILURE"; // 检测结果:失败

	// 数据库编码
	public static String DATABASE_ENCODING = "GBK";

	// 日志类型
	public static String LOG_TYPE_INTERFACE = "I";
	public static String LOG_TYPE_DATABASE = "D";

	static {
		
	}
}
