package com.sharefree.service.imp.disney;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.disney.Trip;
import com.sharefree.model.disney.TripModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.disney.ITripService;

/**
 * Title: TripService
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
public class TripService extends BaseService<TripModel, Trip, Long> implements ITripService {

	@Override
	public List<TripModel> query(TripModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return query(cri, model.getPager());
	}

	@Override
	public int count(TripModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return count(cri);
	}

	public Criteria criteriaCreator(TripModel model) {
		Criteria cri = super.criteriaCreator(model);
		if (cri == null)
			cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if (model.getRowId() != null) {
			group.andEquals("rowId", model.getRowId());
		}
		return cri;
	}

}
