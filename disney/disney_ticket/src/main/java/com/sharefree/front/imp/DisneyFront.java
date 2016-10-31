package com.sharefree.front.imp;

import java.util.Date;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.itf.disney.ICrawlerBiz;
import com.sharefree.biz.itf.disney.IDisneyOrderBiz;
import com.sharefree.biz.itf.disney.IEtermBiz;
import com.sharefree.biz.itf.disney.IOccupyDetailBiz;
import com.sharefree.biz.itf.disney.ITicketStockBiz;
import com.sharefree.biz.itf.disney.ITouristOrderBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.disney.TouristTicketModel;
import com.sharefree.model.plane.PlaneOrderModel;
import com.sharefree.model.plane.TicketPassengerModel;
import com.sharefree.service.itf.ISystemService;
import com.sharefree.utils.CommonUtil;

@IocBean
public class DisneyFront implements IDisneyFront {

	@Inject
	private ITicketStockBiz ticketStockBiz;

	@Inject
	private IDisneyOrderBiz disneyOrderBiz;

	@Inject
	private ITouristOrderBiz touristOrderBiz;

	@Inject
	private IOccupyDetailBiz occupyDetailBiz;

	@Inject
	private IEtermBiz etermBiz;

	@Inject
	private ICrawlerBiz crawlerBiz;

	@Inject
	protected ISystemService systemService;

	@Override
	public List<TicketStockModel> check(Date visitDateF, Date visitDateT) throws CommonException {
		TicketStockModel model = new TicketStockModel();
		model.setVisitDateF(visitDateF);
		model.setVisitDateT(visitDateT);
		return ticketStockBiz.check(model);
	}

	@Override
	public void check_occupy(Date visitDateF, Date visitDateT) throws CommonException {
		// Step 1 检查门票库存Job
		List<TicketStockModel> models = check(visitDateF, visitDateT);
		if (DisneyConst.ORDER_OCCUPY_RUN) {
			// Step 2 执行占位Job
			disneyOrderBiz.occupyList(models);
		}
	}

	@Override
	public void cancel_occupy(Long occupyId) throws CommonException {
		OccupyDetailModel model = occupyDetailBiz.selectById(occupyId);
		if (model != null) {
			if (DisneyConst.OCCUPY_DETAIL_STATUS_UNUSE.equals(model.getStatus())) {
				// 回填取消信息
				String status = null;
				// 先取消平台订单
				boolean cancelOrder = crawlerBiz.cancelOrder(model.getPlatOrderNo());
				// 取消成功才能取消PNR
				boolean cancelPNR = false;
				if (cancelOrder) {
					// 再取消PNR
					cancelPNR = etermBiz.cancelPNR(model.getPnr());
					if (cancelPNR) {
						status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL;
					} else {
						status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL_PNR_ERROR;
					}
				} else {
					status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL_ORDER_ERROR;
				}
				model = new OccupyDetailModel();
				model.setOccupyId(occupyId);
				model.setCancelTime(systemService.getTime());
				model.setStatus(status);
				// 更新状态
				occupyDetailBiz.update(model);
				if (!cancelOrder || !cancelPNR)
					throw new CommonException("取消占位异常");
			}
		} else {
			throw new CommonException("占位信息不存在");
		}

	}

	@Override
	public void check_pay(TouristTicketModel model) throws CommonException {
		Date visitDate = model.getVisitDate();
		// 查询当天库存
		List<TicketStockModel> stocks = check(visitDate, visitDate);
		model.setStocks(stocks);
		// web.socket提示库存信息
		disneyOrderBiz.pay(model);
	}

	@Override
	public PlaneOrderModel analysisPnr(String pnr) throws CommonException {
		PlaneOrderModel model = etermBiz.analysisPNR(pnr);
		if (model != null) {
			List<TicketPassengerModel> passengers = model.getPassengers();
			for (TicketPassengerModel passenger : passengers) {
				passenger.setTel(CommonUtil.getTel());
				passenger.setEmail(CommonUtil.getEmail(passenger.getIdcName()));
			}
		}
		model.setPriceCode(DisneyConst.CRAWLER_SERVICE_PATAM_FREIGHTNO);
		return model;
	}
}
