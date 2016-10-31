package com.sharefree.biz.itf.disney;

import java.util.List;

import com.sharefree.common.CommonException;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristTicketModel;

public interface ICrawlerBiz {

	/**
	 * 下单占位
	 * 
	 * @param passengers
	 *            乘客信息
	 * @return 平台订单号
	 * @throws CommonException
	 */
	public String order_occupy(OccupyDetailModel model) throws CommonException;

	/**
	 * 下单支付
	 * 
	 * @param model
	 * @return
	 * @throws CommonException
	 */
	public String order_pay(TouristTicketModel model) throws CommonException;

	/**
	 * 取消订单
	 * 
	 * @param platOrderNo
	 * @return 是否成功取消
	 * @throws CommonException
	 */
	public boolean cancelOrder(String platOrderNo) throws CommonException;

	/**
	 * 支付并完成
	 * 
	 * @param platOrderNo
	 *            平台订单号
	 * @param planeTicketNo
	 *            票号
	 * @throws CommonException
	 */
	public void ticket(String platOrderNo, String planeTicketNo) throws CommonException;

	/**
	 * 获取库存信息
	 * 
	 * @param model
	 * @return
	 * @throws CommonException
	 */
	public List<TicketStockModel> checkTicketStock(TicketStockModel model) throws CommonException;

	/**
	 * 获取GLA编码
	 * 
	 * @param platOrderNo
	 * @throws CommonException
	 */
	public List<TicketStockModel> getGLACode(String platOrderNo) throws CommonException;

}
