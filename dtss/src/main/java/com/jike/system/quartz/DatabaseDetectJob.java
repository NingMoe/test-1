package com.jike.system.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.biz.DatabaseDetectHandler;
import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.util.ContextUtil;
import com.jike.system.util.StringUtil;

public class DatabaseDetectJob implements Job {

	Logger log = LoggerFactory.getLogger(DatabaseDetectJob.class);
	
	DatabaseDetectHandler ddHandler = (DatabaseDetectHandler) ContextUtil.getBean("databaseDetectHandler");

	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 定时任务总开关与接口检测总开关是否同时开启
		if(SysConsts.MASTER_SWITCH_OPEN && DatabaseConsts.MASTER_SWITCH_OPEN){
			// 获取任务名称
			String jobName = jec.getJobDetail().getName();
			log.info("执行任务："+jobName);
			if(StringUtil.isNotEmpty(jobName)){
				try {
					// 根据任务名称获取待检测的接口信息
					DetectDatabase dd = ddHandler.selectById(jobName);
					if(dd != null){
						// 获取此接口是否需要启用检测
						boolean state = SysConsts.DETECT_STATE_RUN.equals(dd.getState());
						// 如果启用，则进行检测
						if(state){
							ddHandler.execute(dd);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.info("数据库连接检测编号为:"+jobName+"的定时任务出错[-->DTSS数据库访问出现问题]：", e);
				}
			}
		}
	}
}

