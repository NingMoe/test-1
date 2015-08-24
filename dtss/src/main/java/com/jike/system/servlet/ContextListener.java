package com.jike.system.servlet;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.core.QuartzManager;

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
		// 注销JDBC驱动
		destroyJDBCDrivers();
	}
	
	private void destroyQuartz() {
		log.info("准备注销Quartz");
		try {
			QuartzManager.shutdown();
			log.info("正在注销Quartz...");
			Thread.sleep(1000);
			if(QuartzManager.isShutdown()){
				log.info("Quartz已注销！");
			}
		} catch (InterruptedException e) {  
			throw new RuntimeException(e);  
		}
		log.info("DTSS 注销成功");
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
