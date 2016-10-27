package com.sharefree.front.itf;

import java.util.Date;

import com.sharefree.common.CommonException;
import com.sharefree.model.disney.TicketStockModel;

public interface IDisneyFront {

	/**
	 * 
	 * 查询余票并进行占位
	 * 
	 * @param model
	 *            检查日期范围
	 * @throws CommonException
	 */
	void check_occupy(TicketStockModel model) throws CommonException;

	/**
	 * 查询余票并进行占位
	 * 
	 * @param visitDateF
	 *            检查日期开始
	 * @param visitDateT
	 *            检查日期结束
	 * @throws CommonException
	 */
	void check_occupy(Date visitDateF, Date visitDateT) throws CommonException;

	/**
	 * 取消占座
	 * 
	 * @param occupyId
	 *            占座Id <br>
	 *            包含取消PNR和取消平台订单
	 * @throws CommonException
	 */
	void cancel_occupy(Long occupyId) throws CommonException;

}
