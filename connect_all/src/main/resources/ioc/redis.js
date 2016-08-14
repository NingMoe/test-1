var ioc = {
	// 读取配置文件
    config_redis : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : ["dblink/redis.properties"]
        }
    },
	// 参考 https://github.com/xetorthio/jedis/wiki/Getting-started
	jedisPoolConfig : {
		type : "redis.clients.jedis.JedisPoolConfig",
		fields : {
			testWhileIdle : true,	// 空闲时测试,避免redis连接空闲时间长了断线
			maxTotal : 100
		}
	},
	jedisPool : {
		type : "redis.clients.jedis.JedisPool",
		args : [
		        {refer : "jedisPoolConfig"},
		        // 从配置文件中读取redis服务器信息
				{java : "$config_redis.get('redis.host')"},
				{java : "$config_redis.getInt('redis.port')"},
				{java : "$config_redis.getInt('redis.timeout')"},
				{java : "$config_redis.get('redis.password')"},
				{java : "$config_redis.getInt('redis.database')"}
		],
		fields : {},
		events : {
			depose : "destroy" // 关闭应用时必须关掉
		}
	}
};