package com.jike.system.test;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	  
    private static Logger _log = LoggerFactory.getLogger(QuartzJob.class);
  
    public QuartzJob() {  
    }  
  
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.info("Hello World! - " + new Date());  
    }  
  
} 