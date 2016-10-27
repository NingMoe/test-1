package com.sharefree.biz.imp.disney;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.itf.disney.IOccupyDetailBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.service.itf.disney.IOccupyDetailService;

@IocBean
public class OccupyDetailBiz implements IOccupyDetailBiz {

	@Inject
	private IOccupyDetailService occupyDetailService;

	@Override
	public OccupyDetailModel selectById(Long id) throws CommonException {
		return occupyDetailService.fetch(id);
	}

	@Override
	public List<OccupyDetailModel> query(OccupyDetailModel model) throws CommonException {
		// 设置默认排序
		if(model.getOrderByClause() == null)
			model.setOrderByCustom("-occupyId");
		return occupyDetailService.query(model);
	}

	@Override
	public int count(OccupyDetailModel model) throws CommonException {
		return occupyDetailService.count(model);
	}

	@Override
	public OccupyDetailModel save(OccupyDetailModel model) throws CommonException {
		return occupyDetailService.insert(model);
	}

	@Override
	public int deleteById(Long id) throws CommonException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OccupyDetailModel model) throws CommonException {
		return occupyDetailService.updateById(model, true);
	}
	
}
