$(function(){
    
    $('#fm_face li').addClass('fm_face_em');
    
    $("#fm_face_left li").hover(function(){
			$(this).find("ul.subnav").slideToggle(500);
        }
    );
/*	
	$('#fm_face_right li').click(function() {
		$('#fm_hide').slideToggle(500);
	});
	*/
	
	$('#fm_login').click(function() {
		$('.right_subnav').css('cursor','default');
		$('.right_subnav').html(
				'<form id="loginForm">' +
/*				'	<table width="300" height="150" border="1" align="center">' +
				'		<tr>' +
				'			<td width="30%">用户ID：</td>' +
				'			<td><input type="text" id="username_R" name="username" class="inputCss"/></td>' +
				'		</tr>' +
				'		<tr>' +
				'			<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>' +
				'			<td><input type="password" id="password_R" name="password" class="inputCss"/></td>' +
				'		</tr>' +
				'		<tr>' +
				'			<td align="center"><input type="reset"/></td>' +
				'			<td style="padding-left:30%"><input type="button" id="registerBtn" value="注册"/></td>' +
				'		</tr>' +
				'	</table>' +*/
				'	<label for="username_L">用户ID：</label>' +
				'	<input type="text" id="username_L" name="username" class="inputCss"/>' +
				'	<br />' +
				'	<label for="password_L">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>' +
				'	<input type="password" id="password_L" name="password" class="inputCss"/>' +
				'	<br />' +
				'	<input type="button" id="loginBtn" value="登录"/>' +
				'</form>');
		$('.right_subnav').slideToggle(500);
		
		$("#loginBtn").click(function () {
	    $.ajax({
	        url: 'TestAction.do?method=login',
	        type: 'post',
            dataType: 'text',
	        data: $("#loginForm").serialize(),
			beforeSend:function(){
				if($("#password_L").val()==""||$("#username_L").val()==""){
					return false;
				}
			},
	        success: function(data){
	        	// 将json字符串转换为json对象
				var parsedJson = jQuery.parseJSON(data);
				// 通过key找到value
				if(parsedJson.success){
//					showIncludeMsg('S','F',parsedJson.msg,function() {
						window.location.href ="/page/common/contact/contact_chat.jsp";
//					});
				}else{
//					showIncludeMsg('W','F',parsedJson.msg);
				}
	        }
	    });
	});
	});
	
	
});


























































/*
* type: 消息种类 {S:成功; P:提示; W:警告;}
*
* holdtime: 显示时间 {S:5秒; N:3秒; F:1秒; 自定义值;}
*
* msg: 显示消息 
*
* fn: 回调函数
*
*/
function showIncludeMsg(type,holdtime,msg,fn){
	
	$('#include_msg_body_show').text(msg);
	
	var msg_head = $('#include_msg_head');
	
	var msg_head_show = $('#include_msg_head_show');
	
	var ht = 1000;
	
	switch (type) {
		case 'S':
			msg_head_show.text('成功');
			msg_head.css('background-color','#00BB00');
			break;
		case 'P':
			msg_head_show.text('提示');
			msg_head.css('background-color','#FFDC35');
			break;
		case 'W':
			msg_head_show.text('警告');
			msg_head.css('background-color','#FF0000');
			break;
	}
	
	switch (holdtime) {
		case 'S':
			ht = 5000;
			break;
		case 'N':
			ht = 3000;
			break;
		case 'F':
			ht = 1000;
			break;
		default:
			ht = holdtime;
			break;
	}

	$('#include_msg_show').animate({
		top:'80px'
    },500);
    
    setTimeout(function() {
    	$('#include_msg_show').animate({
			top:'-300px'
	    },500,fn);
    }, ht);
	
}
