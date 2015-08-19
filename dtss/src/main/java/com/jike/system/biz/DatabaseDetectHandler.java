package com.jike.system.biz;

import java.sql.Connection;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.bean.DetectLog;
import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.util.DBUtils;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;

@Service("databaseDetectHandler")
@Transactional
public class DatabaseDetectHandler{

	private static Logger log = LoggerFactory.getLogger(DatabaseDetectHandler.class);
	
	@Autowired
	private IDetectLogService dlService;
	
	/*
	 * 主要执行方法
	 */
	public void execute(Map<String, String> dd) throws CommonException {
		log.debug("主要执行方法");
		// 任务编号
		String taskId = dd.get(DatabaseConsts.TASK_ID);
		// 数据库连接驱动
		String dbDriver = dd.get(DatabaseConsts.DB_DRIVER);
		// 数据库连接URL
		String dbUrl = dd.get(DatabaseConsts.DB_URL);
		// 数据库连接用户名
		String dbUsername = dd.get(DatabaseConsts.DB_USERNAME);
		// 数据库连接密码
		String dbPassword = dd.get(DatabaseConsts.DB_PASSWORD);
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
			dd.put(DatabaseConsts.CURRENT_FAILURE_NUM, "0");
			// 记录接口检测结果:成功
			dl.setDetectResult(SysConsts.DETECT_RESULT_SUCCESS);
		}else{
			// 当前检测失败次数+1
			int failureNum = Integer.parseInt(dd.get(DatabaseConsts.CURRENT_FAILURE_NUM)) + 1;
			// 当前失败次数是否超过阈值
			if(failureNum > Integer.parseInt(dd.get(DatabaseConsts.THRESHOLD_VALUE))){
				// 如果当日该接口未发送警报
				if(!SysConsts.CURRENT_IS_NOTICE.contains(taskId)){
					log.info("当前失败次数已超过阈值，将发送短信提示相关人员……");
					// 发送警报
					String[] message = createSms(dd);
					SmsHandler.sendMessage(message);
					log.info("提示短信已发送");
					// 记录当日该接口已发送警报
					SysConsts.CURRENT_IS_NOTICE.add(taskId);
					// 设置接口检测状态为：暂停
					dd.put(DatabaseConsts.STATE, SysConsts.DETECT_STATE_STOP);
				}
			}else{
				// 当前失败次数超过阈值不记录
				dd.put(DatabaseConsts.CURRENT_FAILURE_NUM, String.valueOf(failureNum));
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
	public static String[] createSms(Map<String, String> dd) {
		String[] message = new String[2];
		String noticeObject = dd.get(DatabaseConsts.NOTICE_OBJECT);
		if(StringUtil.isNotEmpty(noticeObject)){
			noticeObject = noticeObject.replace(SysConsts.NOTICE_OBJECT_SPLIT, SmsHandler.MOBILE_SPLIT);
		}
		// 组装警报对象
		message[0] = noticeObject;
		// 组装警报内容
		StringBuffer sb = new  StringBuffer();
		sb.append("系统数据库-->");
		sb.append(" URL:"+dd.get(DatabaseConsts.DB_URL));
		sb.append("连续"+dd.get(DatabaseConsts.THRESHOLD_VALUE)+"次连接失败！请及时查看并解决！");
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

