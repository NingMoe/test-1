/**
 * 基础控制器
 */
Ext.define('DSN.controller.BaseController', {
    extend: 'Ext.app.Controller',
    getTabView: function(tabId, record){
        if(this.mainView){
            return Ext.createWidget(this.mainView, {
                id: tabId,
                title: record.text,
                iconCls: record.iconCls,
                closable: true
            });
        }else{
            // 没有定义主页面
        }
    }
});