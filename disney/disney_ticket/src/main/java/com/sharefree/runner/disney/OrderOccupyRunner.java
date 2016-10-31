package com.sharefree.runner.disney;

import org.nutz.mvc.Mvcs;

import com.sharefree.biz.itf.disney.IDisneyOrderBiz;
import com.sharefree.model.disney.OccupyDetailModel;

public class OrderOccupyRunner implements Runnable {

	private OccupyDetailModel model;

	private IDisneyOrderBiz disneyOrderBiz = Mvcs.getIoc().get(IDisneyOrderBiz.class);

	public OrderOccupyRunner(OccupyDetailModel model) {
		this.model = model;
	}

	@Override
	public void run() {
		disneyOrderBiz.occupy(model);
	}

}
