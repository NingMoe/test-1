package com.jike.system.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.core.QuartzManager;

public class ShutdownQuartz implements ServletContextListener {

	Logger log = LoggerFactory.getLogger(ShutdownQuartz.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("DTSS 启动成功");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("准备关闭Quartz");
		try {
			if(QuartzManager.isStart()){
				QuartzManager.shutdown();
				log.info("正在关闭Quartz...");
				Thread.sleep(1000);
				if(QuartzManager.isShutdown()){
					log.info("Quartz已关闭！");
				}
			}
		} catch (InterruptedException e) {  
			throw new RuntimeException(e);  
		}
		log.info("DTSS 关闭成功");
	}
}
