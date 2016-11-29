Ext.define('DSN.model.system.Menu', {
    extend: 'Ext.data.Model',
    fields: [{name : "id",type : "string"},
        {name : "text",type : "string"},
        {name : "iconCls",type : "string"},
        {name : "leaf",type : "boolean"},
        {name : "expanded",type : "boolean"},
        {name : 'url',type:"string"},
        {name : 'description',type:"string"}]
});