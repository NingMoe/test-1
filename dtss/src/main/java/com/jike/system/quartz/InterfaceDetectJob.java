package com.jike.system.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.bean.DetectInterface;
import com.jike.system.biz.InterfaceDetectHandler;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.util.ContextUtil;


/** 
 *  
 * Title: InterfaceDetectJob
 *
 * Description: 接口检测类
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 12, 2015
 *
 */
public class InterfaceDetectJob implements Job {

	Logger log = LoggerFactory.getLogger(InterfaceDetectJob.class);

	InterfaceDetectHandler idHandler = (InterfaceDetectHandler) ContextUtil.getBean("interfaceDetectHandler");
	
	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 获取任务名称
		String jobName = jec.getJobDetail().getName();
		log.info("执行任务："+jobName);
		if(jobName != null){
			// 根据任务名称获取待检测的接口信息
			DetectInterface di = null;
			try {
				di = idHandler.selectById(jobName);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("获取接口ID:"+jobName+"的定时任务出错：", e);
			}
			if(di != null){
				// 获取此接口是否需要启用检测
				boolean state = InterfaceConsts.ITF_DETECT_STATE_RUN.equals(di.getState());
				// 如果启用，则进行检测
				if(state){
					idHandler.execute(di);
				}
			}
		}
	}
} 