package com.sharefree.biz.imp.disney;

import java.util.Date;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.imp.BaseBiz;
import com.sharefree.biz.itf.disney.ITouristDetailBiz;
import com.sharefree.common.CommonException;
import com.sharefree.constant.DisneyConst;
import com.sharefree.model.disney.TouristDetailModel;
import com.sharefree.model.disney.TouristOrderModel;
import com.sharefree.service.itf.disney.ITouristDetailService;
import com.sharefree.service.itf.disney.ITouristOrderService;
import com.sharefree.utils.DateUtil;
import com.sharefree.utils.StringUtil;

@IocBean
public class TouristDetailBiz extends BaseBiz<TouristDetailModel, Long> implements ITouristDetailBiz {

	@Inject
	private ITouristDetailService touristDetailService;

	@Inject
	private ITouristOrderService touristOrderService;

	@Override
	public void importTourist(TouristOrderModel model) throws CommonException {
		Date currentTime = systemService.getTime();
		model.setImportOptId(currentOperator().getOptId());
		model.setImportTime(currentTime);
		// 更新订单信息
		touristOrderService.updateById(model, true);
		importTouristDetail(model);
	}

	@Override
	public void importTouristDetail(TouristOrderModel model) throws CommonException {
		// 录入游客信息
		List<TouristDetailModel> details = model.getTouristDetails();
		for (TouristDetailModel detail : details) {
			detail.setOrderId(model.getOrderId());
			detail.setOrderNo(model.getOrderNo());
			detail.setVisitDate(model.getVisitDate());
			validateTouristDetail(detail);
			// 无证件类型，默认身份证
			if (StringUtil.isEmpty(detail.getIdcType()))
				detail.setIdcType(DisneyConst.IDC_TYPE_IDENTITYCARD);
			detail.setStatus(DisneyConst.TOURIST_DETAIL_STATUS_OK);
			detail.setImportOptId(currentOperator().getOptId());
			detail.setImportTime(model.getImportTime());
		}
		touristDetailService.insert(details);
	}

	/**
	 * 验证游客详情<br>
	 * 同一入园日，游客只能唯一一次出现在同一订单
	 * 
	 * @param detail
	 */
	private void validateTouristDetail(TouristDetailModel detail) {
		TouristDetailModel cnd = new TouristDetailModel();
		cnd.setVisitDate(detail.getVisitDate());
		cnd.setIdcNo(detail.getIdcNo());
		cnd.setTouristName(detail.getTouristName());
		List<TouristDetailModel> models = touristDetailService.query(cnd);
		if (models != null && models.size() > 0) {
			String visitDate = DateUtil.parseDateToString(detail.getVisitDate(), DateUtil.FORMAT1);
			throw new CommonException("入园日:" + visitDate + " 游客:" + detail.getTouristName() + " 已在订单[" + detail.getOrderNo() + "]中录入");
		}
	}

	@Override
	public List<TouristDetailModel> query(TouristDetailModel model) throws CommonException {
		// 设置默认排序
		if (model.getOrderByClause() == null)
			model.setOrderByCustom("-touristId");
		return touristDetailService.query(model);
	}

	@Override
	public TouristDetailModel selectById(Long id) throws CommonException {
		return touristDetailService.fetch(id);
	}

	@Override
	public int count(TouristDetailModel model) throws CommonException {
		return touristDetailService.count(model);
	}

	@Override
	public TouristDetailModel save(TouristDetailModel model) throws CommonException {
		return touristDetailService.insert(model);
	}

	@Override
	public int deleteById(Long id) throws CommonException {
		return touristDetailService.delete(id);
	}

	@Override
	public int update(TouristDetailModel model) throws CommonException {
		return touristDetailService.updateById(model, true);
	}

}
