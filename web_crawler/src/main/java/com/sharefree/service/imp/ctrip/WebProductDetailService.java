package com.sharefree.service.imp.ctrip;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.ctrip.WebProductDetail;
import com.sharefree.model.ctrip.WebProductDetailModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.ctrip.IWebProductDetailService;

/**
 * Title: WebProductDetailService
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
public class WebProductDetailService extends BaseService implements IWebProductDetailService {

	@Override
	public WebProductDetailModel fetch(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WebProductDetailModel> query(WebProductDetailModel model) {
		Criteria cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if(model.getProductid() != null){
			group.andEquals("productid", model.getProductid());
		}
		// 查询
		List<WebProductDetail> beans = dao.query(WebProductDetail.class, cri);
		List<WebProductDetailModel> models = (List<WebProductDetailModel>) copyListProperties(beans, WebProductDetailModel.class);
		return models;
	}

	@Override
	public int count(WebProductDetailModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WebProductDetailModel insert(WebProductDetailModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clear(WebProductDetailModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(WebProductDetailModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
