var ioc = {
    // 数据源
    dataSource : {
        type : "com.alibaba.druid.pool.DruidDataSource",
        events : {
            create : "init",
            depose : 'close'
        },
        fields : {
        	driverClassName : {java:"$conf.get('disney.driverClassName')"},
        	url : {java:"$conf.get('disney.url')"},
            username : {java:"$conf.get('disney.username')"},
            password : {java:"$conf.get('disney.password')"},
            testWhileIdle : true, // 空闲时测试连接
            validationQuery : {java:"$conf.get('disney.validationQuery')"}, // 查询验证
            maxActive : {java:"$conf.get('disney.maxActive')"} // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程
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