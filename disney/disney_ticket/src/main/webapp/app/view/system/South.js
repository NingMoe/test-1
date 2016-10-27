Ext.define('CA.view.system.South', {
			extend : 'Ext.Toolbar',
			initComponent : function() {
				Ext.apply(this, {
							id : "bottom",
							// frame:true,
							region : "south",
							height : 23,
							items : ['->', "版权所有 [SHARE-FREE]",
									'->']
						});
				this.callParent(arguments);
			}
		});
