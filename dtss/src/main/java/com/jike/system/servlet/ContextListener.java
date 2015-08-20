package com.jike.system.servlet;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.core.QuartzManager;

public class ContextListener implements ServletContextListener {
	
	Logger log = LoggerFactory.getLogger(ContextListener.class);

	public static final List<String> MANUAL_DESTROY_THREAD_IDENTIFIERS = Arrays.asList("BasicResourcePool");
	
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
		// 注销引用的进程
		destroySpecifyThreads();
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
	
	@SuppressWarnings("deprecation")
	private void destroySpecifyThreads() {
        final Set<Thread> threads = Thread.getAllStackTraces().keySet();
        for (Thread thread : threads) {
            if (needManualDestroy(thread)) {
                synchronized (this) {
                    try {
                        thread.destroy();
                        log.info(String.format("注销进程 %s 成功", thread));
                    } catch (Exception e) {
                    	log.warn(String.format("注销进程 %s 失败", thread), e);
                    }
                }
            }
        }
    }
	
	private boolean needManualDestroy(Thread thread) {
        final String threadName = thread.getName();
        for (String manualDestroyThreadIdentifier : MANUAL_DESTROY_THREAD_IDENTIFIERS) {
            if (threadName.contains(manualDestroyThreadIdentifier)) {
                return true;
            }
        }
        return false;
    }
}
