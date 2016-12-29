Ext.define('DSN.view.operator.EditList', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.operatoreditlist',
    frame: true, //面板渲染
    title: '用户信息列表',
    columnLines: true,
    initComponent: function () {
        var store = Ext.create('DSN.store.system.Operators');
        var bbar = Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            emptyMsg: "没有记录"
        });
        var sm = Ext.create('Ext.selection.CheckboxModel', {
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
                {header: '性别', dataIndex: 'gender', align: 'center', renderer: formatGenger,editor:{
                    allowBlank:true
                }},
                {header: '联系方式', dataIndex: 'tel'},
                {header: '状态', dataIndex: 'status', align: 'right'},
                {header: '创建时间', dataIndex: 'crtTime', width: 200, renderer: formatDate, flex: 1}
            ],
            selType: 'cellmodel',
            plugins: [
                Ext.create('Ext.grid.plugin.CellEditing', {
                    clicksToEdit: 2
                })
            ],
            store: store,
            bbar: bbar,
            selModel: sm,
            tbar: ['-', {
                text: '添加一行',
                handler: function () {
                    var p = {
                        id: '',
                        name: '',
                        descn: ''
                    };
                    store.insert(0, p);
                }
            }, '-', {
                text: '删除一行',
                handler: function () {
                    Ext.Msg.confirm('系统提示', '确定要删除？', function (btn) {
                        if (btn == 'yes') {
                            var sm = grid.getSelectionModel();
                            var record = sm.getSelection()[0];
                            store.remove(record);
                        }
                    });
                }
            }, '-', {
                text: '保存',
                handler: function () {
                    var m = store.getModifiedRecords().slice(0);
                    var jsonArray = [];
                    Ext.each(m, function (item) {
                        jsonArray.push(item.data);
                    });
                    Ext.Ajax.request({
                        method: 'POST',
                        url: '/ExtJs4.2Pro/EditGridServlet',
                        success: function (response) {
                            Ext.Msg.alert('系统提示', response.responseText, function () {
                                store.load();
                            });
                        },
                        failure: function () {
                            Ext.Msg.alert("错误", "与后台联系的时候出了问题。");
                        },
                        params: 'data=' + encodeURIComponent(Ext.encode(jsonArray))
                    });
                }
            }]
        });
        this.callParent(arguments);
    }
});