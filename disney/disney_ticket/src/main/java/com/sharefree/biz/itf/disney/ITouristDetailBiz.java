package com.sharefree.biz.itf.disney;

import com.sharefree.biz.itf.IBaseBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.disney.TouristDetailModel;
import com.sharefree.model.disney.TouristOrderModel;

public interface ITouristDetailBiz extends IBaseBiz<TouristDetailModel, Long> {

	/**
	 * 导入游客详情, 更新订单信息
	 * 
	 * @param model
	 * @throws CommonException
	 */
	void importTourist(TouristOrderModel model) throws CommonException;

	/**
	 * 导入游客详情
	 * 
	 * @param model
	 * @throws CommonException
	 */
	void importTouristDetail(TouristOrderModel model) throws CommonException;
}
