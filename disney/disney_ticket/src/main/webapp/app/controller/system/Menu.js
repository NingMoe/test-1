Ext.define('CA.controller.system.Menu', {
			extend : 'Ext.app.Controller',
			stores : ['system.Menus'],
			models : ['system.Menu'],
			views : ['system.Menu'],
			init : function() {
				// 下面是给菜单绑定单击事件
				this.control({
							'dynamicmenu' : {
								itemclick : this.loadMenu
							}
						});
			},
			loadMenu : function(selModel, record) {
				if (record.get('leaf')) {
					if (record.get('optype') == 'window') {
						var win = Ext.getCmp(record.get('url'));
						if (!win) {
							win = Ext.widget(record.get('url'))
						}
						win.show();
					} else {
						var panel = Ext.getCmp(record.get('id'));
						if (!panel) {
							panel = {
								id : record.get('url'),
								title : record.get('text'),
								xtype : record.get('url'),
								closable : true
							};
							this.openTab(panel, record.get('url'));
						} else {
							var main = Ext.getCmp("content-panel");
							main.setActiveTab(panel);
						}
					}

				}
			},
			openTab : function(panel, id) {
				var o = (typeof panel == "string" ? panel : id || panel.id);
				var main = Ext.getCmp("content-panel");
				var tab = main.getComponent(o);
				if (tab) {
					main.setActiveTab(tab);
				} else if (typeof panel != "string") {
					panel.id = o;
					var p = main.add(panel);
					main.setActiveTab(p);
				}

			}

		});