Ext.define('DSN.store.system.Menu', {
    extend: 'Ext.data.TreeStore',
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
