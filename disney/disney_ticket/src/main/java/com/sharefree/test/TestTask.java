package com.sharefree.test;

import java.util.Date;

import com.sharefree.utils.DateUtil;

public class TestTask implements Runnable {

	private int taskNum;

	public TestTask(int num) {
		this.taskNum = num;
	}

	@Override
	public void run() {
		System.out.println("[" + DateUtil.parseDateToString(new Date(), DateUtil.FORMAT7) + "]正在执行task " + taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[" + DateUtil.parseDateToString(new Date(), DateUtil.FORMAT7) + "]task " + taskNum + "执行完毕");
	}

}
