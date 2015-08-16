package com.jike.system.servlet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.jike.system.bean.DetectInterface;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.core.QuartzManager;
import com.jike.system.quartz.InterfaceDetectJob;
import com.jike.system.quartz.ResertNoticeJob;
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.util.ContextUtil;


public class ApplicationInit implements ApplicationContextAware {

	Logger log = LoggerFactory.getLogger(ApplicationInit.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// 最优先配置上下文调用工具
		ContextUtil.setContext(applicationContext);
		
		// 启动接口检测定时任务
		IDetectInterfaceService ifs = applicationContext.getBean(IDetectInterfaceService.class);
		startDetectInterface(ifs);
		
		// 启动重置警报对象定时任务
		startResertNotice();
		
		log.info("DTSS 启动成功");
	}
	
	private void startDetectInterface(IDetectInterfaceService ifs){
		log.info("启动接口检测定时任务……");
		try {
			List<DetectInterface> dis = ifs.selectAll();
			if(!dis.isEmpty()){
				for(DetectInterface di: dis){
					// 获取执行频率
					int df = di.getDetectFrequency();
					String detectFrequency = "*/"+df+" * * * * ?";
					// 获取任务名称
					String jobName = di.getItfId();
					// 获取任务组名称
					String jobGroupName = di.getTaskGroupId();
					// 获取此接口是否需要启用检测
					boolean state = InterfaceConsts.ITF_DETECT_STATE_RUN.equals(di.getState());
					// 如果启用，加入定时任务
					if(state){
						log.info("添加定时任务["+jobName+"]:每"+df+"分钟执行一次");
						// 添加定时任务
						QuartzManager.addJob(jobName, jobGroupName, jobName, null, InterfaceDetectJob.class, detectFrequency);
					}
				}
			}
			log.info("接口检测定时任务已启动");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("开启接口检测定时任务出错：", e);
		}
	}
	
	private void startResertNotice(){
		log.info("启动重置警报对象定时任务……");
		// 获取任务名称
		String jobName = ResertNoticeJob.JOB_NAME;
		// 执行频率
		String resetFrequency = ResertNoticeJob.RESET_NOTICE_FREQUENCY;
		// 添加定时任务
		QuartzManager.addJob(jobName, null, jobName, null, ResertNoticeJob.class, resetFrequency);
		log.info("重置警报对象任务已启动");
	}
	
}
