/**
 * 基础控制器
 */
Ext.define('DSN.controller.BaseController', {
    extend: 'Ext.app.Controller',
    showView: function(tabId, record){
        if(this.mainView){
            return Ext.createWidget(this.mainView, {
                id: tabId,
                title: record.text,
                closable: true
            });
        }else{
            // 没有定义主页面
        }
    }
});