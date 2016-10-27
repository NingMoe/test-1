package com.sharefree.service.imp.disney;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.disney.TouristOrder;
import com.sharefree.model.disney.TouristOrderModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.disney.ITouristOrderService;
import com.sharefree.utils.StringUtil;

/**
 * Title: TouristOrderService
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
public class TouristOrderService extends BaseService<TouristOrderModel, TouristOrder, Long> implements ITouristOrderService {

	@Override
	public List<TouristOrderModel> query(TouristOrderModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return query(cri, model.getPager());
	}

	@Override
	public int count(TouristOrderModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return count(cri);
	}

	@Override
	public List<TouristOrderModel> queryByCustomSQL(TouristOrderModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return super.queryByCustomSQL(model, cri, model.getPager());
	}

	@Override
	public int countByCustomSQL(TouristOrderModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return super.countByCustomSQL(model, cri);
	}

	public Criteria criteriaCreator(TouristOrderModel model) {
		Criteria cri = super.criteriaCreator(model);
		if (cri == null)
			cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if (StringUtil.isNotEmpty(model.getCustomerNameLike())) {
			group.andLike("customerName", model.getCustomerNameLike(), false);
		}
		if (model.getVisitDateF() != null) {
			group.andGTE("visitDate", model.getVisitDateF().getTime());
		}
		if (model.getVisitDateT() != null) {
			group.andLT("visitDate", model.getVisitDateT().getTime());
		}
		if (model.getStatusIn() != null && model.getStatusIn().length > 0) {
			group.andIn("status", model.getStatusIn());
		}
		if (model.getVisitDateIn() != null && model.getVisitDateIn().length > 0) {
			group.andIn("visitDate", model.getVisitDateIn());
		}
		if (model.getIsImport() != null && !model.getIsImport()) {
			group.andIsNull("importTime");
		}
		return cri;
	}

}
