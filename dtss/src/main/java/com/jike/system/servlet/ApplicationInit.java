package com.jike.system.servlet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.jike.system.consts.DatabaseConsts;
import com.jike.system.core.QuartzManager;
import com.jike.system.model.DetectDatabaseModel;
import com.jike.system.quartz.ResertNoticeJob;
import com.jike.system.util.ContextUtil;
import com.jike.system.util.ParamControlUtil;
import com.jike.system.util.StringUtil;


public class ApplicationInit implements ApplicationContextAware {

	Logger log = LoggerFactory.getLogger(ApplicationInit.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// 最优先配置上下文调用工具
		ContextUtil.setContext(applicationContext);
		
		// 由于数据库检测的特殊性，检测数据不放在数据库表中
		// 初始化数据库检测数据
		databaseDetectInit();
		
		// 启动重置警报对象定时任务
		startResertNotice();
		
		// 启动调度
		QuartzManager.start();
	}
	
	private void databaseDetectInit(){
		log.info("初始化数据库检测数据……");
		List<String> ddList = ParamControlUtil.getDetectDbParam();
		if(!ddList.isEmpty()){
			DetectDatabaseModel dd = null;
			for(String ddItem : ddList){
				String[] ddElements = ddItem.split(DatabaseConsts.DBDETECT_ELEMENT_SPLIT);
				// 检测各元素有效性，下阶段做，先默认全部有效
				// 添加第一个待检测数据库数据
				dd = new DetectDatabaseModel();
				dd.setTaskId(ddElements[0]);
				dd.setTaskGroupId(StringUtil.isEmpty(ddElements[1])?DatabaseConsts.DEFAULT_GROUP:ddElements[1]);
				dd.setDbDriver(ddElements[2]);
				dd.setDbUrl(ddElements[3]);
				dd.setDbUsername(ddElements[4]);
				dd.setDbPassword(ddElements[5]);
				dd.setFrequency(Integer.valueOf(ddElements[6]));
				dd.setThresholdValue(Integer.valueOf(ddElements[7]));
				dd.setCurrentFailureNum(Integer.valueOf(ddElements[8]));
				dd.setNoticeLvl(ddElements[9]);
				dd.setNoticeObject(ddElements[10]);
				dd.setState(ddElements[11]);
				DatabaseConsts.DETECT_DATABASE.put(ddElements[0], dd);
			}
		}
		log.info("数据库检测数据已初始化");
	}
	
	private void startResertNotice(){
		log.info("启动重置警报对象定时任务……");
		// 获取任务名称
		String jobName = ResertNoticeJob.JOB_NAME;
		// 执行频率
		String cronExpression = ResertNoticeJob.RESET_CRON_EXPRESSION;
		// 添加定时任务
		try {
			QuartzManager.addCronJob(jobName, null, jobName, null, ResertNoticeJob.class, null, null, cronExpression);
		} catch (RuntimeException e) {
			e.printStackTrace();
			log.info("开启重置警报对象任务出错：", e);
		}
		log.info("重置警报对象任务已启动");
	}
	
}
