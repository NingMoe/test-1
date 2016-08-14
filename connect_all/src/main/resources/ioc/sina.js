var ioc = {
	// 读取配置文件
	config_sina : {
		type : "org.nutz.ioc.impl.PropertiesProxy",
		fields : {
			paths : [ "sina.properties" ]
		}
	},
	// 连接参数设置
	credentials : {
		type : "com.sina.cloudstorage.auth.BasicAWSCredentials",
		args : [
		// 从配置文件中读取SAE连接配置信息
		{
			java : "$config_sina.get('sina.accessKey')"
		}, {
			java : "$config_sina.get('sina.secretKey')"
		}, ],
	},
	// 创建连接
	scs : {
		type : "com.sina.cloudstorage.services.scs.SCSClient",
		singleton : false, // 是否为单例
		args : [ {
			refer : "credentials"
		} ]
	}
};