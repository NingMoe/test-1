package com.sharefree.base.constant;

/**
 * Title: WebCtripConsts
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 12, 2016
 *
 */
public class WebCtripConsts {

	
	// 任务类型：0表示正式任务，1表示测试任务；
	public static final String FLIGHT_QUERY_TASK_TYPE = "0";
	
	// 查询数据来源
	public static final String FLIGHT_QUERY_DATASOURCE = "1"; // 携程数据
	
	// 点击任务类型
	// 新建查询（查询第一程）：1
	public static final String CLICK_NEW_QUERY_FLIGHT = "1";
	// 下一程：2
	public static final String CLICK_QUERY_NEXT_TRIP = "2";
	// 修改行程：3
	public static final String CLICK_MODIFY_TRIP = "3";
	// 产品核价：4
	public static final String CLICK_CHECK_PRODUCT = "4";
	

	public static final String TRIP_TYPE_ONEWAY = "1"; // 单程
	public static final String TRIP_TYPE_ROUND_COMBINATION = "2";// 往返组合
	public static final String TRIP_TYPE_CONNECT = "3";// 联程
	public static final String TRIP_TYPE_ROUND_FREE_COLLOCATION = "4";// 往返自由搭配
	

	// 携程数据异步token
	public static String CTRIP_PROCESS_TOKEN = "asyncToken";
	// 携程异步处理状态
	public static String CTRIP_PROCESS_STATUS = "status";
	// 携程异步处理状态_初始化
	public static Integer CTRIP_PROCESS_STATUS_INIT = 0;
	// 携程异步处理状态_正在查询行程||正在进行核价
	public static Integer CTRIP_PROCESS_STATUS_RUN = 1;
	// 携程异步处理状态_行程查询结束||核价结束
	public static Integer CTRIP_PROCESS_STATUS_FINISH = 5;
	// 携程异步处理状态_查询错误||核价错误
	public static Integer CTRIP_PROCESS_STATUS_ERROR = 6;
	
	// 携程数据异步查询数据
	public static String CTRIP_PROCESS_DATA = "data";
	
	// 国际航班查询（携程爬虫）增量数据缓存
	public static String REDIS_KEY_FLIGHT_INTER_INCR_CACHE = "FLT_INTER_INCR";
	public static Integer FLIGHT_INCR_CACHE_TIMELINESS = 60 * 3; // 增量数据缓存时效，单位：秒；

}
