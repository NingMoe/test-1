package com.jike.system.servlet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.bean.DetectInterface;
import com.jike.system.consts.SysConsts;
import com.jike.system.core.QuartzManager;
import com.jike.system.quartz.DatabaseDetectJob;
import com.jike.system.quartz.InterfaceDetectJob;
import com.jike.system.quartz.ResertNoticeJob;
import com.jike.system.service.itf.IDetectDatabaseService;
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.util.ContextUtil;


public class ApplicationInit implements ApplicationContextAware {

	Logger log = LoggerFactory.getLogger(ApplicationInit.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// 最优先配置上下文调用工具
		ContextUtil.setContext(applicationContext);
		
		// 启动接口检测定时任务
		IDetectInterfaceService idis = applicationContext.getBean(IDetectInterfaceService.class);
		startDetectInterface(idis);
		
		// 启动数据库检测定时任务
		IDetectDatabaseService idds = applicationContext.getBean(IDetectDatabaseService.class);
		startDetectDatabase(idds);
		
		// 启动重置警报对象定时任务
		startResertNotice();
		
		log.info("DTSS 启动成功");
	}
	
	private void startDetectInterface(IDetectInterfaceService idis){
		log.info("启动接口检测定时任务……");
		List<DetectInterface> dis = idis.selectAll();
		if(!dis.isEmpty()){
			for(DetectInterface di: dis){
				// 获取执行频率
				String cronExpression = di.getCronExpression();
				// 获取任务名称
				String jobName = di.getTaskId();
				// 获取任务组名称
				String jobGroupName = di.getTaskGroupId();
				// 获取此接口是否需要启用检测
				boolean state = SysConsts.DETECT_STATE_RUN.equals(di.getState());
				// 如果启用，加入定时任务
				if(state){
					// 添加定时任务
					try {
						QuartzManager.addJob(jobName, jobGroupName, null, null, InterfaceDetectJob.class, cronExpression);
					} catch (RuntimeException e) {
						e.printStackTrace();
						log.info("开启接口"+jobName+"检测定时任务出错：", e);
					}
				}
			}
		}
		log.info("接口检测定时任务已启动");
	}
	
	private void startDetectDatabase(IDetectDatabaseService idds){
		log.info("启动数据库检测定时任务……");
		List<DetectDatabase> dds = idds.selectAll();
		if(!dds.isEmpty()){
			for(DetectDatabase dd: dds){
				// 获取执行频率
				String cronExpression = dd.getCronExpression();
				// 获取任务名称
				String jobName = dd.getTaskId();
				// 获取任务组名称
				String jobGroupName = dd.getTaskGroupId();
				// 获取此数据库是否需要启用检测
				boolean state = SysConsts.DETECT_STATE_RUN.equals(dd.getState());
				// 如果启用，加入定时任务
				if(state){
					// 添加定时任务
					try {
						QuartzManager.addJob(jobName, jobGroupName, null, null, DatabaseDetectJob.class, cronExpression);
					} catch (RuntimeException e) {
						e.printStackTrace();
						log.info("开启数据库"+jobName+"检测定时任务出错：", e);
					}
				}
			}
		}
		log.info("数据库检测定时任务已启动");
	}
	
	private void startResertNotice(){
		log.info("启动重置警报对象定时任务……");
		// 获取任务名称
		String jobName = ResertNoticeJob.JOB_NAME;
		// 执行频率
		String cronExpression = ResertNoticeJob.RESET_CRON_EXPRESSION;
		// 添加定时任务
		try {
			QuartzManager.addJob(jobName, ResertNoticeJob.class, cronExpression);
		} catch (RuntimeException e) {
			e.printStackTrace();
			log.info("开启重置警报对象任务出错：", e);
		}
		log.info("重置警报对象任务已启动");
	}
	
}
