package com.jike.system.quartz;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.consts.SysConsts;

/** 
 *  
 * Title: ResertNoticeJob
 *
 * Description: 重置警报对象
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 14, 2015
 *
 */
public class ResertNoticeJob implements Job {

	Logger log = LoggerFactory.getLogger(ResertNoticeJob.class);
	
	// 重置警报对象任务名称
	public static String JOB_NAME = "RESERT_NOTICE";

	// 隔天清空
	public static String RESET_CRON_EXPRESSION= "59 59 23 * * ?";
	
	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 获取任务名称
		log.info("执行任务："+JOB_NAME);
		SysConsts.CURRENT_IS_NOTICE.clear();
		// 隔天调零job连续失败次数(Interface)
		for(String key : InterfaceConsts.FAILURE_TIME.keySet()){
			InterfaceConsts.FAILURE_TIME.put(key, 0);
		}
		// 隔天调零job连续失败次数(Database)
		for(Map<String, String> dd : DatabaseConsts.DETECT_DATABASE.values()){
			dd.put(DatabaseConsts.CURRENT_FAILURE_NUM, "0");
		}
	}
} 