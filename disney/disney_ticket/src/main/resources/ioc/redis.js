var ioc = {
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
				{java : "$conf.get('redis.host')"},
				{java : "$conf.getInt('redis.port')"},
				{java : "$conf.getInt('redis.timeout')"},
				{java : "$conf.get('redis.password')"},
				{java : "$conf.getInt('redis.database')"}
		],
		fields : {},
		events : {
			depose : "destroy" // 关闭应用时必须关掉
		}
	}
};