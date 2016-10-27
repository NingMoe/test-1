Ext.onReady(function() {

			Ext.QuickTips.init();
			Ext.form.Field.prototype.msgTarget = 'side';

			var loginForm = new Ext.form.FormPanel({
						frame : true,
						border : false,
						width : 250,
						height : 100,
						labelWidth : 0,
						items : [{
									xtype : 'textfield',
									fieldLabel : '账号',
									allowBlank : false,
									width : 200,
									value : '2010415108',
									blankText : '请输入账号',
									name : 'userNo',
									id : 'oprid'
								}, {
									xtype : 'textfield',
									fieldLabel : '密码',
									allowBlank : false,
									inputType : 'password',
									width : 200,
									value : '000000',
									blankText : '请输入密码',
									name : 'password',
									id : 'password'
								}],
						buttonAlign : 'center',
						buttons : [{
							text : '登录',
							id : 'login',
							handler : function() {
								if (loginForm.getForm().isValid()) {
									login();
								}
							}
						}, {
							text : '重置',
							id : 'reset',
							handler : function() {
								loginForm.getForm().reset();
							}
						}],
						waitMsgTarget : true
					});

			loginForm.render('loginForm');

			/**
			 * 系统登录
			 */
			function login() {
				Ext.Ajax.request({
							url : 'login',
							method : 'POST',
							params : '{"userNo":"13770270322", "password":"000000"}',
							success : function(response, options) {
								// 登陆成功，跳转到桌面
								window.location.href = "desktop"
							},
							failure : function(response, options) {
								Ext.Msg.alert('错误', response.responseText);
							}
						});
			}

		});