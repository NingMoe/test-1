Ext.define('DSN.view.Viewport', {
    extend: 'Ext.Viewport',
    layout: 'fit',
    hideBorders: false,
    requires: [
        'DSN.view.system.Header',
        'DSN.view.system.Menu',
        'DSN.view.system.TabPanel',
        'DSN.view.system.South'
    ],
    initComponent: function () {
        Ext.apply(this, {
            items: [{
                id: 'desktop',
                layout: 'border',
                items: [
                    Ext.create('DSN.view.system.Header'), // 创建上侧头
                    Ext.create('DSN.view.system.Menu'), // 创建左侧菜单
                    Ext.create('DSN.view.system.TabPanel'), // 创建中间panel选项卡
                    Ext.create('DSN.view.system.South') // 创建下侧栏
                ]
            }]
        });
        this.callParent(arguments);
    }
});