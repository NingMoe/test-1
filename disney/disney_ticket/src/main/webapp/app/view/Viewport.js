Ext.define('CA.view.Viewport', {
			extend : 'Ext.Viewport',
			layout : 'fit',
			hideBorders : true,
			requires : ['CA.view.system.Header', 'CA.view.system.Menu',
					'CA.view.system.TabPanel', 'CA.view.system.South'],
			initComponent : function() {
				Ext.apply(this, {
							items : [{
										id : 'desktop',
										layout : 'border',
										items : [
												Ext
														.create('CA.view.system.Header'), // 创建上侧头
												Ext
														.create('CA.view.system.Menu'), // 创建左侧菜单
												Ext
														.create('CA.view.system.TabPanel'), // 创建中间panel选项卡
												Ext
														.create('CA.view.system.South') // 创建下侧栏
										]
									}]
						});
				this.callParent(arguments);
			}
		});