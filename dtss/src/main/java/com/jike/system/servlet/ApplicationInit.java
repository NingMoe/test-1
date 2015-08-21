package com.jike.system.servlet;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.jike.system.bean.DetectInterface;
import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.core.QuartzManager;
import com.jike.system.quartz.DatabaseDetectJob;
import com.jike.system.quartz.InterfaceDetectJob;
import com.jike.system.quartz.ResertNoticeJob;
import com.jike.system.service.itf.IDetectInterfaceService;
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
		
		// 启动接口检测定时任务
		IDetectInterfaceService idis = applicationContext.getBean(IDetectInterfaceService.class);
		startDetectInterface(idis);
		
		// 由于数据库检测的特殊性，检测数据不放在数据库表中
		// 初始化数据库检测数据
		databaseDetectInit();
		// 启动数据库检测定时任务
		startDetectDatabase();
		
		// 启动重置警报对象定时任务
		startResertNotice();
		
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
						log.info("开启接口检测["+jobName+"]定时任务出错：", e);
					}
					// 添加job连续失败次数
					InterfaceConsts.FAILURE_TIME.put(jobName, 0);
				}
			}
		}
		log.info("接口检测定时任务已启动");
	}
	
	private void databaseDetectInit(){
		log.info("初始化数据库检测数据……");
		List<String> ddList = ParamControlUtil.getDetectDbParam();
		if(!ddList.isEmpty()){
			Map<String, String> dd = null;
			for(String ddItem : ddList){
				String[] ddElements = ddItem.split(DatabaseConsts.DBDETECT_ELEMENT_SPLIT);
				// 检测各元素有效性，下阶段做，先默认全部有效
				// 添加第一个待检测数据库数据
				dd = new LinkedHashMap<String, String>();
				dd.put(DatabaseConsts.TASK_ID, ddElements[0]);
				dd.put(DatabaseConsts.TASK_GROUP_ID, StringUtil.isEmpty(ddElements[1])?DatabaseConsts.DEFAULT_GROUP:ddElements[1]); // 下一步做到检测各元素有效性方法里面
				dd.put(DatabaseConsts.DB_DRIVER, ddElements[2]);
				dd.put(DatabaseConsts.DB_URL, ddElements[3]);
				dd.put(DatabaseConsts.DB_USERNAME, ddElements[4]);
				dd.put(DatabaseConsts.DB_PASSWORD, ddElements[5]);
				dd.put(DatabaseConsts.CRON_EXPRESSION, ddElements[6]);
				dd.put(DatabaseConsts.THRESHOLD_VALUE, ddElements[7]);
				dd.put(DatabaseConsts.CURRENT_FAILURE_NUM, ddElements[8]);
				dd.put(DatabaseConsts.NOTICE_LVL, ddElements[9]);
				dd.put(DatabaseConsts.NOTICE_OBJECT, ddElements[10]);
				dd.put(DatabaseConsts.STATE, ddElements[11]);
				DatabaseConsts.DETECT_DATABASE.put(ddElements[0], dd);
			}
		}
		log.info("数据库检测数据已初始化");
	}
	
	private void startDetectDatabase(){
		log.info("启动数据库检测定时任务……");
		// 若数据库检测数据从系统静态数据取得
		for(Map<String, String> dd : DatabaseConsts.DETECT_DATABASE.values()){
			// 获取执行频率
			String cronExpression = dd.get(DatabaseConsts.CRON_EXPRESSION);
			// 获取任务名称
			String jobName = dd.get(DatabaseConsts.TASK_ID);
			// 获取任务组名称
			String jobGroupName = dd.get(DatabaseConsts.TASK_GROUP_ID);
			// 获取此数据库是否需要启用检测
			boolean state = SysConsts.DETECT_STATE_RUN.equals(dd.get(DatabaseConsts.STATE));
			// 如果启用，加入定时任务
			if(state){
				// 添加定时任务
				try {
					QuartzManager.addJob(jobName, jobGroupName, null, null, DatabaseDetectJob.class, cronExpression);
				} catch (RuntimeException e) {
					e.printStackTrace();
					log.info("开启数据库检测["+jobName+"]定时任务出错：", e);
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
