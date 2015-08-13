package com.jike.system.test;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import org.quartz.Job;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  

import com.jike.system.core.QuartzManager;

/** 
* @Description: 任务执行类 
* 
* @ClassName: QuartzJob 
* @Copyright: Copyright (c) 2014 
* 
* @author Comsys-LZP 
* @date 2014-6-26 下午03:37:11 
* @version V2.0 
*/  
public class QuartzJob implements Job {
	 public static int NUMBER = 0;
	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		if(NUMBER<4){
		 	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "★★★★★★★★★★★");
			NUMBER++;
		}else{
			QuartzManager.removeJob(jec.getJobDetail().getName());
	           System.out.println("【移除定时】成功");
		}
	}
} 