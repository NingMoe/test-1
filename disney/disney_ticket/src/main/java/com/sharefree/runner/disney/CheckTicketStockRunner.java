package com.sharefree.runner.disney;

import java.util.Date;

import com.sharefree.constant.DisneyConst;
import com.sharefree.front.imp.DisneyFront;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.utils.DateUtil;

public class CheckTicketStockRunner extends BaseRunner implements Runnable {

	private IDisneyFront disneyFront;

	public CheckTicketStockRunner() {
		disneyFront = ioc.get(DisneyFront.class);
	}

	@Override
	public void run() {
		// 获取当前日期为起始日期
		Date visitDateF = DateUtil.parseStringToDate(DateUtil.parseDateToString(new Date(), DateUtil.FORMAT1), DateUtil.FORMAT1);
		// 获取检查门票库存最多越天数的日期为终止日期
		Date visitDateT = DateUtil.getDateAfterDays(visitDateF, DisneyConst.CHECK_STOCK_DAY_MAX);
		disneyFront.check_occupy(visitDateF, visitDateT);
	};

}
