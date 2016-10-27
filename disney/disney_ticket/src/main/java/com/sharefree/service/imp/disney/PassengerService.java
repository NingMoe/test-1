package com.sharefree.service.imp.disney;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.disney.Passenger;
import com.sharefree.model.disney.PassengerModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.disney.IPassengerService;

/**
 * Title: PassengerService
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
public class PassengerService extends BaseService<PassengerModel, Passenger, Long> implements IPassengerService {

	@Override
	public List<PassengerModel> query(PassengerModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return query(cri, model.getPager());
	}

	@Override
	public List<PassengerModel> queryByCustomSQL(PassengerModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return super.queryByCustomSQL(model, cri, model.getPager());
	}

	@Override
	public int count(PassengerModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return count(cri);
	}

	public Criteria criteriaCreator(PassengerModel model) {
		Criteria cri = super.criteriaCreator(model);
		if (cri == null)
			cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if (model.getRowIdIn() != null && model.getRowIdIn().length > 0) {
			group.andIn("rowId", model.getRowIdIn());
		}
		return cri;
	}

}
