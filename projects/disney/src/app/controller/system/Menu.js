Ext.define('DSN.controller.system.Menu', {
    extend: 'Ext.app.Controller',
    init: function () {
        // 加载菜单树
        this.loadTree();
        // 下面是给菜单绑定单击事件
        // this.control({
        //     'dynamicmenu': {
        //         itemclick: this.showView
        //     }
        // });
    },
    showView: function (view, rec) {
        var record = rec.raw;
        if (record.leaf) {
            var app = DSN.getApplication();
            // 动态加载controller
            var controller = app.getController(record.url);
            if (controller) {
                var desktop = Ext.getCmp("tabPanels");
                var tabId = 'tabPanel' + record.id;
                var tab = desktop.getComponent(tabId);
                if (!tab) {
                    desktop.getEl().mask('加载中...');
                    tab = controller.getTabView(tabId, record);
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

    /**
     * 将数据节点绑定到菜单树
     * @param json
     */
    buildTree: function (node) {
        var me = this;
        return Ext.create('Ext.tree.Panel', {
            rootVisible: false,
            border: false,
            // lines: false, // 不显示线
            store: Ext.create('Ext.data.TreeStore', {
                root: {
                    expanded: true,
                    children: node.children
                }
            }),
            listeners: {
                itemclick: me.showView
            }
        });
    },

    /**
     * 获取菜单树数据并加载菜单
     */
    loadTree: function () {
        var me = this;
        Ext.Ajax.request({
            url: '/api/system/menu',
            method: 'GET',
            success: function (response) {
                var jsonData = Ext.JSON.decode(response.responseText)
                Ext.each(jsonData.results, function (el) {
                    var panel = Ext.create(
                        'Ext.panel.Panel', {
                            id: el.id,
                            title: el.text,
                            iconCls: el.iconCls,
                            layout: 'fit'
                        });
                    panel.add(me.buildTree(el));
                    Ext.getCmp('app-menu').add(panel);
                });
            },
            failure: function () {
                Ext.MessageBox.show({
                    title: '操作提示',
                    msg: "连接服务器失败",
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        });
    }

});