package com.jike.system.quartz;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import org.quartz.Job;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jike.system.bean.DetectInterface;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.dao.DetectInterfaceMapper;
import com.jike.system.model.DetectInterfaceModel;


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

	private String modelName = "消息队列：";

	@Autowired
	private DetectInterfaceMapper detectInterfaceMapper;

	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 获取任务名称
		String jobName = jec.getJobDetail().getName();
		// 获取任务组名称
		String jobGroupName = jec.getJobDetail().getGroup();
		while(jobName != null){
			// 根据任务名称获取待检测的接口信息
			DetectInterface di = detectInterfaceMapper.selectByPrimaryKey(jobName);
			while(di != null){
				DetectInterfaceModel dim = new DetectInterfaceModel();
				BeanUtils.copyProperties(di, dim);
				dim.setJobGroupName(jobGroupName);
				// 获取此接口是否需要启用检测
				boolean state = InterfaceConsts.ITF_DETECT_STATE_RUN.equals(dim.getState());
				// 如果启用，则进行检测
				while(state){
	/*				String itfId = detectInterface.getItfId();
					String itfUrl = detectInterface.getItfUrl();
					String itfParams = detectInterface.getItfParams();
					String requestMethod = detectInterface.getRequestMethod();
					String checkValue = detectInterface.getCheckValue();
					Short thresholdValue = detectInterface.getThresholdValue();
					String noticePhones = detectInterface.getNoticePhones();
					Boolean byProxy = detectInterface.getByProxy();
					String proxyIp = detectInterface.getProxyIp();
					Integer proxyPort = detectInterface.getProxyPort();
					String proxyUsername = detectInterface.getProxyUsername();
					String proxyPassword = detectInterface.getProxyPassword();*/
					
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
} 