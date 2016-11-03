package com.sharefree.module;

import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.sharefree.filter.system.CheckRequestFilter;
import com.sharefree.init.MainSetup;
import com.sharefree.utils.view.ResultViewMaker;

@Modules(scanPackage = true)
@Filters({ @By(type = CheckRequestFilter.class) })
@IocBy(type = ComboIocProvider.class, args = { "*json", "ioc/", "*anno", "com.sharefree", "*tx" })
@AdaptBy(type = JsonAdaptor.class)
@SetupBy(value = MainSetup.class)
@Views({ ResultViewMaker.class })
@Ok("success")
@Fail("exception")
public class MainModule {

}
