package com.sharefree.service.imp.ctrip;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.ctrip.WebProduct;
import com.sharefree.model.ctrip.WebProductModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.ctrip.IWebProductService;

/**
 * Title: WebProductService
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
public class WebProductService extends BaseService implements IWebProductService {

	@Override
	public WebProductModel fetch(Integer id) {
		WebProduct bean = dao.fetch(WebProduct.class, id);
		WebProductModel model = (WebProductModel) copyProperties(bean, WebProductModel.class);
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WebProductModel> query(WebProductModel model) {
		Criteria cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if(model.getTripid() != null){
			group.andEquals("tripid", model.getTripid());
		}
		// 查询
		List<WebProduct> beans = dao.query(WebProduct.class, cri);
		List<WebProductModel> models = (List<WebProductModel>) copyListProperties(beans, WebProductModel.class);
		return models;
	}

	@Override
	public int count(WebProductModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WebProductModel insert(WebProductModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clear(WebProductModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(WebProductModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
