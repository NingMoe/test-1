Ext.define('DSN.view.system.South', {
    extend: 'Ext.Toolbar',
    initComponent: function () {
        Ext.apply(this, {
            id: "app-bottom",
            // frame:true,
            region: "south",
            height: 23,
            items: ['->', "版权所有 [SHARE-FREE]",
                '->']
        });
        this.callParent(arguments);
    }
});
