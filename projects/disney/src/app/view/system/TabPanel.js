Ext.define('DSN.view.system.TabPanel', {
    extend: 'Ext.tab.Panel',
    initComponent: function () {
        Ext.apply(this, {
            id: 'tabPanels',
            region: 'center',
            defaults: {
                autoScroll: true,
                bodyPadding: 0
            },
            activeTab: 0,
            border: false,
            items: [{
                id: 'HomePage',
                title: '首页',
                layout: {
                    type: 'hbox',
                    pack: 'start',
                    align: 'stretch'
                },
                items: []
            }]
        });
        this.callParent(arguments);
    }
});
