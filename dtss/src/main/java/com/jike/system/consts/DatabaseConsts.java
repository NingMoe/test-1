package com.jike.system.consts;

import java.util.HashMap;
import java.util.Map;

import com.jike.system.model.DetectDatabaseModel;

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
	
	// 数据库检测默认job组
	public static final String DEFAULT_GROUP = "DETECT_DATABASE_DEFAULT_GROUP";
	
	// 待检测数据库数据列表
	public static Map<String, DetectDatabaseModel> DETECT_DATABASE = new HashMap<String, DetectDatabaseModel>();

	// 数据库检测对象元素分隔符
	public static String DBDETECT_ELEMENT_SPLIT = "#";
	// 任务编号头字符串
	public static String TASK_ID_HEAD_TASKS = "DD-TASKS";
	
	
}
