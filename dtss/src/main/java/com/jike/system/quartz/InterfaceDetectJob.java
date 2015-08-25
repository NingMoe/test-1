package com.jike.system.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.bean.DetectInterface;
import com.jike.system.biz.itf.IInterfaceDetectBiz;
import com.jike.system.consts.SysConsts;
import com.jike.system.util.ContextUtil;
import com.jike.system.util.StringUtil;

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

	IInterfaceDetectBiz idBiz = (IInterfaceDetectBiz) ContextUtil.getBean("interfaceDetectBiz");
	
	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 获取任务名称
		String jobName = jec.getJobDetail().getKey().getName();
		if(StringUtil.isNotEmpty(jobName)){
			try {
				// 根据任务名称获取待检测的接口信息
				DetectInterface di = idBiz.selectById(jobName);
				if(di != null){
					// 获取此接口是否需要启用检测
					boolean state = SysConsts.DETECT_STATE_RUN.equals(di.getState());
					// 如果启用，则进行检测
					if(state){
						log.info("执行任务："+jobName);
						idBiz.execute(di);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("接口检测编号为:"+jobName+"的定时任务出错[-->DTSS数据库访问出现问题]：", e);
			}
		}
	}
} 