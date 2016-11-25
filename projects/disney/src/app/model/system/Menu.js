Ext.define('DSN.model.system.Menu', {
    extend: 'Ext.data.Model',
    fields: ['id', 'text', 'cls', 'stores', 'columns', 'url',
        'expanded', 'optype']
});