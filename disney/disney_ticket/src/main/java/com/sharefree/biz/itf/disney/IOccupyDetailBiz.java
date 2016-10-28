package com.sharefree.biz.itf.disney;

import com.sharefree.biz.itf.IBaseBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.disney.OccupyDetailModel;

public interface IOccupyDetailBiz extends IBaseBiz<OccupyDetailModel, Long> {

	void repair(Long occupyId) throws CommonException;

}
