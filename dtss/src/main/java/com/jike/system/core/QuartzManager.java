package com.jike.system.core;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.jike.system.util.StringUtil;

/**
 *
 * Title: QuartzManager
 *
 * Description: 定时任务管理类
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 12, 2015
 *
 */
public class QuartzManager {
	
	private static  Scheduler scheduler = getScheduler();
	   
	private static String DEFAULT_JOB_GROUP = "DEFAULT_JOB_GROUP";
	private static String DEFAULT_TRIGGER_GROUP = "DEFAULT_TRIGGER_GROUP";
	
	/**
	 * @Description: 创建一个调度对象
	 * @return
	 * @throws SchedulerException
	 */
	private static Scheduler getScheduler() {
		    SchedulerFactory sf = new StdSchedulerFactory();
	        Scheduler scheduler=null;
			try {
				scheduler = sf.getScheduler();
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
	        return scheduler;
	}
	
	public static Scheduler getInstanceScheduler() {
		return scheduler;
	}
	
	/**
	 * @Description: 验证一个任务是否存在
	 * @param jobName
	 * @return
	 */
	public static boolean vaildateJobExist(String jobName, String jobGroupName) {
		try {
			boolean isExist = false;
			JobDetail jobDetail = null;
			CronTrigger trigger = null;
			if(StringUtil.isNotEmpty(jobGroupName)){
				jobDetail = scheduler.getJobDetail(jobName, jobGroupName);
			}else{
				trigger = (CronTrigger) scheduler.getTrigger(jobName,DEFAULT_TRIGGER_GROUP);
			}
			if (jobDetail != null || trigger != null) {
				isExist = true;
			}
			return isExist;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 添加一个定时任务，使用默认的任务组名，触发器组名
	 * @param jobName
	 * @param cls
	 * @param time
	 */
	public static void addJob(String jobName, Class<?> jobClass, String time) {
		try {
			JobDetail jobDetail = new JobDetail(jobName, DEFAULT_JOB_GROUP, jobClass);// 任务名，任务组，任务执行类
			CronTrigger trigger = new CronTrigger(jobName, DEFAULT_TRIGGER_GROUP);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 添加一个定时任务
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * @param jobClass
	 * @param time
	 */
	public static void addJob(String jobName, String jobGroupName, 
			String triggerName, String triggerGroupName, Class<?> jobClass, 
			String time) {
		if(StringUtil.isEmpty(jobGroupName))
			jobGroupName = DEFAULT_JOB_GROUP;
		if(StringUtil.isEmpty(triggerName))
			triggerName = jobName;
		if(StringUtil.isEmpty(triggerGroupName))
			triggerGroupName = DEFAULT_TRIGGER_GROUP;
		try {
			JobDetail jobDetail = new JobDetail(jobName, jobGroupName, jobClass);// 任务名，任务组，任务执行类
			CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

   /**
    * @Description: 修改一个任务的触发时间
    *
    * @param triggerName
    * @param triggerGroupName
    * @param time
    *
    * @Title: QuartzManager.java
    * @Copyright: Copyright (c) 2014
    *
    * @author Comsys-LZP
    * @date 2014-6-26 下午03:49:37
    * @version V2.0
    */
	public static void modifyJobTime(String triggerName, String triggerGroupName, String newTime) {
		try {
			if(StringUtil.isEmpty(triggerGroupName))
				triggerGroupName = DEFAULT_TRIGGER_GROUP;
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerName,triggerGroupName);
			if (trigger == null) {
				return;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(newTime)) {
				// 修改时间
				trigger.setCronExpression(newTime);
				// 重启触发器
				scheduler.resumeTrigger(triggerName, triggerGroupName);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 移除一个任务
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 */
	public static void removeJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName) {
		try {
			if(StringUtil.isEmpty(jobGroupName))
				jobGroupName = DEFAULT_JOB_GROUP;
			if(StringUtil.isEmpty(triggerName))
				triggerName = jobName;
			if(StringUtil.isEmpty(triggerGroupName))
				triggerGroupName = DEFAULT_TRIGGER_GROUP;
			scheduler.pauseTrigger(triggerName, triggerGroupName);// 停止触发器
			scheduler.unscheduleJob(triggerName, triggerGroupName);// 移除触发器
			scheduler.deleteJob(jobName, jobGroupName);// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

   /**
    * @Description:启动所有定时任务
    */
	public static void start() {
		try {
			if (!scheduler.isStarted())
				scheduler.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

   /**
    * @Description:启动所有定时任务
    */
	public static boolean isStart() {
		try {
			return scheduler.isStarted();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:暂停所有定时任务
	 */
	public static void pauseAll() {
		try {
			if (scheduler.isStarted())
				scheduler.pauseAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:恢复所有定时任务
	 */
	public static void resumeAll() {
		try {
			if (scheduler.isStarted())
				scheduler.resumeAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:关闭所有定时任务
	 */
	public static void shutdown() {
		try {
			if (!scheduler.isShutdown())
				scheduler.shutdown();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

