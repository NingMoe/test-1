package com.jike.system.biz;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.bean.DetectLog;
import com.jike.system.consts.SysConsts;
import com.jike.system.service.itf.IDetectDatabaseService;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.util.DBUtils;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;

@Service("databaseDetectHandler")
@Transactional
public class DatabaseDetectHandler{

	private static Logger log = LoggerFactory.getLogger(DatabaseDetectHandler.class);

	@Autowired
	private IDetectDatabaseService ddService;
	@Autowired
	private IDetectLogService dlService;
	
	public DetectDatabase selectById(String id) throws CommonException {
		return ddService.selectById(id);
	}
	
	public List<DetectDatabase> selectAll() throws CommonException {
		return ddService.selectAll();
	}
	
	/*
	 * 主要执行方法
	 */
	public void execute(DetectDatabase dd) throws CommonException {
		log.debug("主要执行方法");
		// 数据库连接驱动
		String dbDriver = dd.getDbDriver();
		// 数据库连接URL
		String dbUrl = dd.getDbUrl();
		// 数据库连接用户名
		String dbUsername = dd.getDbUsername();
		// 数据库连接密码
		String dbPassword = dd.getDbPassword();
		// 校验连接，并进行数据库，通知等操作
		boolean checkSuccess = false;
		String errorMsg = null;
		try {
			// 发送数据库连接请求
			Connection conn = DBUtils.getConnection(dbDriver, dbUrl, dbUsername, dbPassword);
			if(conn!=null){
				// 释放数据库连接
				DBUtils.closeResources(conn, null, null);
				checkSuccess = true;
			}
        } catch (RuntimeException e) {
        	errorMsg = e.getMessage();
        }
		// 记录此次检测数据
		DetectLog dl = new DetectLog();
		// 记录检测时间
		dl.setLogTime(new Date());
		// 记录检测类型
		dl.setLogType(SysConsts.LOG_TYPE_DATABASE);
		// 记录检测编号
		dl.setTaskId(dd.getTaskId());
		// 记录传递参数
		dl.setInputParams(dbDriver+"|"+dbUrl+"|"+dbUsername+"|"+dbPassword);
		// 如果校验成功
		if(checkSuccess){
			// 初始化当前检测失败次数
			dd.setCurrentFailureNum(0);
			// 记录接口检测结果:成功
			dl.setDetectResult(SysConsts.DETECT_RESULT_SUCCESS);
		}else{
			// 当前检测失败次数+1
			int failureNum = dd.getCurrentFailureNum() + 1;
			// 当前失败次数是否超过阈值
			if(failureNum > dd.getThresholdValue()){
				// 如果当日该接口未发送警报
				if(!SysConsts.CURRENT_IS_NOTICE.contains(dd.getTaskId())){
					log.info("当前失败次数已超过阈值，将发送短信提示相关人员……");
					// 发送警报
					String[] message = createSms(dd);
					SmsHandler.sendMessage(message);
					log.info("提示短信已发送");
					// 记录当日该接口已发送警报
					SysConsts.CURRENT_IS_NOTICE.add(dd.getTaskId());
					// 累计警报次数+1
					dd.setTotalNoticeNum(dd.getTotalNoticeNum() + 1);
					// 设置接口检测状态为：暂停
					dd.setState(SysConsts.DETECT_STATE_STOP);
				}
			}else{
				// 当前失败次数超过阈值不记录
				dd.setCurrentFailureNum(failureNum);
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
		ddService.updateByPrimaryKey(dd);
		dlService.insert(dl);
	}
	
	/*
	 * 解析通知对象
	 */
	public static String[] createSms(DetectDatabase dd) {
		String[] message = new String[2];
		String noticeObject = dd.getNoticeObject();
		if(StringUtil.isNotEmpty(noticeObject)){
			noticeObject = noticeObject.replace(SysConsts.NOTICE_OBJECT_SPLIT, SmsHandler.MOBILE_SPLIT);
		}
		// 组装警报对象
		message[0] = noticeObject;
		// 组装警报内容
		StringBuffer sb = new  StringBuffer();
		sb.append("系统数据库-->");
		sb.append(" URL:"+dd.getDbUrl());
		sb.append("连续"+dd.getThresholdValue()+"次连接失败！请及时查看并解决！");
		message[1] = sb.toString();
		return message;
	}
	
	/*
	 * 验证待检测数据合法性
	 */
	public static boolean vaildate(DetectDatabase di){
		boolean isLegal = false;
		
		// 待验证条件
		
		return isLegal;
	}
	
}

