Ext.define('CA.store.system.Menus', {
			extend : 'Ext.data.TreeStore',
			requires : 'CA.model.system.Menu',
			model : 'CA.model.system.Menu',
			autoLoad : true,
			proxy : {
				type : 'ajax',
				async : true,
				url : 'data/menu.json',
				reader : {
					type : 'json',
					successProperty : 'success'
				}
			}
		});
