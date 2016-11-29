Ext.define('DSN.controller.system.Menu', {
    extend: 'DSN.controller.BaseController',
    views: ['operator.List'],
    init: function () {
        // 下面是给菜单绑定单击事件
        this.control({
            'dynamicmenu': {
                itemclick: this.loadMenu
            }
        });
    },
    loadMenu: function (selModel, record) {
        if (record.get('leaf')) {
            if (record.get('optype') == 'window') {
                var win = Ext.getCmp(record.get('url'));
                if (!win) {
                    win = Ext.widget(record.get('url'))
                }
                win.show();
            } else {
                var desktop = Ext.getCmp("tabPanels");
                var tabId = 'tabPanel' + record.get('id');
                var tab = desktop.getComponent(tabId);
                if (!tab) {
                    desktop.getEl().mask('加载中...');
                    Ext.require('DSN.controller.' + record.get('controller'),
                        function () {// 加载须要的控制器
                            tab = Ext.createWidget(record.get('url'), {
                                id: tabId,
                                title: record.get('text'),
                                closable: true
                            });
                        }
                    );
                    // desktop.add(newTab);
                    desktop.insert(1, tab);// 添加到第一位中
                    desktop.setActiveTab(tab);
                    desktop.unmask();// 等待取消
                } else {
                    desktop.setActiveTab(tab);
                }
            }
        }
    }

});