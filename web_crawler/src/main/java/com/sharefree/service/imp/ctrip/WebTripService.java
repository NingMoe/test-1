package com.sharefree.service.imp.ctrip;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.ctrip.WebTrip;
import com.sharefree.model.ctrip.WebTripModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.ctrip.IWebTripService;
import com.sharefree.utils.StringUtil;

/**
 * Title: WebTripService
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
public class WebTripService extends BaseService implements IWebTripService {

	@Override
	public WebTripModel fetch(Integer id) {
		WebTrip bean = dao.fetch(WebTrip.class, id);
		WebTripModel model = (WebTripModel) copyProperties(bean, WebTripModel.class);
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WebTripModel> query(WebTripModel model) {
		Criteria cri = Cnd.cri();
		// 组装条件
		SqlExpressionGroup group = cri.where();
		if(model.getClickid() != null){
			group.andEquals("clickid", model.getClickid());
		}
		if(model.getTripsequence() != null){
			group.andEquals("tripsequence", model.getTripsequence());
		}
		if(StringUtil.isNotEmpty(model.getSegment1())){
			group.andEquals("segment1", model.getSegment1());
		}
		if(StringUtil.isNotEmpty(model.getSegment2())){
			group.andEquals("segment2", model.getSegment2());
		}
		if(StringUtil.isNotEmpty(model.getSegment3())){
			group.andEquals("segment3", model.getSegment3());
		}
		if(StringUtil.isNotEmpty(model.getSegment4())){
			group.andEquals("segment4", model.getSegment4());
		}
		if(model.getExcludeTripid() != null){
			group.andNotIn("tripid", listTOarray(model.getExcludeTripid()));
		}
		// 查询
		List<WebTrip> beans = dao.query(WebTrip.class, cri);
		List<WebTripModel> models = (List<WebTripModel>) copyListProperties(beans, WebTripModel.class);
		return models;
	}

	@Override
	public int count(WebTripModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WebTripModel insert(WebTripModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clear(WebTripModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(WebTripModel model) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private int[] listTOarray(List<Integer> datas){
		int[] array = null;
		if(datas != null && datas.size() > 0){
			array = new int[datas.size()];
			for(int i = 0; i < datas.size(); i++){
				array[i] = datas.get(i);
			}
		}
		return array;
	}
	
}
