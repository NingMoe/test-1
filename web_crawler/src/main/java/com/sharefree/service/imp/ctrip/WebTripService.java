package com.sharefree.service.imp.ctrip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.ctrip.WebTrip;
import com.sharefree.model.CommonQueryModel;
import com.sharefree.model.ctrip.WebProductModel;
import com.sharefree.model.ctrip.WebTripModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.ctrip.IWebTripService;
import com.sharefree.utils.SqlCreateUtil;
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
			group.andNotIn("tripid", StringUtil.listTOarray(model.getExcludeTripid()));
		}
		// 查询
		List<WebTrip> beans = dao.query(WebTrip.class, cri);
		List<WebTripModel> models = (List<WebTripModel>) copyListProperties(beans, WebTripModel.class);
		return models;
	}

	@Override
	public List<WebTripModel> queryFlights(WebTripModel model) {
		// 定义查询回航班数据
		List<WebTripModel> wtms = new ArrayList<WebTripModel>();
		// 定义sql
		StringBuilder sql = new StringBuilder("select * from web_product a left join web_trip b on a.tripId = b.tripId where 1=1 ");
		if(model.getClickid() != null){
			sql.append("and clickId = ").append(model.getClickid()).append(" ");
		}
		if(model.getTripsequence() != null){
			sql.append("and tripSequence = ").append(model.getTripsequence()).append(" ");
		}
		if(model.getExcludeTripid() != null && model.getExcludeTripid().size() > 0){
			sql.append("and a.tripId not in (").append(createCondition(model.getExcludeTripid())).append(") ");
		}
		sql.append("order by a.tripId desc");
    	// 定义查询条件
    	CommonQueryModel cqm = new CommonQueryModel(sql.toString(), null);
    	// 执行查询
    	cqm = SqlCreateUtil.complexQuery(dao, cqm);
    	// 获取查询结果
    	// Object[]格式：
		// Object[0]   --> 产品id（主键，自增长）
		// Object[1]   --> 行程id
		// Object[2]   --> 自定义产品名称（优选套餐、特惠推荐、商务优选等）
		// Object[3]   --> 舱位等级
		// Object[4]   --> 舱位代码
		// Object[5]   --> 票面价
		// Object[6]   --> 税费
		// Object[7]   --> 含税销价
		// Object[8]   --> 套餐信息（自定义）
		// Object[9]   --> 剩余机票
		// Object[10]  --> 退改签
		// Object[11]  --> 购票说明
		// Object[12]  --> 行程id（主键，自增长）
		// Object[13]  --> 任务id
		// Object[14]  --> 行程索引（同一个查询请求包含的行程使用相同的索引; 单程：行程id; 往返：自定义id; 多程：上一程id）
		// Object[15]  --> 行程序列（单程：1; 多程依次+1）
		// Object[16]  --> 点击操作id
		// Object[17]  --> 航段1（格式：航班号|机型|共享航班号|出发机场三字码|出发机场航站楼|出发时间|到达机场三字码|到达机场航站楼|到达时间|飞行时长|经停机场）
		// Object[18]  --> 航段2（格式：中转城市|中转提醒|停留时长|航班号|机型|共享航班号|出发机场三字码|出发机场航站楼|出发时间|到达机场三字码|到达机场航站楼|到达时间|飞行时长|经停机场）
		// Object[19]  --> 航段3（格式：中转城市|中转提醒|停留时长|航班号|机型|共享航班号|出发机场三字码|出发机场航站楼|出发时间|到达机场三字码|到达机场航站楼|到达时间|飞行时长|经停机场）
		// Object[20]  --> 航段4（格式：中转城市|中转提醒|停留时长|航班号|机型|共享航班号|出发机场三字码|出发机场航站楼|出发时间|到达机场三字码|到达机场航站楼|到达时间|飞行时长|经停机场）
    	List<Object[]> results = cqm.getResults();
    	if(results != null && results.size() > 0){
			Map<Integer, WebTripModel> wtmMap = new LinkedHashMap<Integer, WebTripModel>();
    		for(Object[] result : results){
    			WebProductModel wpm = new WebProductModel();
				Integer tripId = Integer.valueOf(result[1].toString());
				// 获取产品
				wpm.setProductid(Integer.valueOf(result[0].toString()));
				wpm.setTripid(Integer.valueOf(result[1].toString()));
				wpm.setProducttype(result[2]!=null?result[2].toString():null);
				wpm.setCabinclass(result[3]!=null?result[3].toString():null);
				wpm.setCabincode(result[4]!=null?result[4].toString():null);
				wpm.setFaceprice(result[5]!=null?Integer.valueOf(result[5].toString()):null);
				wpm.setTax(result[6]!=null?Integer.valueOf(result[6].toString()):null);
				wpm.setSaleprice(result[7]!=null?Integer.valueOf(result[7].toString()):null);
				wpm.setCombo(result[8]!=null?result[8].toString():null);
				wpm.setCabinleft(result[9]!=null?Integer.valueOf(result[9].toString()):null);
				wpm.setChangerefundrule(result[10]!=null?result[10].toString():null);
				wpm.setTicketnotice(result[11]!=null?result[11].toString():null);
				// 是否存在此行程
				if(!wtmMap.containsKey(tripId)){
					// 添加行程信息
					WebTripModel wtm = new WebTripModel();
					wtm.setTripid(tripId);
					wtm.setTaskid(result[13]!=null?Integer.valueOf(result[13].toString()):null);
					wtm.setTripindex(result[14]!=null?Integer.valueOf(result[14].toString()):null);
					wtm.setTripsequence(result[15]!=null?Integer.valueOf(result[15].toString()):null);
					wtm.setClickid(result[16]!=null?Integer.valueOf(result[16].toString()):null);
					wtm.setSegment1(result[17]!=null?result[17].toString():null);
					wtm.setSegment2(result[18]!=null?result[18].toString():null);
					wtm.setSegment3(result[19]!=null?result[19].toString():null);
					wtm.setSegment4(result[20]!=null?result[20].toString():null);
					// 添加产品
					List<WebProductModel> products = new ArrayList<WebProductModel>();
					products.add(wpm);
					wtm.setProducts(products);
					wtmMap.put(tripId, wtm);
				}else{
					WebTripModel wtm = wtmMap.get(tripId);
					// 添加产品
					wtm.getProducts().add(wpm);
				}
    		}
    		// 获取完整航班信息
    		wtms.addAll(wtmMap.values());
    	}
		return wtms;
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
	
	private String createCondition(List<Integer> list){
		String condition = "";
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			Object element = iter.next();
			condition += element.toString();
			if(iter.hasNext())
				condition += ", ";
		}
		return condition;
	}
	
}
