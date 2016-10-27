var ioc = {
	// 读取配置文件
    conf : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : ["conf/"]
        }
    },
    // 配置静态数据
    constInit : {
        type : "com.sharefree.utils.ConstInit",
        args : [{refer:"conf"},{refer:"dao"}]
    }
};