package com.jike.system.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.bean.DetectLog;
import com.jike.system.biz.itf.IDatabaseDetectBiz;
import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.core.QuartzManager;
import com.jike.system.model.DetectDatabaseModel;
import com.jike.system.quartz.DatabaseDetectJob;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.util.DBUtils;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;

@Service("databaseDetectBiz")
@Transactional
public class DatabaseDetectBiz implements IDatabaseDetectBiz {

	private static Logger log = LoggerFactory.getLogger(DatabaseDetectBiz.class);
	
	@Autowired
	private IDetectLogService dlService;

	@Override
	public List<DetectDatabaseModel> selectByExample(DetectDatabaseModel ddm)
			throws CommonException {
		List<DetectDatabaseModel> ddms = new ArrayList<DetectDatabaseModel>();
		if(StringUtil.isNotEmpty(ddm.getTaskId())){
			ddms.add(DatabaseConsts.DETECT_DATABASE.get(ddm.getTaskId()));
		}else{
			ddms.addAll(DatabaseConsts.DETECT_DATABASE.values());
		}
		if(ddms.size() > 0){
			for(DetectDatabaseModel ddme : ddms){
				ddm.setCurrentIsNotice(SysConsts.CURRENT_IS_NOTICE.contains(ddme.getTaskId()));
			}
		}
		return ddms;
	}

	@Override
	public DetectDatabaseModel add(DetectDatabaseModel ddm) throws CommonException {
		// 新创建之前验证信息
		vaildate(ddm);

		return ddm;
	}

	@Override
	public DetectDatabaseModel switchState(DetectDatabaseModel ddm) throws CommonException {
		if(StringUtil.isEmpty(ddm.getTaskId())){
			throw new CommonException("数据库检测数据--任务编号不能为空");
		}
		DetectDatabaseModel ddme = DatabaseConsts.DETECT_DATABASE.get(ddm.getTaskId());
		String jobName = ddme.getTaskId();
		String jobGroupName = (ddme.getTaskGroupId()==null?DatabaseConsts.DEFAULT_GROUP:ddme.getTaskGroupId());
		String triggerName =  ddme.getTaskId();
		String triggerGroupName = DatabaseConsts.DEFAULT_GROUP;
		// 获取当前检测状态
		String currentState = ddme.getState();
		// 获取转换检测状态
		String toState = ddm.getToState();
		if(SysConsts.DETECT_STATE_CLOSE.equals(toState)){
			if(SysConsts.DETECT_STATE_CLOSE.equals(currentState))
				throw new CommonException("接口检测任务["+jobName+"]--已关闭，请刷新！");
			// 关闭任务
			ddme.setState(toState);
			QuartzManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
		}
		else if(SysConsts.DETECT_STATE_RUN.equals(toState)){
			if(SysConsts.DETECT_STATE_RUN.equals(currentState))
				throw new CommonException("接口检测任务["+jobName+"]--已启动，请刷新！");
			// 启动任务
			ddme.setState(toState);
			if(QuartzManager.vaildateTriggerExist(triggerName, triggerGroupName)){
				QuartzManager.resume(triggerName, triggerGroupName);
			}else{
				QuartzManager.addSimpleJob(jobName, jobGroupName, triggerName, triggerGroupName, 
						DatabaseDetectJob.class, null, null, SimpleTrigger.REPEAT_INDEFINITELY, ddme.getFrequency());
				// 添加job连续失败次数
				InterfaceConsts.FAILURE_TIME.put(jobName, 0);
			}
		}
		else if(SysConsts.DETECT_STATE_STOP.equals(toState)){
			if(!SysConsts.DETECT_STATE_RUN.equals(currentState))
				throw new CommonException("接口检测任务["+jobName+"]--未启动，请刷新！");
			// 暂停任务
			ddme.setState(toState);
			QuartzManager.pause(triggerName, triggerGroupName);
		}
		return ddme;
	}

	@Override
	public void reset(String id) throws CommonException {
		SysConsts.CURRENT_IS_NOTICE.remove(id);
		InterfaceConsts.FAILURE_TIME.put(id, 0);
	}
	
