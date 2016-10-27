package com.sharefree.biz.itf.disney;

import java.util.List;

import com.sharefree.biz.itf.IBaseBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.disney.TicketStockModel;

public interface ITicketStockBiz extends IBaseBiz<TicketStockModel, Long> {
	
	/**
	 * 根据条件检查库存
	 * 
	 * @param model
	 * @return	返回有库存日期的库存数量
	 * @throws CommonException
	 */
	List<TicketStockModel> check(TicketStockModel model) throws CommonException;

}
