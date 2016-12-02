Ext.define('DSN.view.operator.List', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.operatorlist',
    frame: true, //面板渲染
    title: '用户信息列表',
    columnLines: true,
    /*viewConfig: {
     stripeRows: true,//在表格中显示斑马线
     enableTextSelection: true //可以复制单元格文字
     },*/
    initComponent: function () {
        var store = Ext.create('DSN.store.system.Operators');
        var bbar = Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true
        });
        var selModel = Ext.create('Ext.selection.CheckboxModel', {
            listeners: {
                selectionchange: function (sm, selections) {
                    /!*grid4.down('#removeButton').setDisabled(selections.length === 0);*!/
                }
            }
        });
        Ext.apply(this, {
            columns: [
                Ext.create('Ext.grid.RowNumberer'),
                {header: '姓名', dataIndex: 'optName'},
                {header: '性别', dataIndex: 'gender',align: 'center', renderer: formatGenger},
                {header: '联系方式', dataIndex: 'tel'},
                {header: '状态', dataIndex: 'status', align: 'right'},
                {header: '创建时间', dataIndex: 'crtTime', width: 200, renderer: formatDate, flex: 1}
            ],
            store: store,
            bbar: bbar,
            selModel: selModel,
            dockedItems: [{
                xtype: 'toolbar',
                items: [{
                    text: 'Add Something',
                    tooltip: 'Add a new row',
                    iconCls: 'Add'
                }, '-', {
                    text: 'Options',
                    tooltip: 'Set options',
                    iconCls: 'Plugin'
                }, '-', {
                    itemId: 'removeButton',
                    text: 'Remove Something',
                    tooltip: 'Remove the selected item',
                    iconCls: 'Delete',
                    disabled: true
                }]
            }]
        });
        this.callParent(arguments);
    }
});