package com.sharefree.jobs.disney;

import java.util.Date;

import org.nutz.mvc.Mvcs;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sharefree.constant.DisneyConst;
import com.sharefree.front.imp.DisneyFront;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.utils.DateUtil;

public class CheckTicketStockJob implements Job {

	private IDisneyFront disneyFront = Mvcs.getIoc().get(DisneyFront.class);;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// 获取当前日期为起始日期
		Date visitDateF = DateUtil.parseStringToDate(DateUtil.parseDateToString(new Date(), DateUtil.FORMAT1), DateUtil.FORMAT1);
		// 获取检查门票库存最多越天数的日期为终止日期
		Date visitDateT = DateUtil.getDateAfterDays(visitDateF, DisneyConst.CHECK_STOCK_DAY_MAX);
		disneyFront.check_occupy(visitDateF, visitDateT);
	}

}
