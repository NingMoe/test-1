package com.sharefree.biz.itf.disney;

import java.util.List;

import com.sharefree.biz.itf.IBaseBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.disney.TouristOrderModel;

public interface ITouristOrderBiz extends IBaseBiz<TouristOrderModel, Long> {

	/**
	 * 查询订单(运行情况)
	 * 
	 * @param model
	 * @return
	 */
	public List<TouristOrderModel> queryByCustomSQL(TouristOrderModel model) throws CommonException;

	/**
	 * 查询订单总数(运行情况)
	 * 
	 * @param model
	 * @return
	 */
	public int countByCustomSQL(TouristOrderModel model) throws CommonException;

	/**
	 * 游客下单
	 * 
	 * @param model
	 * @throws Exception
	 */
	void order(TouristOrderModel model) throws CommonException;

	/**
	 * 游客订单及其明细查询
	 * 
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	TouristOrderModel selectByIdWithDetail(Long id) throws CommonException;
}
