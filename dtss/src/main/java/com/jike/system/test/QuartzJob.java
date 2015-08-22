package com.jike.system.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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
	  
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	// job 的名字  
        String jobName = context.getJobDetail().getKey().getName();  
          
        // 任务执行的时间  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");  
        String jobRunTime = dateFormat.format(Calendar.getInstance().getTime());  
          
        // 输出任务执行情况  
        System.out.println("任务 : " + jobName + " 在  " +jobRunTime + " 执行了 ");
    }  
  
} 