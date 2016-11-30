Ext.define('DSN.store.system.Menu', {
    extend: 'Ext.data.TreeStore',
    model: 'DSN.model.system.Menu',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        // url: 'api/system/menu',
        url: 'data/menu.json',
        reader: {
            type: 'json',
            successProperty: 'success',
            root: 'results'
        }
    }
});
