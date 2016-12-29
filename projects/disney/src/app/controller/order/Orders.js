Ext.define('DSN.controller.order.Orders', {
    extend: 'DSN.controller.BaseController',
    config: {
        mainView: 'operatoreditlist'
    },
    views: [
        'operator.EditList'
    ],
    init: function () {
        this.control({
            'operatoreditlist': {
                itemdblclick: this.editOperator//添加行双击事件
            }
        });
    },
    editOperator: function (grid, record) {
        console.log('Double clicked on ' + record.get('optName') + ' - ' + record.get('crtTime'));
    }
});