	/*
	 * 主要执行方法
	 */
	@Override
	public void execute(DetectDatabaseModel ddm) throws CommonException {
		log.debug("主要执行方法");
		// 任务编号
		String taskId = ddm.getTaskId();
		// 数据库连接驱动
		String dbDriver = ddm.getDbDriver();
		// 数据库连接URL
		String dbUrl = ddm.getDbUrl();
		// 数据库连接用户名
		String dbUsername = ddm.getDbUsername();
		// 数据库连接密码
		String dbPassword = ddm.getDbPassword();
		// 校验连接，并进行数据库，通知等操作
		boolean checkSuccess = false;
		String errorMsg = null;
		Connection conn = null;
		try {
			// 发送数据库连接请求
			conn = DBUtils.getConnection(dbDriver, dbUrl, dbUsername, dbPassword);
			if(conn!=null){
				// 验证通过
				checkSuccess = true;
			}
        } catch (RuntimeException e) {
        	errorMsg = e.getMessage();
        } finally {
        	// 释放数据库连接
			DBUtils.closeResources(conn, null, null);
        }
		// 记录此次检测数据
		DetectLog dl = new DetectLog();
		// 记录检测时间
		dl.setLogTime(new Date());
		// 记录检测类型
		dl.setLogType(SysConsts.LOG_TYPE_DATABASE);
		// 记录检测编号
		dl.setTaskId(taskId);
		// 记录传递参数
		dl.setInputParams(dbDriver+"|"+dbUrl+"|"+dbUsername+"|"+dbPassword);
		// 如果校验成功
		if(checkSuccess){
			// 初始化当前检测失败次数
			ddm.setCurrentFailureNum(0);
			// 记录接口检测结果:成功
			dl.setDetectResult(SysConsts.DETECT_RESULT_SUCCESS);
		}else{
			// 当前检测失败次数+1
			int failureNum = ddm.getCurrentFailureNum() + 1;
			// 当前失败次数是否超过阈值
			if(failureNum > ddm.getThresholdValue()){
				// 如果当日该数据库检测未发送警报
				if(!SysConsts.CURRENT_IS_NOTICE.contains(taskId)){
					log.info("当前失败次数已超过阈值，将发送短信提示相关人员……");
					// 发送警报
					String[] message = createSms(ddm);
					SmsHandler.sendMessage(message);
					log.info("提示短信已发送");
					// 记录当日该数据库检测已发送警报
					SysConsts.CURRENT_IS_NOTICE.add(taskId);
					// 设置数据库检测状态为：关闭
					ddm.setState(SysConsts.DETECT_STATE_CLOSE);
					// 切换数据库检测状态
					String jobName = ddm.getTaskId();
					String jobGroupName = (ddm.getTaskGroupId()==null?DatabaseConsts.DEFAULT_GROUP:ddm.getTaskGroupId());
					String triggerName =  ddm.getTaskId();
					String triggerGroupName = DatabaseConsts.DEFAULT_GROUP;
					QuartzManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
				}
			}else{
				// 当前失败次数超过阈值不记录
				ddm.setCurrentFailureNum(failureNum);;
			}
			// 记录接口检测结果:失败
			dl.setDetectResult(SysConsts.DETECT_RESULT_FAILURE);
			// 记录错误信息
			try {
				dl.setErrorInfo(StringUtil.subStrb(errorMsg, 500, SysConsts.DATABASE_ENCODING));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 更新到数据库
		dlService.insert(dl);
	}
	
	/*
	 * 解析通知对象
	 */
	public static String[] createSms(DetectDatabaseModel ddm) {
		String[] message = new String[2];
		String noticeObject = ddm.getNoticeObject();
		if(StringUtil.isNotEmpty(noticeObject)){
			noticeObject = noticeObject.replace(SysConsts.NOTICE_OBJECT_SPLIT, SmsHandler.MOBILE_SPLIT);
		}
		// 组装警报对象
		message[0] = noticeObject;
		// 组装警报内容
		StringBuffer sb = new  StringBuffer();
		sb.append("系统数据库-->");
		sb.append(" URL:"+ddm.getDbUrl());
		sb.append("连续"+ddm.getThresholdValue()+"次连接失败！请及时查看并解决！");
		message[1] = sb.toString();
		return message;
	}
	
	/*
	 * 验证待检测数据合法性
	 */
	public void vaildate(DetectDatabaseModel ddm){
		if(StringUtil.isEmpty(ddm.getTaskId())){
			throw new CommonException("数据库检测数据--任务编号不能为空");
		}
		if(StringUtil.isEmpty(ddm.getDbDriver())){
			throw new CommonException("数据库检测数据--数据库连接驱动不能为空");
		}
		if(StringUtil.isEmpty(ddm.getDbUrl())){
			throw new CommonException("数据库检测数据--数据库连接URL不能为空");
		}
		if(StringUtil.isEmpty(ddm.getDbUsername())){
			throw new CommonException("数据库检测数据--数据库连接用户名不能为空");
		}
		if(StringUtil.isEmpty(ddm.getDbPassword())){
			throw new CommonException("数据库检测数据--数据库连接密码不能为空");
		}
		if(ddm.getFrequency() == null){
			throw new CommonException("数据库检测数据--检测频率不能为空");
		}
		if(ddm.getThresholdValue() == null){
			throw new CommonException("数据库检测数据--阈值不能为空");
		}
		if(StringUtil.isEmpty(ddm.getNoticeObject())){
			throw new CommonException("数据库检测数据--警报对象不能为空");
		}
	}
	
}

