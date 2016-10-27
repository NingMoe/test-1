package com.sharefree.service.imp.disney;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.disney.OccupyDetail;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.disney.IOccupyDetailService;

/**
 * Title: OccupyDetailService
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
public class OccupyDetailService extends BaseService<OccupyDetailModel, OccupyDetail, Long> implements IOccupyDetailService {

	@Override
	public List<OccupyDetailModel> query(OccupyDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return query(cri, model.getPager());
	}

	@Override
	public int count(OccupyDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return count(cri);
	}

	@Override
	public List<OccupyDetailModel> queryByCustomSQL(OccupyDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return super.queryByCustomSQL(model, cri, model.getPager());
	}

	@Override
	public int countByCustomSQL(OccupyDetailModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return super.countByCustomSQL(model, cri);
	}

	public Criteria criteriaCreator(OccupyDetailModel model) {
		Criteria cri = super.criteriaCreator(model);
		if (cri == null)
			cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if (model.getVisitDateF() != null) {
			group.andGTE("visitDate", model.getVisitDateF().getTime());
		}
		if (model.getVisitDateT() != null) {
			group.andLT("visitDate", model.getVisitDateT().getTime());
		}
		if (model.getStatusIn() != null && model.getStatusIn().length > 0) {
			group.andIn("status", model.getStatusIn());
		}
		return cri;
	}

}
