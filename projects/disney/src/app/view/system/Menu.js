Ext.define('DSN.view.system.Menu', {
    extend: 'Ext.panel.Panel',
    layout: 'accordion', //手风琴布局
    alias: 'widget.dynamicmenu',
    initComponent: function () {
        Ext.apply(this, {
            id: 'app-menu',
            title: '系统菜单',
            margins: '1 1 0 0',
            region: 'west',
            collapsible: true, // 可以折叠
            border: true,
            // split: true,
            width: 200,
            animate: false, // 有滑动效果

            // containerScroll: false,
            // activeOnTop: false,
            hideCollapseTool: true
        });
        this.callParent(arguments);
    }
});
