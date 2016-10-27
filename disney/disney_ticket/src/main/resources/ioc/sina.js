var ioc = {
	// 连接参数设置
	credentials : {
		type : "com.sina.cloudstorage.auth.BasicAWSCredentials",
		args : [
		// 从配置文件中读取SAE连接配置信息
		{
			java : "$conf.get('sina.accessKey')"
		}, {
			java : "$conf.get('sina.secretKey')"
		} ]
	},
	// 创建连接
	scs : {
		type : "com.sina.cloudstorage.services.scs.SCSClient",
		args : [ {
			refer : "credentials"
		} ]
	}
};