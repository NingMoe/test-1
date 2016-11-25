Ext.define('DSN.view.system.Menu', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.dynamicmenu',	// 别名为dynamicmenu
    // controllers: ['DSN.controller.system.Menu'],
    initComponent: function () {
        Ext.apply(this, {
            id: 'app-menu',
            title: '系统菜单',
            margins: '0 0 -1 1',
            region: 'west',
            border: false,
            enableDD: false,
            split: true,
            width: 212,
            minSize: 130,
            maxSize: 300,
            rootVisible: false,
            containerScroll: true,
            collapsible: true,
            autoScroll: false,
            store: Ext.create('DSN.store.system.Menus')
        });
        this.callParent(arguments);
    }
});
