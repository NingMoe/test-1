package com.jike.system.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.jike.system.bean.DetectInterface;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.service.InterfaceDetectHandler;
import com.jike.system.service.itf.IDetectInterfaceService;
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

	IDetectInterfaceService diService = (IDetectInterfaceService) ContextUtil.getBean("detectInterfaceService");

	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 获取任务名称
		String jobName = jec.getJobDetail().getName();
		// 获取任务组名称
		String jobGroupName = jec.getJobDetail().getGroup();
		System.out.println("执行任务："+jobName+":"+jobGroupName);
		if(jobName != null){
			// 根据任务名称获取待检测的接口信息
			DetectInterface di = null;
			try {
				di = diService.selectById(jobName);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("获取接口ID:"+jobName+"的定时任务出错：", e);
			}
			System.out.println(JSON.toJSONString(di));
			if(di != null){
				DetectInterfaceModel dim = new DetectInterfaceModel();
				BeanUtils.copyProperties(di, dim);
				dim.setJobGroupName(jobGroupName);
				// 获取此接口是否需要启用检测
				boolean state = InterfaceConsts.ITF_DETECT_STATE_RUN.equals(dim.getState());
				// 如果启用，则进行检测
				if(state){
					InterfaceDetectHandler.execute(dim);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
} 