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
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.util.ContextUtil;


public class ApplicationInit implements ApplicationContextAware {

	Logger log = LoggerFactory.getLogger(ApplicationInit.class);
	static {
		 
	// System.getProperties().put("proxySet", "true");
	// System.getProperties().put("proxyHost", "180.97.80.177");
	// System.getProperties().put("proxyPort", "8818");
	 }


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// 最优先配置上下文调用工具
		ContextUtil.setContext(applicationContext);
		
		// 开启接口检测定时任务
		IDetectInterfaceService ifs = applicationContext.getBean(IDetectInterfaceService.class);
		startDetectInterface(ifs);
		
		log.info("System init success");
	}
	
	private void startDetectInterface(IDetectInterfaceService ifs){
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
					System.out.println("【添加定时任务】开始(每"+df+"秒输出一次)...");
					// 如果启用，加入定时任务
					if(state){
						// 添加定时任务
						QuartzManager.addJob(jobName, jobGroupName, jobName, null, InterfaceDetectJob.class, detectFrequency);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("开启接口检测定时任务出错：", e);
		}
	}
	
}
