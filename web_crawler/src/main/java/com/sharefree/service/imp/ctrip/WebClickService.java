package com.sharefree.service.imp.ctrip;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.ctrip.WebClick;
import com.sharefree.model.ctrip.WebClickModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.ctrip.IWebClickService;

/**
 * Title: WebClickService
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
public class WebClickService extends BaseService implements IWebClickService {

	@Override
	public WebClickModel fetch(Integer id) {
		WebClick bean = dao.fetch(WebClick.class, id);
		WebClickModel model = (WebClickModel) copyProperties(bean, WebClickModel.class);
		return model;
	}

	@Override
	public WebClickModel insert(WebClickModel model) {
		WebClick bean = (WebClick) copyProperties(model, WebClick.class);
		bean = dao.insert(bean);
		model.setClickid(bean.getClickid());
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WebClickModel> query(WebClickModel model) {
		Criteria cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if(model.getClicktype() != null){
			group.andEquals("clicktype", model.getClicktype());
		}
		if(model.getTaskid() != null){
			group.andEquals("taskid", model.getTaskid());
		}
		if(model.getTripsequence() != null){
			group.andEquals("tripsequence", model.getTripsequence());
		}
		if(model.getProductid() != null){
			group.andEquals("productid", model.getProductid());
		}
		// 查询
		List<WebClick> beans = dao.query(WebClick.class, cri);
		List<WebClickModel> models = (List<WebClickModel>) copyListProperties(beans, WebClickModel.class);
		return models;
	}

	@Override
	public int count(WebClickModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clear(WebClickModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(WebClickModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
