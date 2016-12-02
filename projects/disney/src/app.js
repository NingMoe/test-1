// 动态加载js
Ext.Loader.setConfig({
    // 开启动态加载
    enabled: true
});
//  定义application
Ext.application({
    name: 'DSN', // 项目名称
    appFolder: 'app', // 指定根目录
    autoCreateViewport: true, // 文件：app/view/Viewport.js 必须存在 ！
    controllers: ['MainController', 'system.Menu'],
    launch: function () {
        // 页面加载完成之后执行
        // 关闭再入系统提示罩
        Ext.getBody().unmask();
        // 初始化Tips
        Ext.tip.QuickTipManager.init();
        // 引入工具类
        Ext.require(['DSN.ux.CommonUtil', 'DSN.ux.BizUtil']);
    }
});