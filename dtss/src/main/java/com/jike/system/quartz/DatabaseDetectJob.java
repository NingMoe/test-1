package com.jike.system.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.biz.itf.IDatabaseDetectBiz;
import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.model.DetectDatabaseModel;
import com.jike.system.util.ContextUtil;
import com.jike.system.util.StringUtil;

public class DatabaseDetectJob implements Job {

	Logger log = LoggerFactory.getLogger(DatabaseDetectJob.class);
	
	IDatabaseDetectBiz ddBiz = (IDatabaseDetectBiz) ContextUtil.getBean("databaseDetectBiz");

	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 定时任务总开关是否开启
		if(SysConsts.MASTER_SWITCH_OPEN){
			// 获取任务名称
			String jobName = jec.getJobDetail().getKey().getName();
			if(StringUtil.isNotEmpty(jobName)){
				// 根据任务名称获取待检测的接口信息
				DetectDatabaseModel ddm = DatabaseConsts.DETECT_DATABASE.get(jobName);
				if(ddm != null){
					// 获取此接口是否需要启用检测
					boolean state = SysConsts.DETECT_STATE_RUN.equals(ddm.getState());
					// 如果启用，则进行检测
					if(state){
						log.info("执行任务："+jobName);
						ddBiz.execute(ddm);
					}
				}
			}
		}
	}
}

