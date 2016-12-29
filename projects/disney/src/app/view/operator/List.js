Ext.define('DSN.view.operator.List', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.operatorlist',
    frame: true, //面板渲染
    title: '用户信息列表',
    columnLines: false, //列的边框
    /*viewConfig: {
     stripeRows: true,//在表格中显示斑马线
     enableTextSelection: true //可以复制单元格文字
     },*/
    initComponent: function () {
        // 表格列定义
        var columns = [
            Ext.create('Ext.grid.RowNumberer'),
            {header: '姓名', dataIndex: 'optName'},
            {header: '性别', dataIndex: 'gender', align: 'center', renderer: formatGenger},
            {header: '联系方式', dataIndex: 'tel'},
            {header: '状态', dataIndex: 'status', align: 'right'},
            {header: '创建时间', dataIndex: 'crtTime', width: 200, renderer: formatDate, flex: 1}
        ];
        // 表格数据源
        var store = Ext.create('DSN.store.system.Operators', {
            listeners: {
                'beforeload': function (store, options) {
                    console.log(options);
                    console.log(dockedItems.getValues());
                    var params = {
                        //参数
                        // pageNumber: op.page,
                        // pageSize: op.limit
                    };
                    Ext.apply(store.proxy.extraParams, params);
                }
            }
        });
        // 查询数据之前，加载必要参数

        // 表格头部元素（查询条件，操作按钮等）
        var dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
            displayInfo: true,
            items: [{xtype: 'textfield', name: 'optName', fieldLabel: '姓名', labelAlign: 'left', labelWidth: 45},
                {xtype: 'textfield', name: 'tel', fieldLabel: '联系方式', labelAlign: 'left', labelWidth: 35},
                {
                    xtype: 'button', text: '查询', iconCls: 'Usermagnify',
                    listeners: {
                        click: function () {
                            store.reload();
                        }
                    }
                }]
        }, {
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
        }];
        // 表格底部分页信息
        var bbar = Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            emptyMsg: "没有记录"
        });
        // 表格数据选中模式及监听事件
        var sm = Ext.create('Ext.selection.CheckboxModel', {
            listeners: {
                selectionchange: function (sm, selections) {
                    /!*grid4.down('#removeButton').setDisabled(selections.length === 0);*!/
                }
            }
        });
        // grid元素加载
        Ext.apply(this, {
            columns: columns,
            store: store,
            bbar: bbar,
            selModel: sm,
            dockedItems: dockedItems
        });
        this.callParent(arguments);
    }
});