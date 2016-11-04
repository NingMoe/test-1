package com.sharefree.runner.disney;

import org.nutz.ioc.Ioc;

public abstract class BaseRunner {

	protected static Ioc ioc;

	public static void setIoc(Ioc ioc) {
		BaseRunner.ioc = ioc;
	}

}
