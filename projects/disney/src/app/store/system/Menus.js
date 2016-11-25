Ext.define('DSN.store.system.Menus', {
    extend: 'Ext.data.TreeStore',
    // requires: 'DSN.model.system.Menu',
    model: 'DSN.model.system.Menu',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        async: true,
        url: 'data/menu.json',
        reader: {
            type: 'json',
            successProperty: 'success'
        }
    }
});
