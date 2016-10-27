package com.sharefree.service.imp.system;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.system.Operator;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.system.IOperatorService;


/**
 * Title: OperatorService
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
public class OperatorService extends BaseService<OperatorModel, Operator, Long> implements IOperatorService {

	@Override
	public OperatorModel fetch(Long id) {
		Operator bean = dao.fetch(Operator.class, id);
		OperatorModel model = copyBean2Model(bean);
		return model;
	}

	@Override
	public OperatorModel insert(OperatorModel model) {
		Operator bean = copyModel2Bean(model);
		bean = dao.insert(bean);
		model.setOptId(bean.getOptId());
		return model;
	}

	@Override
	public List<OperatorModel> query(OperatorModel model) {
		Criteria cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if(model.getOptNo() != null){
			group.andEquals("optNo", model.getOptNo());
		}
		if(model.getOptName() != null){
			group.andLike("optName", model.getOptName());
		}
		if(model.getTel() != null){
			group.andEquals("tel", model.getTel());
		}
		if(model.getUserNo() != null){
			SqlExpressionGroup group2 = Cnd.exps("optNo", "=", model.getUserNo()).orEquals("tel", model.getUserNo());
			group.and(group2);
		}
		// 查询
		List<Operator> beans = dao.query(Operator.class, cri);
		List<OperatorModel> models = copyBeans2Models(beans);
		return models;
	}

	@Override
	public int count(OperatorModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clear(OperatorModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
