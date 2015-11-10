package com.jike.system.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.biz.itf.IDetectAPIBiz;
import com.jike.system.consts.SysConsts;
import com.jike.system.util.ContextUtil;
import com.jike.system.util.StringUtil;

/**
 * Title: DetectAPIJob
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 6, 2015
 *
 */
public class DetectAPIJob implements Job {

	Logger log = LoggerFactory.getLogger(DetectAPIJob.class);

	IDetectAPIBiz detectAPIBiz = (IDetectAPIBiz) ContextUtil.getBean("detectAPIBiz");
	
	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 定时任务总开关是否开启
		if(SysConsts.MASTER_SWITCH_OPEN){
			// 获取任务名称
			String jobName = jec.getJobDetail().getKey().getName();
			if(StringUtil.isNotEmpty(jobName)){
				try {
					// 根据任务名称执行任务
					log.info("执行任务："+jobName);
					detectAPIBiz.execute();
				} catch (Exception e) {
					e.printStackTrace();
					log.info("编号为:"+jobName+"的定时任务执行时出错：", e);
				}
			}
		}
	}

}
