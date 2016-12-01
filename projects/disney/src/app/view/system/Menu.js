Ext.define('DSN.view.system.Menu', {
    extend: 'Ext.panel.Panel',
    layout: 'accordion', //手风琴布局
    iconCls: 'Applicationsidelist',
    alias: 'widget.dynamicmenu',
    initComponent: function () {
        Ext.apply(this, {
            id: 'app-menu',
            title: '系统菜单',
            margins: '1 1 0 0',
            region: 'west',
            collapsible: true, // 可以折叠
            border: true,
            collapseDirection: false,
            // split: true,
            width: 200
        });
        this.callParent(arguments);
    }
});
