package com.sharefree.runner.disney;

import java.util.Date;

import org.nutz.mvc.Mvcs;

import com.sharefree.front.itf.IDisneyFront;

public class CheckOccupyRunner implements Runnable {

	private Date visitDateF;

	private Date visitDateT;

	private IDisneyFront disneyFront = Mvcs.getIoc().get(IDisneyFront.class);

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
