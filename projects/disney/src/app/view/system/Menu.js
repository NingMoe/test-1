Ext.define('DSN.view.system.Menu', {
    extend: 'Ext.panel.Panel',
    layout: 'accordion', //手风琴布局
    // iconCls: 'Applicationsidelist',
    alias: 'widget.dynamicmenu',
    initComponent: function () {
        Ext.apply(this, {
            id: 'app-menu',
            // title: '系统菜单',
            // margins: '1 1 0 0',
            region: 'west',
            width: 200,
            minWidth: 150,
            maxWidth: 400,
            collapsible: true, // 可以折叠,
            // split: true,
            border: true
        });
        this.callParent(arguments);
    }
});
