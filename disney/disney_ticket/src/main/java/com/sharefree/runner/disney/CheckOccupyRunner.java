package com.sharefree.runner.disney;

import java.util.Date;

import com.sharefree.front.itf.IDisneyFront;
import com.sharefree.module.system.BaseRunner;

public class CheckOccupyRunner extends BaseRunner {

	private Date visitDateF;

	private Date visitDateT;

	private IDisneyFront disneyFront = ioc.get(IDisneyFront.class, "disneyFront");

	public CheckOccupyRunner(Date visitDateF, Date visitDateT) {
		this.visitDateF = visitDateF;
		this.visitDateT = visitDateT;
	}

	@Override
	public void run() {
		if (visitDateF != null && visitDateT != null) {
			disneyFront.check_occupy(visitDateF, visitDateT);
		}
	}

}
