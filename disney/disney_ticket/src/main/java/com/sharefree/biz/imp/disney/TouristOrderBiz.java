package com.sharefree.biz.imp.disney;

import java.util.Date;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.imp.BaseBiz;
import com.sharefree.biz.itf.disney.ITouristDetailBiz;
import com.sharefree.biz.itf.disney.ITouristOrderBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.constant.SqlsConst;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.TouristDetailModel;
import com.sharefree.model.disney.TouristOrderModel;
import com.sharefree.service.itf.disney.IOccupyDetailService;
import com.sharefree.service.itf.disney.ITouristDetailService;
import com.sharefree.service.itf.disney.ITouristOrderService;
import com.sharefree.utils.DateUtil;
import com.sharefree.utils.OrderNoUtils;
import com.sharefree.utils.StringUtil;

@IocBean
public class TouristOrderBiz extends BaseBiz<TouristOrderModel, Long> implements ITouristOrderBiz {

	@Inject
	private ITouristOrderService touristOrderService;

	@Inject
	private ITouristDetailBiz touristDetailBiz;

	@Inject
	private ITouristDetailService touristDetailService;

	@Inject
	private IOccupyDetailService occupyDetailService;

	@Override
	public void order(TouristOrderModel model) throws CommonException {
		// 验证参数
		validateOrder(model);
		Date currentTime = getSystemTime();
		model.setOrderNo(OrderNoUtils.touristOrderNoCreator());
		model.setOccupyNum(0);
		model.setCrtOptId(currentOperator().getOptId());
		model.setCrtTime(currentTime);
		model.setTicketingNum(0);
		model.setStatus(DisneyConst.TOURIST_ORDER_STATUS_OK);
		// 是否同时录入游客信息
		List<TouristDetailModel> details = model.getTouristDetails();
		if (details != null && details.size() > 0) {
			// 保存订单信息
			model.setImportOptId(currentOperator().getOptId());
			model.setImportTime(currentTime);
			model = save(model);
			// 保存游客详情
			model.setTouristDetails(details);
			touristDetailBiz.importTouristDetail(model);
		} else {
			// 保存订单信息
			save(model);
		}
	}

	@Override
	public TouristOrderModel selectByIdWithDetail(Long id) throws CommonException {
		TouristOrderModel cnd = new TouristOrderModel();
		cnd.setOrderId(id);
		List<TouristOrderModel> models = queryByCustomSQL(cnd);
		if (models != null && models.size() > 0) {
			// 订单信息
			TouristOrderModel model = models.get(0);
			// 游客详情
			TouristDetailModel touristModel = new TouristDetailModel();
			touristModel.setOrderId(id);
			touristModel.setSqlKey(SqlsConst.TOURIST_DETAIL_QUERY);
			List<TouristDetailModel> touristModels = touristDetailService.queryByCustomSQL(touristModel);
			model.setTouristDetails(touristModels);
			// 占位详情
			OccupyDetailModel occupyModel = new OccupyDetailModel();
			occupyModel.setOrderId(id);
			List<OccupyDetailModel> occupyModels = occupyDetailService.query(occupyModel);
			model.setOccupyDetails(occupyModels);
			return model;
		}
		return null;
	}

	@Override
	public List<TouristOrderModel> query(TouristOrderModel model) throws CommonException {
		// 设置默认排序
		if (model.getOrderByClause() == null)
			model.setOrderByCustom("-orderId");
		return touristOrderService.query(model);
	}

	@Override
	public int count(TouristOrderModel model) throws CommonException {
		return touristOrderService.count(model);
	}

	@Override
	public List<TouristOrderModel> queryByCustomSQL(TouristOrderModel model) throws CommonException {
		// 设置默认排序
		if (model.getOrderByClause() == null)
			model.setOrderByCustom("-orderId");
		model.setSqlKey(SqlsConst.TOURIST_ORDER_QUERY);
		return touristOrderService.queryByCustomSQL(model);
	}

	@Override
	public int countByCustomSQL(TouristOrderModel model) throws CommonException {
		model.setSqlKey(SqlsConst.TOURIST_ORDER_COUNT);
		return touristOrderService.countByCustomSQL(model);
	}

	@Override
	public TouristOrderModel selectById(Long id) throws CommonException {
		return touristOrderService.fetch(id);
	}

	@Override
	public TouristOrderModel save(TouristOrderModel model) throws CommonException {
		return touristOrderService.insert(model);
	}

	@Override
	public int deleteById(Long id) throws CommonException {
		return touristOrderService.delete(id);
	}

	@Override
	public int update(TouristOrderModel model) throws CommonException {
		return touristOrderService.updateById(model, true);
	}

	private void validateOrder(TouristOrderModel model) {
		if (model.getVisitDate() == null) {
			throw new CommonException("缺少参数{visitDate}:入园日期");
		} else {
			// 验证距入园日期距离下单日天数是否符合限定
			Date visitDateLimit = DateUtil.getDateAfterDays(getSystemTime(), DisneyConst.ORDER_PERIOD_MIN);
			if (model.getVisitDate().before(visitDateLimit))
				throw new CommonException("请确认[入园日期]距离[当前日期]至少" + DisneyConst.ORDER_PERIOD_MIN + "天");
		}
		if (model.getVisitNum() == null || model.getVisitNum() < 1) {
			throw new CommonException("缺少参数{visitNum}:入园人数");
		}
		if (model.getIsNeedOccupy() && (model.getNeedOccupyNum() == null || model.getNeedOccupyNum() < 0)) {
			throw new CommonException("缺少参数{needOccupyNum}:需要占位人数");
		}
		if (StringUtil.isEmpty(model.getCustomerName())) {
			model.setCustomerName(DisneyConst.TOURIST_ORDER_CUSTOMER_NAME_INIT);
		}
		if (model.getIsNeedOccupy() == null) {
			model.setIsNeedOccupy(false);
		}
	}

}
