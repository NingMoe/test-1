var ioc = {
	// 读取配置文件
    config_ctrip : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : ["dblink/mysql.properties"]
        }
    },
    // 数据源
    dataSource : {
        type : "com.alibaba.druid.pool.DruidDataSource",
        events : {
            create : "init",
            depose : 'close'
        },
        fields : {
        	driverClassName : {java:"$config_ctrip.get('ctrip.driverClassName')"},
        	url : {java:"$config_ctrip.get('ctrip.url')"},
            username : {java:"$config_ctrip.get('ctrip.username')"},
            password : {java:"$config_ctrip.get('ctrip.password')"},
            testWhileIdle : true, // 空闲时测试连接
            validationQuery : {java:"$config_ctrip.get('ctrip.validationQuery')"}, // 查询验证
            maxActive : {java:"$config_ctrip.get('ctrip.maxActive')"} // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程
        }
    },
    // Dao
    dao : {
    	type : "org.nutz.dao.impl.NutDao",
    	args : [{refer:"dataSource"}]
    },
    //声明一个log进行日志记录
    log : {
        type :'org.nutz.aop.interceptor.LoggingMethodInterceptor'
    }
};