Ext.define('DSN.controller.Operators', {
    extend: 'DSN.controller.BaseController',
    views: [
        'operator.List'
    ],
    init: function () {
        this.control({
            'operatorlist': {
                itemdblclick: this.editOperator//添加行双击事件
            }
        });
    },
    editOperator: function (grid, record) {
        console.log('Double clicked on ' + record.get('name'));
    }
});