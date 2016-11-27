/**
 * 程序控制器
 */
Ext.define('DSN.controller.MainController', {
    extend: 'Ext.app.Controller',
    init: function () {/*
        // 初始化部分，下面是部分是给菜单绑定单击事件
        this.control({
            'dynamicmenu': {
                itemclick: this.loadFunction
            }
        });
    },
    loadFunction: function (view, rec) {
        var record = rec.raw;
        if (record.leaf) {
            // var app =DSN.getApplication();
            // 动态加载controller
            var controller = this.addController(record.ctrl);
            if (controller) {
                var desktop = Ext.getCmp("tabPanels");
                var tabId = 'tabPanel' + record.id;
                var tab = desktop.getComponent(tabId);
                if (!tab) {
                    desktop.getEl().mask('加载中...');
                    tab = controller.mainView(tabId, record);
                    // desktop.add(newTab);
                    desktop.insert(1, tab);// 添加到第一位中
                    desktop.setActiveTab(tab);
                    desktop.unmask();// 等待取消
                } else {
                    desktop.setActiveTab(tab);
                }
            }
        }
    },
    addController: function(name) {
        var app =DSN.getApplication();
        var controller = app.controllers.get(name);

        if (!controller) {
            var path = app.getModuleClassName(name, 'controller');
            Ext.require(path, function () {
                controller = Ext.create(app.getModuleClassName(name, 'controller'), {
                    application: app,
                    id: name
                });
                app.controllers.add(controller);
            });
        }

        return controller;*/
    }

});