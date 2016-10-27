package com.sharefree.test;

import java.util.Date;

import com.sharefree.utils.DateUtil;
import com.sharefree.utils.ThreadPoolUtil;

public class ThreadPoolTest {

	public static void main(String[] args) {
		for (int i = 0; i < 15; i++) {
			TestTask testTask = new TestTask(i);
			ThreadPoolUtil.execute(testTask);
			System.out.println("[" + DateUtil.parseDateToString(new Date(), DateUtil.FORMAT7) + "]线程池中线程数目：" + ThreadPoolUtil.getPoolSize() + "，队列中等待执行的任务数目："
					+ ThreadPoolUtil.getQueueSize() + "，已执行玩别的任务数目：" + ThreadPoolUtil.getCompletedTaskCount());
		}
	}
}
