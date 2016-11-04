package com.sharefree.runner.disney;

import com.sharefree.biz.imp.disney.DisneyOrderBiz;
import com.sharefree.biz.itf.disney.IDisneyOrderBiz;
import com.sharefree.model.disney.OccupyDetailModel;

public class OrderOccupyRunner extends BaseRunner implements Runnable {

	private OccupyDetailModel model;

	private Boolean ignoreCompetition;

	private IDisneyOrderBiz disneyOrderBiz = ioc.get(DisneyOrderBiz.class);

	public OrderOccupyRunner(OccupyDetailModel model, Boolean ignoreCompetition) {
		this.model = model;
		this.ignoreCompetition = ignoreCompetition;
	}

	@Override
	public void run() {
		disneyOrderBiz.occupy(model, ignoreCompetition);
	}

}
