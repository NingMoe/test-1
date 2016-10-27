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
import com.sharefree.service.itf.ISystemService;

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
	public void check_occupy(TicketStockModel model) throws CommonException {
		// Step 1 检查门票库存Job
		List<TicketStockModel> models = ticketStockBiz.check(model);

		// Step 2 执行占位Job
		disneyOrderBiz.occupyList(models);
	}

	@Override
	public void check_occupy(Date visitDateF, Date visitDateT) throws CommonException {
		TicketStockModel model = new TicketStockModel();
		model.setVisitDateF(visitDateF);
		model.setVisitDateT(visitDateT);
		check_occupy(model);
	}

	@Override
	public void cancel_occupy(Long occupyId) throws CommonException {
		OccupyDetailModel model = occupyDetailBiz.selectById(occupyId);
		if (model != null) {
			if (DisneyConst.OCCUPY_DETAIL_STATUS_UNUSE.equals(model.getStatus())) {
				// 先取消平台订单
				// 获取平台订单号
				String platOrderNo = model.getPlatOrderNo();
				boolean cancelOrder = crawlerBiz.cancelOrder(platOrderNo);
				// 再取消PNR
				boolean cancelPNR = etermBiz.cancelPNR(model.getPnr());
				// 回填取消信息
				String status = null;
				if (cancelOrder && cancelPNR) {
					status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL;
				} else if (cancelOrder) {
					status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL_PNR_ERROR;
				} else if (cancelPNR) {
					status = DisneyConst.OCCUPY_DETAIL_STATUS_CANCEL_ORDER_ERROR;
				} else {
					throw new CommonException("取消占位失败");
				}
				model = new OccupyDetailModel();
				model.setOccupyId(occupyId);
				model.setCancelTime(systemService.getTime());
				model.setStatus(status);
				// 更新状态
				occupyDetailBiz.update(model);
			}
		} else {
			throw new CommonException("占位信息不存在");
		}

	}
}
