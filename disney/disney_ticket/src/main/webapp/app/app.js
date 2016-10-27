Ext.Loader.setConfig({
			// 开启动态加载
			enabled : true
		});
Ext.application({
			name : 'CA', // 项目名称
			appFolder : 'app', // 指定根目录
			autoCreateViewport : true, // 文件：app/view/Viewport.js 必须存在 ！
			controllers : ['MainController'],
			launch : function() {
				// 页面加载完成之后执行

			}
		});