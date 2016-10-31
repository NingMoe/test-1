package com.sharefree.biz.itf.disney;

import java.util.List;

import com.sharefree.common.CommonException;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristTicketModel;

public interface IDisneyOrderBiz {

	/**
	 * 列出占位订单并进行线程分发
	 * 
	 * @param stocks有库存的日期
	 * @throws CommonException
	 */
	public void occupyList(List<TicketStockModel> stocks) throws CommonException;

	/**
	 * 占位订单
	 * 
	 * @param model
	 *            占位信息
	 * @throws CommonException
	 */
	public void occupy(OccupyDetailModel model) throws CommonException;

	/**
	 * 支付订单（真实订单）
	 * 
	 * @param model
	 *            下单信息
	 * @throws CommonException
	 */
	public void pay(TouristTicketModel model) throws CommonException;
}
