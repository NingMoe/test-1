Ext.define('DSN.view.operator.List', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.operatorlist',
    title: '用户信息列表',
    columns: [
        {header: '编号', dataIndex: 'optId'},
        {header: '姓名', dataIndex: 'optName'},
        {header: '性别', dataIndex: 'gender'},
        {header: '联系方式', dataIndex: 'tel'},
        {header: '状态', dataIndex: 'status'},
        {header: '创建时间', dataIndex: 'crtTime', flex: 1}
    ],
    initComponent: function () {
        var store = Ext.create(
            'DSN.store.system.Operators', {
            });
        this.store = store;
        this.bbar = {
            xtype: 'pagingtoolbar',
            store: store,
            displayInfo: true
        };
        this.callParent(arguments);
    }
});