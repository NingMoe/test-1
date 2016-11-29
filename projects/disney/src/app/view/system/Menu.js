Ext.define('DSN.view.system.Menu', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.dynamicmenu',
    initComponent: function () {
        Ext.apply(this, {
            id: 'app-menu',
            title: '系统菜单',
            margins: '1 1 0 0',
            region: 'west',
            border: true,
            // split: true,
            width: 200,
            animate : false, // 有滑动效果
            rootVisible: false,
            containerScroll: false,
            collapsible: true, // 可以折叠
            autoScroll: false,
            store: Ext.create('DSN.store.system.Menu')
        });
        this.callParent(arguments);
    }
});
