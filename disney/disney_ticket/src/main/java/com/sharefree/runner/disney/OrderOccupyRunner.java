package com.sharefree.runner.disney;

import com.sharefree.biz.itf.disney.IDisneyOrderBiz;
import com.sharefree.model.disney.OccupyDetailModel;
import com.sharefree.module.system.BaseRunner;

public class OrderOccupyRunner extends BaseRunner {

	private OccupyDetailModel model;

	private IDisneyOrderBiz disneyOrderBiz = ioc.get(IDisneyOrderBiz.class, "disneyOrderBiz");

	public OrderOccupyRunner(OccupyDetailModel model) {
		this.model = model;
	}

	@Override
	public void run() {
		disneyOrderBiz.occupy(model);
	}

}
