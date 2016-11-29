Ext.Loader.setConfig({
    // 开启动态加载
    enabled: true
});
//  定义application
Ext.application({
    name: 'DSN', // 项目名称
    appFolder: 'app', // 指定根目录
    autoCreateViewport: true, // 文件：app/view/Viewport.js 必须存在 ！
    controllers: ['MainController'],
    launch: function () {
        // 页面加载完成之后执行
        Ext.tip.QuickTipManager.init();

    }
});