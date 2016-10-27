Ext.define('CA.view.system.Header', {
	extend : 'Ext.panel.Panel',
	border : false,
	layout : 'anchor',
	region : 'north',
//	height : 50,
	items : [new Ext.Toolbar({
		items : [{
			id : 'header-top',
			xtype : 'box',
			border : false,
			// anchor : 'none -25',
			html : '<span style="margin-left:10px;font-size:30;FONT-FAMILY:微软雅黑">SHARE-FREE</span>'
		}, {
			xtype : 'label',
			id : 'head-lb-3',
			margin : '0 20 0 50',
			text : '当前日期：2013-03-20'
		}, '->', {
			xtype : 'button',
			text : '打开首页',
			tooltip : '全屏显示主操作窗口',
			handler : function() {

			}
		}, '-', {
			xtype : 'button',
			text : '注销',
			handler : function() {

			}
		}, '-']
	})]
});
