package com.jike.system.core;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerKey;
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
	
	// 单例模式
	private static  Scheduler scheduler = getScheduler();
	   
	private static String DEFAULT_JOB_GROUP = "DEFAULT_JOB_GROUP";
	private static String DEFAULT_TRIGGER_GROUP = "DEFAULT_TRIGGER_GROUP";
	
    // 下一个第15秒 例:  
    //           当前 10秒,则 执行时间为15秒  
    //           当前 16秒,则 执行时间为30秒  
    //           当前 33秒,则 执行时间为45秒  
    //           当前 48秒,则 执行时间为00秒
	private static Date getStartTime() {
		return DateBuilder.nextGivenSecondDate(null, 15);
	}
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
	
	/**
	 * @Description: 获取一个调度对象
	 * @return
	 */
	public static Scheduler getInstanceScheduler() {
		return scheduler;
	}
	
	/**
	 * @Description: 验证一个任务是否存在
	 * @param jobName
	 * @param jobGroupName
	 * @return
	 */
	public static boolean vaildateJobExist(String jobName, String jobGroupName) {
		try {
			JobKey jobKey = new JobKey(jobName, jobGroupName);
			return scheduler.checkExists(jobKey);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @Description: 验证一个触发器是否存在
	 * @param jobName
	 * @param jobGroupName
	 * @return
	 */
	public static boolean vaildateTriggerExist(String triggerName, String triggerGroupName) {
		try {
			TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
			return scheduler.checkExists(triggerKey);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 添加一个简单定时任务
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * @param jobClass
	 * @param startTime
	 * @param endTime
	 * @param repeatCount
	 * @param repeatInterval
	 */
	public static void addSimpleJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, 
			Class<? extends Job> jobClass, Date startTime, Date endTime, int repeatCount, int repeatInterval) {
		if(StringUtil.isEmpty(jobGroupName))
			jobGroupName = DEFAULT_JOB_GROUP;
		if(StringUtil.isEmpty(triggerName))
			triggerName = jobName;
		if(StringUtil.isEmpty(triggerGroupName))
			triggerGroupName = DEFAULT_TRIGGER_GROUP;
		JobDetail jobDetail = newJob(jobClass).withIdentity(jobName, jobGroupName).build();
		SimpleTrigger trigger = newTrigger().withIdentity(triggerName, triggerGroupName)
				.startAt(startTime==null?getStartTime():startTime)
				.withSchedule(
						simpleSchedule()
						.withRepeatCount(repeatCount)
						.withIntervalInSeconds(repeatInterval))
				.build();
		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * @Description: 添加一个cronExpression表达式定时任务
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * @param jobClass
	 * @param cronExpression
	 */
	public static void addCronJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, 
			Class<? extends Job> jobClass, Date startTime, Date endTime, String cronExpression) {
		if(StringUtil.isEmpty(jobGroupName))
			jobGroupName = DEFAULT_JOB_GROUP;
		if(StringUtil.isEmpty(triggerName))
			triggerName = jobName;
		if(StringUtil.isEmpty(triggerGroupName))
			triggerGroupName = DEFAULT_TRIGGER_GROUP;
		JobDetail jobDetail = newJob(jobClass).withIdentity(jobName, jobGroupName).build();
		CronTrigger trigger = newTrigger().withIdentity(triggerName, triggerGroupName)
				.startAt(startTime==null?getStartTime():startTime)
				.withSchedule(
						cronSchedule(cronExpression))
				.build();
		try {
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
	public static void updateSimpleJob(String triggerName, String triggerGroupName, int newRepeatInterval) {
		try {
			if(StringUtil.isEmpty(triggerGroupName))
				triggerGroupName = DEFAULT_TRIGGER_GROUP;
			TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
			SimpleTrigger trigger = (SimpleTrigger) scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}
			Long oldRepeatInterval = trigger.getRepeatInterval();
			if (oldRepeatInterval != newRepeatInterval) {
				SimpleTrigger newTrigger = newTrigger().withIdentity(triggerKey)
						.withSchedule(
								simpleSchedule()
								.withIntervalInSeconds(newRepeatInterval)
								.withRepeatCount(trigger.getRepeatCount()))
						.build();
				scheduler.rescheduleJob(triggerKey, newTrigger);
			}
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
	public static void updateCronJob(String triggerName, String triggerGroupName, String newCronExpression) {
		try {
			if(StringUtil.isEmpty(triggerGroupName))
				triggerGroupName = DEFAULT_TRIGGER_GROUP;
			TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}
			String oldCronExpression = trigger.getCronExpression();
			if (oldCronExpression != newCronExpression) {
				CronTrigger newTrigger = newTrigger().withIdentity(triggerKey)
						.withSchedule(
								cronSchedule(newCronExpression))
						.build();
				scheduler.rescheduleJob(triggerKey, newTrigger);
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
/*		try {
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
		}*/
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


   /**
    * @Description:启动所有定时任务
    */
	public static boolean isShutdown() {
		try {
			return scheduler.isShutdown();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

