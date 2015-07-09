package org.flyingmemory.base.util;

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
	
	private static ApplicationContext context;
	
	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
	/**
	 * @return the context
	 */
	public static ApplicationContext getContext() {
		return context;
	}
	/**
	 * 获得sping对象
	 * @param id
	 * @return
	 */
	public static Object getBean(String id) {
		Object obj = context.getBean(id);
		if(obj == null) {
		}
		return obj;
	}
}
