package com.sharefree.biz.itf.disney;

import java.util.Date;
import java.util.List;

import com.sharefree.common.CommonException;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.OccupyDetailSelector;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristTicketModel;

public interface IDisneyOrderBiz {

	/**
	 * 列出占位订单并进行线程分发
	 * 
	 * @param stocks
	 *            有库存的日期
	 * @throws CommonException
	 */
	public void check_occupy(List<TicketStockModel> stocks) throws CommonException;

	/**
	 * 占位订单进行线程分发
	 * 
	 * @param orderId
	 *            订单Id
	 * @param orderNo
	 *            订单No
	 * @param visitDate
	 *            入园日
	 * @param canOccupy
	 *            占位数
	 * @param ignoreCompetition
	 *            忽略资源竞争
	 * @throws CommonException
	 */
	public void distribute_occupy(Long orderId, String orderNo, Date visitDate, Integer canOccupy, Boolean ignoreCompetition) throws CommonException;

	/**
	 * 占位订单
	 * 
	 * @param model
	 *            占位信息
	 * @param ignoreCompetition
	 *            忽略资源竞争
	 * @throws CommonException
	 */
	public void occupy(OccupyDetailModel model, Boolean ignoreCompetition) throws CommonException;

	/**
	 * 
	 * 检查库存，优先库存下单；无库存，检查占位，返回可释放占位信息
	 * 
	 * @param model
	 *            下单信息
	 * @return 可释放占位信息
	 * @throws CommonException
	 */
	public OccupyDetailSelector check_pay(TouristTicketModel model) throws CommonException;

	/**
	 * 支付订单（真实订单）
	 * 
	 * @param model
	 *            下单信息
	 * @throws CommonException
	 */
	public void pay(TouristTicketModel model) throws CommonException;
}
