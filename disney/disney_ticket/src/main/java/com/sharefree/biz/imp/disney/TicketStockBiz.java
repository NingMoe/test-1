package com.sharefree.biz.imp.disney;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.imp.BaseBiz;
import com.sharefree.biz.itf.disney.ICrawlerBiz;
import com.sharefree.biz.itf.disney.ITicketStockBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.service.itf.disney.ITicketStockService;
import com.sharefree.utils.DateUtil;

@IocBean
public class TicketStockBiz extends BaseBiz<TicketStockModel, Long> implements ITicketStockBiz {

	private static final Logger log = Logger.getLogger(TicketStockBiz.class);

	@Inject
	private ITicketStockService ticketStockService;

	@Inject
	private ICrawlerBiz crawlerBiz;

	@Override
	public List<TicketStockModel> check(TicketStockModel model) throws CommonException {
		log.info("检查门票库存开始");
		log.debug("检查日期范围：" + DateUtil.parseDateToString(model.getVisitDateF(), DateUtil.FORMAT1) + " --> "
				+ DateUtil.parseDateToString(model.getVisitDateT(), DateUtil.FORMAT1));
		// 验证时间范围是否有效
		if (model.getVisitDateF() == null || model.getVisitDateT() == null)
			throw new CommonException("检查门票库存:缺少入园时间范围");
		if (model.getVisitDateF().after(model.getVisitDateT()))
			throw new CommonException("检查门票库存:时间范围无效");
		// 获取校验时间
		Date checkTime = systemService.getTime();
		List<TicketStockModel> models = crawlerBiz.checkTicketStock(model);
		// 更新库存信息
		if (models != null && models.size() > 0) {
			TicketStockModel cnd = new TicketStockModel();
			TicketStockModel chain = new TicketStockModel();
			Iterator<TicketStockModel> it = models.iterator();
			while (it.hasNext()) {
				TicketStockModel stockModel = it.next();
				// 设定条件
				cnd.setVisitDate(stockModel.getVisitDate());
				chain.setStock(stockModel.getStock());
				chain.setCheckTime(checkTime);
				// 先进行更新
				int num = ticketStockService.update(chain, cnd);
				// 更新不成功则插入
				if (num == 0) {
					chain.setVisitDate(stockModel.getVisitDate());
					ticketStockService.insert(chain);
				}
				// 库存为0的对象不返回
				if (stockModel.getStock() == null || stockModel.getStock() == 0)
					it.remove();
			}
		}
		log.info("检查门票库存结束");
		return models;
	}

	@Override
	public TicketStockModel selectById(Long id) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketStockModel> query(TicketStockModel model) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(TicketStockModel model) throws CommonException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TicketStockModel save(TicketStockModel model) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) throws CommonException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TicketStockModel model) throws CommonException {
		// TODO Auto-generated method stub
		return 0;
	}

}
