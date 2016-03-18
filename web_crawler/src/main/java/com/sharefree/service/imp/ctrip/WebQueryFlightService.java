package com.sharefree.service.imp.ctrip;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.ctrip.WebQueryFlight;
import com.sharefree.model.ctrip.WebQueryFlightModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.ctrip.IWebQueryFlightService;

/**
 * Title: WebQueryFlightService
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
@IocBean
public class WebQueryFlightService extends BaseService implements IWebQueryFlightService {

	@Override
	public WebQueryFlightModel fetch(Integer id) {
		WebQueryFlight bean = dao.fetch(WebQueryFlight.class, id);
		WebQueryFlightModel model = (WebQueryFlightModel) copyProperties(bean, WebQueryFlightModel.class);
		return model;
	}

	@Override
	public WebQueryFlightModel insert(WebQueryFlightModel model) {
		WebQueryFlight bean = (WebQueryFlight) copyProperties(model, WebQueryFlight.class);
		bean = dao.insert(bean);
		model.setTaskid(bean.getTaskid());
		return model;
	}

	@Override
	public List<WebQueryFlightModel> query(WebQueryFlightModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(WebQueryFlightModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clear(WebQueryFlightModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(WebQueryFlightModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
