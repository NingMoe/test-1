/**
 * 基础控制器
 */
Ext.define('DSN.controller.BaseController', {
    extend: 'Ext.app.Controller',

    mainView: function(tabId, record){
        return Ext.createWidget('operatorlist', {
            id: tabId,
            title: record.text,
            closable: true
        });
    }

});