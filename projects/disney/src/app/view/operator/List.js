Ext.define('DSN.view.operator.List', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.operatorlist',
    title: '用户信息列表',
    initComponent: function () {
        this.store = {
            fields: ['id', 'name', 'age', 'sex'],
            data: [
                {id: 1, name: 'zhangsan', age: 18, sex: 'boy'},
                {id: 2, name: 'lishi', age: 20, sex: 'girl'}
            ]
        };
        this.columns = [
            {header: '编号', dataIndex: 'id', flex: 1},
            {header: '姓名', dataIndex: 'name', flex: 1},
            {header: '年龄', dataIndex: 'age', flex: 1},
            {header: '性别', dataIndex: 'sex', flex: 1}
        ];
        this.callParent(arguments);
    }
});