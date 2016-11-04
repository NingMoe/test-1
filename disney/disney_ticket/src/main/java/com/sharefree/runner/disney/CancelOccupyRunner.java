package com.sharefree.runner.disney;

import com.sharefree.front.imp.DisneyFront;
import com.sharefree.front.itf.IDisneyFront;

public class CancelOccupyRunner extends BaseRunner implements Runnable {

	private Long orderId;

	private IDisneyFront disneyFront = ioc.get(DisneyFront.class);

	public CancelOccupyRunner(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public void run() {
		if (orderId != null) {
			disneyFront.cancel_occupys(orderId);
		}
	}

}
