package com.sharefree.biz.imp.disney;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.itf.disney.ISystemBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.constant.SqlsConst;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.TicketDistributionModel;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristOrderModel;
import com.sharefree.model.disney.TouristTicketModel;
import com.sharefree.service.itf.disney.IOccupyDetailService;
import com.sharefree.service.itf.disney.ITicketStockService;
import com.sharefree.service.itf.disney.ITouristOrderService;
import com.sharefree.service.itf.disney.ITouristTicketService;
import com.sharefree.utils.DateUtil;

@IocBean
public class SystemBiz implements ISystemBiz {

	@Inject
	private ITouristOrderService touristOrderService;

	@Inject
	private ITicketStockService ticketStockService;

	@Inject
	private ITouristTicketService touristTicketService;

	@Inject
	private IOccupyDetailService occupyDetailService;

	@Override
	public TicketDistributionModel getTicketDistribution(TicketDistributionModel model) throws CommonException {
		TicketDistributionModel result = new TicketDistributionModel();
		// 验证时间范围是否有效
		if (model.getVisitDateF() == null || model.getVisitDateT() == null)
			throw new CommonException("检查门票库存:缺少入园时间范围");
		if (model.getVisitDateF().after(model.getVisitDateT()))
			throw new CommonException("检查门票库存:时间范围无效");
		// 各入园日订单总人数
		if (model.getShowOrderNumSum() != null && model.getShowOrderNumSum()) {
			TouristOrderModel cnd = new TouristOrderModel();
			cnd.setVisitDateF(model.getVisitDateF());
			cnd.setVisitDateT(model.getVisitDateT());
			cnd.setSqlKey(SqlsConst.SELECT_ORDER_NUM_SUM);
			List<TouristOrderModel> models = touristOrderService.queryByCustomSQL(cnd);
			result.setOrderNumSum(models);
		}
		// 各入园日库存总数
		if (model.getShowStockNumSum() != null && model.getShowStockNumSum()) {
			TicketStockModel cnd = new TicketStockModel();
			cnd.setVisitDateF(model.getVisitDateF());
			cnd.setVisitDateT(DateUtil.addOneDay(model.getVisitDateT()));
			cnd.setSqlKey(SqlsConst.SELECT_STOCK_NUM_SUM);
			List<TicketStockModel> models = ticketStockService.queryByCustomSQL(cnd);
			result.setStockNumSum(models);
		}
		// 各入园日占位总数
		if (model.getShowOccupyNumSum() != null && model.getShowOccupyNumSum()) {
			OccupyDetailModel cnd = new OccupyDetailModel();
			cnd.setVisitDateF(model.getVisitDateF());
			cnd.setVisitDateT(model.getVisitDateT());
			cnd.setStatus(DisneyConst.OCCUPY_DETAIL_STATUS_UNUSE);
			cnd.setSqlKey(SqlsConst.SELECT_OCCUPY_NUM_SUM);
			List<OccupyDetailModel> models = occupyDetailService.queryByCustomSQL(cnd);
			result.setOccupyNumSum(models);
		}
		// 各入园日出票总数
		if (model.getShowTicketNumSum() != null && model.getShowTicketNumSum()) {
			TouristTicketModel cnd = new TouristTicketModel();
			cnd.setVisitDateF(model.getVisitDateF());
			cnd.setVisitDateT(model.getVisitDateT());
			cnd.setStatusIn(new String[] { DisneyConst.TOURIST_TICKET_STATUS_PAYED, DisneyConst.TOURIST_TICKET_STATUS_TICKETED });
			cnd.setSqlKey(SqlsConst.SELECT_TICKET_NUM_SUM);
			List<TouristTicketModel> models = touristTicketService.queryByCustomSQL(cnd);
			result.setTicketNumSum(models);
		}
		return result;
	}

}
