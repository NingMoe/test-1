package com.sharefree.service.imp.disney;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.disney.TouristDetail;
import com.sharefree.model.disney.TouristDetailModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.disney.ITouristDetailService;

/**
 * Title: TouristDetailService
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
public class TouristDetailService extends BaseService<TouristDetailModel, TouristDetail, Long> implements ITouristDetailService {

	@Override
	public List<TouristDetailModel> query(TouristDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return query(cri, model.getPager());
	}

	@Override
	public int count(TouristDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return count(cri);
	}

	@Override
	public List<TouristDetailModel> queryByCustomSQL(TouristDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return super.queryByCustomSQL(model, cri, model.getPager());
	}

	@Override
	public int countByCustomSQL(TouristDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return super.countByCustomSQL(model, cri);
	}

	public Criteria criteriaCreator(TouristDetailModel model) {
		Criteria cri = super.criteriaCreator(model);
		if (cri == null)
			cri = Cnd.cri();
		// 组装条件
		// SqlExpressionGroup group = cri.where();
		// if (model.getOrderId() != null) {
		// group.andEquals("orderId", model.getOrderId());
		// }
		// if (model.getOrderNo() != null) {
		// group.andEquals("orderNo", model.getOrderNo());
		// }
		return cri;
	}

}
