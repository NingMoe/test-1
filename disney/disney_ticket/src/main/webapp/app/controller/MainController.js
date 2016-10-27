/**
 * 程序控制器
 */
Ext.define('CA.controller.MainController', {
			extend : 'Ext.app.Controller',
			requires : [],
			views : ['system.Menu'],
			ctr : {},
			init : function() {
				// 初始化部分，下面是部分是给菜单绑定单击事件
				this.control({
							'dynamicmenu' : {
								itemclick : this.loadFunction
							}
						});
			},
			loadFunction : function(view, rec, item, index, eventObj) {/*
				var self = this;
				var tabs = Ext.getCmp('tabs');// 获取主选项卡
				var tabId = 'functionTab' + rec.get('functionId');// 获取记录的的值
				var tab = tabs.queryById(tabId);// 根据id获取选项卡
				if (null != tab) {
					tabs.setActiveTab(tab);// 激活选项卡
				} else {
					tabs.getEl().mask('加载中...');
					Ext.require('CC.controller.' + rec.get('functionController'),
							function() {// 加载须要的控制器
								Ext.require(rec.get('functionPanel'),
										function() {// 加载需要的控制面板
											self.getController(rec
													.get('functionController'));// 控制器导入
											var tab = Ext.create(
													rec.get('functionPanel'), {// 创建tablpanel
														title : rec.get('text'),
														id : tabId
													});
											tabs.insert(1, tab);// 添加到第一位中
											tabs.setActiveTab(tab);// 激活
											tabs.unmask();// 等待取消
										});
							});
				}*/
			}
		});