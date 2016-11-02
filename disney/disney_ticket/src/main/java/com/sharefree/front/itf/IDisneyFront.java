package com.sharefree.front.itf;

import java.util.Date;
import java.util.List;

import com.sharefree.common.CommonException;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristTicketModel;
import com.sharefree.model.plane.PlaneOrderModel;

public interface IDisneyFront {

	/**
	 * 查询余票
	 * 
	 * @param visitDateF
	 *            检查日期开始
	 * @param visitDateT
	 *            检查日期结束
	 * @throws CommonException
	 */
	List<TicketStockModel> check(Date visitDateF, Date visitDateT) throws CommonException;

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
	 * 取消占位
	 * 
	 * @param occupyId
	 *            占座Id <br>
	 *            包含取消PNR和取消平台订单
	 * @throws CommonException
	 */
	void cancel_occupy(Long occupyId) throws CommonException;

	/**
	 * 取消占位
	 * 
	 * @param orderId
	 *            订单Id <br>
	 *            包含取消PNR和取消平台订单
	 * @throws CommonException
	 */
	void cancel_occupys(Long orderId) throws CommonException;

	/**
	 * 查询余票并进行下单支付
	 * 
	 * @param visitDateF
	 *            检查日期开始
	 * @param visitDateT
	 *            检查日期结束
	 * @throws CommonException
	 */
	void check_pay(TouristTicketModel model) throws CommonException;

	/**
	 * 解析pnr加入运价编码
	 * 
	 * @param pnr
	 * @return
	 * @throws CommonException
	 */
	PlaneOrderModel analysisPnr(String pnr) throws CommonException;

}
