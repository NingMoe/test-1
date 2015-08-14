package com.jike.system.servlet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.alibaba.fastjson.JSON;
import com.jike.system.bean.DetectInterface;
import com.jike.system.core.QuartzManager;
import com.jike.system.model.DetectInterfaceModel;
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
					// 执行频率
					int df = di.getDetectFrequency();
					String detectFrequency = "*/"+df+" * * * * ?";
					// 任务名称
					String job_name = di.getItfId();
					System.out.println("【添加定时任务】开始(每"+df+"秒输出一次)...");
			        QuartzManager.addJob(job_name, InterfaceDetectJob.class, detectFrequency);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("开启接口检测定时任务出错：", e);
		}
	}
	
}
