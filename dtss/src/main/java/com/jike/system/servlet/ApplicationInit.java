package com.jike.system.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ApplicationInit implements ApplicationContextAware {

	Logger log = LoggerFactory.getLogger(ApplicationInit.class);
	public static String FLAG = "0";
	static {
		 
	// System.getProperties().put("proxySet", "true");
	// System.getProperties().put("proxyHost", "180.97.80.177");
	// System.getProperties().put("proxyPort", "8818");
	 }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		FLAG = "CHANGE";
		System.out.println("##########  "+FLAG+"  ##########");
		
		log.info("System init success");
	}
}
