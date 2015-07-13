$(function(){
	dwr.engine.setActiveReverseAjax(true);
	$('body').keydown(function(){
		if (event.keyCode == "13") {//keyCode=13是回车键
			if($('#write_text').focus()){
				var text = $("#write_text").val().substring(0,40);
				if(text != ''){
					$("#write_text").val('');
					// 发送数据
					SendMsg.sendMsg(text);
/*				    $.ajax({
				        url: 'Game_Idiom_Action.do',
				        type: 'post',
			            dataType: 'text',
				        data: {reqIdiom: text},
				        success: function(data){
				        	// 将json字符串转换为json对象
							var parsedJson = jQuery.parseJSON(data);
							// 通过key找到value，显示系统接收的数据
							$('#show_view').append('<li class="msg_in">'+parsedJson.msg+'</li>');
						    // 滚动条到最底部
							$('#show_view').scrollTop($('#show_view')[0].scrollHeight);
				        }
				    });*/
				}
			}
		}
	});
	
	setInterval(startRequest,1000);
	
	function startRequest()
	{
		$("#right_view").text(new Date().toString());
	}
});

var myMsg;
var elseMsg;
	
// 显示系统接收的数据
function show(data){
	// 解析返回的json数据
	var parsedJson = jQuery.parseJSON(data);
	// 验证返回的消息是否是本人发送的
	
	if(parsedJson.username == '0000'){
//		alert('查看消息！');
		showIncludeMsg('P','N',parsedJson.msg);
	}
	else if(parsedJson.username == userName){
		myMsg = '<li class="msg_out">'+
					'<p><u><font>'+parsedJson.username+'</font>&nbsp;&nbsp;['+parsedJson.time+']</u></p>'+
					'<span>'+parsedJson.msg+'</span>'+
				'</li>';
		$('#show_view').append(myMsg);
	}
	else{
		elseMsg = '<li class="msg_in">'+
					'<p><u>['+parsedJson.time+']&nbsp;&nbsp;<font>'+parsedJson.username+'</font></u></p>'+
					'<span>'+parsedJson.msg+'</span>'+
				'</li>';
		$('#show_view').append(elseMsg);
	}
    // 滚动条到最底部
	$('#show_view').scrollTop($('#show_view')[0].scrollHeight);
}
