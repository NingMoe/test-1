package com.sharefree.module;

import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.sharefree.init.MainSetup;

@SetupBy(value = MainSetup.class)
@IocBy(type = ComboIocProvider.class, 
	   args = { 
		"*json", 
		"ioc/", 
		"*anno",
		"com.sharefree", 
		"*tx" })
@Modules(scanPackage = true)
@AdaptBy(type=JsonAdaptor.class)
public class MainModule {

}
