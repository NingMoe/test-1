package com.jike.system.quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.biz.itf.IDetectLogBiz;
import com.jike.system.model.DetectLogModel;
import com.jike.system.util.ContextUtil;
import com.jike.system.util.DateUtils;
import com.jike.system.util.ParamControlUtil;

/** 
 * 
 * Title: ClearExpireLogJob
 *
 * Description: 清除过期日志
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 27, 2015
 *
 */
public class ClearExpireLogJob implements Job {

	Logger log = LoggerFactory.getLogger(ClearExpireLogJob.class);
	
	IDetectLogBiz dlBiz = (IDetectLogBiz) ContextUtil.getBean("detectLogBiz");
	
	// 清除过期日志任务名称
	public static String JOB_NAME = "CLEAR_EXPIRE_LOG";
	
	@Override  
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		// 获取任务名称
		log.info("执行任务："+JOB_NAME);
		// 过期时间(多久之前的日志，单位:日)
		String stand = ParamControlUtil.getCommonParam("CLEAR_EXPIRE_LOG_STAND");
		// 获取指定日期
		Date expireDate = DateUtils.addDays(new Date(), -Integer.parseInt(stand));
		try {
			expireDate = DateUtils.parseDayDate(DateUtils.formatDayDate(expireDate));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DetectLogModel dlm = new DetectLogModel();
		// 设置指定日期
		dlm.setExpireDate(expireDate);
		// 清除过期日志
		dlBiz.deleteByExample(dlm);
	}
} 