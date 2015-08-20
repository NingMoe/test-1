package com.jike.system.consts;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title: DatabaseConsts
 *
 * Description: 数据库检测静态数据
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 17, 2015
 *
 */
public class DatabaseConsts {
	
	// 任务编号
	public static final String TASK_ID = "TASK_ID";
	// 所属任务组编号
	public static final String TASK_GROUP_ID = "TASK_GROUP_ID";
	// 数据库连接驱动
	public static final String DB_DRIVER = "DB_DRIVER";
	// 数据库连接URL
	public static final String DB_URL = "DB_URL";
	// 数据库连接用户名
	public static final String DB_USERNAME = "DB_USERNAME";
	// 数据库连接密码
	public static final String DB_PASSWORD = "DB_PASSWORD";
	// 数据库连接超时
	public static final String DB_TIMEOUT = "DB_TIMEOUT";
	// 检测频率（Cron表达式）
	public static final String CRON_EXPRESSION = "CRON_EXPRESSION";
	// 阈值（限定检测失败次数）
	public static final String THRESHOLD_VALUE = "THRESHOLD_VALUE";
	// 当前检测失败次数
	public static final String CURRENT_FAILURE_NUM = "CURRENT_FAILURE_NUM";
	// 警报级别（何时发送警报）
	public static final String NOTICE_LVL = "NOTICE_LVL";
	// 警报对象（手机号，多个以|隔开）
	public static final String NOTICE_OBJECT = "NOTICE_OBJECT";
	// 状态
	public static final String STATE = "STATE";
	// 数据库检测默认job组
	public static final String DEFAULT_GROUP = "DETECT_DATABASE_DEFAULT_GROUP";
	
	// 待检测数据库列表
	public static Map<String, Map<String, String>> DETECT_DATABASE = new HashMap<String, Map<String, String>>();

	// 数据库检测总开关：false-关闭；true-开启
	public static boolean MASTER_SWITCH_OPEN = false;
	
	// 数据库检测对象元素分隔符
	public static String DBDETECT_ELEMENT_SPLIT = "#";
	
	
}
