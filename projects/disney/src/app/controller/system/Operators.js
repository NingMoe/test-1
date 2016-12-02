Ext.define('DSN.controller.system.Operators', {
    extend: 'DSN.controller.BaseController',
    config: {
        mainView: 'operatorlist'
    },
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
        console.log('Double clicked on ' + record.get('optName') + ' - ' + record.get('crtTime'));
    }
});