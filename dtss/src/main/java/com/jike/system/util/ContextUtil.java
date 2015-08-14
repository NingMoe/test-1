package com.jike.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


/**
 * Title:上下文调用工具
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2010-3-8
 * 
 * 
 * @version 1.0
 */
public class ContextUtil {
	
	private static Logger log = LoggerFactory.getLogger(ContextUtil.class);
	
	private static ApplicationContext context;
	
	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
	/**
	 * 获得sping对象
	 * @param id
	 * @return
	 */
	public static Object getBean(String id) {
		Object obj = context.getBean(id);
		if(obj == null) {
			log.info("bean id [ " + id + " ] not found in context path");
		}
		return obj;
	}
}
