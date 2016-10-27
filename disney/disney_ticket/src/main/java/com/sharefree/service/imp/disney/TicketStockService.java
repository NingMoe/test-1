package com.sharefree.service.imp.disney;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.disney.TicketStock;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.disney.ITicketStockService;

/**
 * Title: TicketStockService
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
public class TicketStockService extends BaseService<TicketStockModel, TicketStock, Long> implements ITicketStockService {

	@Override
	public List<TicketStockModel> queryByCustomSQL(TicketStockModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 排序信息
		orderByCreator(model, cri);
		// 查询
		return super.queryByCustomSQL(model, cri, model.getPager());
	}

	@Override
	public int countByCustomSQL(TicketStockModel model) {
		// 查询条件
		Criteria cri = criteriaCreator(model);
		// 查询
		return super.countByCustomSQL(model, cri);
	}

	public Criteria criteriaCreator(TicketStockModel model) {
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
		return cri;
	}

}
