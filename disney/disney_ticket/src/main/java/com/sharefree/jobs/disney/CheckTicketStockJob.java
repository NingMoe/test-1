package com.sharefree.jobs.disney;

import java.util.Date;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sharefree.constant.DisneyConst;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.utils.DateUtil;

@IocBean
public class CheckTicketStockJob implements Job {

	@Inject
	private IDisneyFront disneyFront;

	// 东航维护5个月的门票
	private static int[] plusMonth = { 0, DisneyConst.CHECK_STOCK_MONTH_MAX };

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// Step 1 检查门票库存Job
		TicketStockModel model = new TicketStockModel();
		dateRange(model);
		disneyFront.check_occupy(model);
	}

	// 根据配置获取检查月的范围
	private void dateRange(TicketStockModel model) {
		int plus = plusMonth[0];
		// 获取当前月份首日
		Date checkMonthFirstDay = DateUtil.getCurrentMonthFirstDay(new Date());
		if (plus > 0)
			// 获取累加月数后的月份首日
			checkMonthFirstDay = DateUtil.addDateByMonth(checkMonthFirstDay, plus);
		model.setVisitDateF(checkMonthFirstDay);
		// 获取检查月份末日
		Date checkMonthLastDay = DateUtil.addDateByMonth(checkMonthFirstDay, 1);
		checkMonthLastDay = DateUtil.getDateAfterDays(checkMonthLastDay, -1);
		model.setVisitDateT(checkMonthLastDay);
		// 设置下次检查累加月数
		if ((plus + 1) < plusMonth[1]) {
			plusMonth[0] = plus + 1;
		} else {
			plusMonth[0] = 0;
		}
	}

}
