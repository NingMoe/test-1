package com.jike.system.servlet;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.biz.itf.IInterfaceDetectBiz;
import com.jike.system.core.QuartzManager;
import com.jike.system.util.ContextUtil;

public class ContextListener implements ServletContextListener {
	
	Logger log = LoggerFactory.getLogger(ContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("DTSS 启动成功");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 注销Quartz
		destroyQuartz();
		// 所有任务对应数据库状态设置为关闭
		closeAllTask();
		// 注销JDBC驱动
		destroyJDBCDrivers();
		
		log.info("DTSS 注销成功");
	}
	
	private void destroyQuartz() {
		log.info("准备注销Quartz");
		try {
			log.info("正在注销Quartz...");
			QuartzManager.shutdown();
			Thread.sleep(1000);
			if(QuartzManager.isShutdown()){
				log.info("Quartz已注销！");
			}
		} catch (InterruptedException e) {  
			throw new RuntimeException(e);  
		}
    }
	
	private void closeAllTask() {
		log.info("准备关闭所有任务");
		IInterfaceDetectBiz idBiz = (IInterfaceDetectBiz) ContextUtil.getBean("interfaceDetectBiz");
		try {
			log.info("正在关闭所有任务...");
			idBiz.closeAllTask();
			Thread.sleep(1000);
			if(QuartzManager.isShutdown()){
				log.info("所有任务已关闭！");
			}
		} catch (InterruptedException e) {  
			throw new RuntimeException(e);  
		}
    }
	
	private void destroyJDBCDrivers() {
		log.info("准备注销JDBC驱动");
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver;
        while (drivers.hasMoreElements()) {  
            driver = drivers.nextElement();  
            try {  
                DriverManager.deregisterDriver(driver);  
                log.info(String.format("注销JDBC驱动 %s 成功", driver));
            } catch (SQLException e) {  
            	log.warn(String.format("注销JDBC驱动 %s 失败", driver), e);  
            }  
        }  
    }
	
}
