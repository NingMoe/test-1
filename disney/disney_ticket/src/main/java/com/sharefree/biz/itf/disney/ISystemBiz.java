package com.sharefree.biz.itf.disney;

import com.sharefree.common.CommonException;
import com.sharefree.model.disney.TicketDistributionModel;

public interface ISystemBiz {

	/**
	 * 获取门票分布情况
	 * 
	 * @param model
	 * @return
	 * @throws CommonException
	 */
	TicketDistributionModel getTicketDistribution(TicketDistributionModel model) throws CommonException;

}
