Ext.Loader.setConfig({
    // 开启动态加载
    enabled: true
});

Ext.require('Ext.app.Application', function () {
    Ext.app.Application.addMembers({
        //加载Controller后触发事件
        newControllerAdded: function (idx, cntr) {
            cntr.init(this);
        },
        //判断是否已加载指定Controller，返回Boolean
        hasController: function (name) {
            return !!this.controllers.get(name);
        },
        //加载并返回指定Controller
        addController: function (name) {
            return this.getController(name);
        }
    });
});
Ext.application({
    name: 'DSN', // 项目名称
    appFolder: 'app', // 指定根目录
    autoCreateViewport: true, // 文件：app/view/Viewport.js 必须存在 ！
    controllers: ['system.Menu'],
    launch: function () {
        // 页面加载完成之后执行

    }
});