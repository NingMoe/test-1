package com.sharefree.biz.itf.ctrip;

import java.util.Map;

import com.sharefree.model.ctrip.CtripQueryFlightModel;

/**
 * 
 * Title: IWebCtripFlightBiz
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 17, 2016
 *
 */
public interface IWebCtripFlightBiz {

	/**
	 * 根据token进行异步shopping查询
	 * 
	 * @param cqfm
	 * @return
	 */
	Map<String, Object> shopping(CtripQueryFlightModel cqfm);

	/**
	 * 验价和退改签及产品信息
	 * 
	 * @param ods
	 * @return
	 */
	Map<String, Object> check(CtripQueryFlightModel cqfm);
	
}
