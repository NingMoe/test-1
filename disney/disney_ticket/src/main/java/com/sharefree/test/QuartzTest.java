package com.sharefree.test;

import java.util.Date;

import com.sharefree.utils.QuartzManager;

/**
 * 一个简单的测试quartz任务管理器测试类
 */
public class QuartzTest {

	public static void main(String[] args) throws Exception {

		System.out.println("start time:" + new Date());
		// QuartzManager.addCalendar("testTrigger", "16:07", "16:08");
		QuartzManager.addSimpleJob("testJob", "testJobGroup", "testTrigger", "testTriggerGroup", QuartzJob.class, null, null, -1, 3, null);
		// QuartzManager.addCronJob("testJob", "testJobGroup", "testTrigger",
		// "testTriggerGroup", QuartzJob.class, null, null, "0/2 * * * * ?");
		QuartzManager.start();
		// System.out.println("sleep: 90 second");
		Thread.sleep(30000);
		QuartzManager.updateSimpleJob("testTrigger", "testTriggerGroup", 5, null);
		// QuartzManager.updateCronJob("testTrigger", "testTriggerGroup",
		// "0/4 * * * * ?");
		System.out.println("sleep: 15 second");
		Thread.sleep(30000);
		QuartzManager.pause("testTrigger", "testTriggerGroup");
		Thread.sleep(20000);
		QuartzManager.resume("testTrigger", "testTriggerGroup");
		Thread.sleep(18000);
		// Thread.sleep(180000);
		// System.out.println("no stop time:" + new Date());
		QuartzManager.shutdown();
	}
}