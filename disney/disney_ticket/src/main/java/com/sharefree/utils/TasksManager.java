package com.sharefree.utils;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.nutz.lang.Tasks;
import org.quartz.DateBuilder;

public class TasksManager {

	public static ScheduledThreadPoolExecutor scheduler = Tasks.getTaskScheduler();

	// 下一个第15秒 例: getStartTime(15)
	// 当前 10秒,则 执行时间为15秒
	// 当前 16秒,则 执行时间为30秒
	// 当前 33秒,则 执行时间为45秒
	// 当前 48秒,则 执行时间为00秒
	public static Date getStartTime(int secondBase) {
		return DateBuilder.nextGivenSecondDate(null, secondBase);
	}

	public static void addTask(Runnable task, int period) {
		Tasks.scheduleAtFixedRate(task, getStartTime(10), period, TimeUnit.SECONDS);
	}

	public static void addTask(Runnable task, Date startTime, long period, TimeUnit unit) {
		if (unit == null)
			unit = TimeUnit.SECONDS;
		Tasks.scheduleAtFixedRate(task, startTime, period, unit);
	}

	public static void restartTask(Runnable task, int period) {
		scheduler.remove(task);
		scheduler.purge();
		Tasks.depose();
		Tasks.reset();
		Tasks.scheduleAtFixedRate(task, getStartTime(10), period, TimeUnit.SECONDS);
	}

}
