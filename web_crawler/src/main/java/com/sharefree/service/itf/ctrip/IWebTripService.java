package com.sharefree.service.itf.ctrip;

import java.util.List;

import com.sharefree.model.ctrip.WebTripModel;
import com.sharefree.service.itf.IBaseService;

/**
 * Title: IWebTripService
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
public interface IWebTripService extends IBaseService<WebTripModel, Integer> {
	
	List<WebTripModel> queryFlights(WebTripModel model);
	
}
