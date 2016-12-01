Ext.define('DSN.store.system.Operators', {
    extend: 'Ext.data.Store',
    model: 'DSN.model.system.Operator',
    autoLoad: true,
    pageSize: 10,
    proxy: {
        type: 'ajax',
        url: '/api/operator',
        reader: {
            type: 'json',
            successProperty: 'success',
            totalProperty: 'total',
            root: 'results',
            idProperty: 'optId'
        }
        /*    },
         listeners: {
         'beforeload': function (store, op, options) {
         var params = {
         //参数
         pageNumber: op.page,
         pageSize: op.limit
         };
         Ext.apply(store.proxy.extraParams, params);
         }*/
    }
});