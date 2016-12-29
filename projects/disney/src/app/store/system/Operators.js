Ext.define('DSN.store.system.Operators', {
    extend: 'Ext.data.Store',
    model: 'DSN.model.system.Operator',
    autoLoad: true,
    pageSize: 5, // 默认每页数据量
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
    }
});