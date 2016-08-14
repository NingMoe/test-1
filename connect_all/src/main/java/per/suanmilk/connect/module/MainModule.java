package per.suanmilk.connect.module;

import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import per.suanmilk.connect.init.MainSetup;

@SetupBy(value = MainSetup.class)
@IocBy(type = ComboIocProvider.class, args = { "*json", "ioc/", "*anno",
		"per.suanmilk.connect", "*tx" })
@Modules(scanPackage = true)
@AdaptBy(type = JsonAdaptor.class)
@Ok("json:{quoteName:true, ignoreNull:true}")
public class MainModule {

}
