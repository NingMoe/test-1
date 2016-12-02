Ext.define('DSN.store.system.Operators', {
    extend: 'Ext.data.Store',
    model: 'DSN.model.system.Operator',
    autoLoad: true,
    pageSize: 5,
    proxy: {
        type: 'ajax',
        url: '/api/operator',
        noCache: false, //设置为false 则不会向后台传参 _dc
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