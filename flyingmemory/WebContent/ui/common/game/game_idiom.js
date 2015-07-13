$(function(){
	$('body').keydown(function(){
		if (event.keyCode == "13") {//keyCode=13是回车键
			if($('#write_text').focus()){
				var text = $("#write_text").val().substring(0,40);
				if(text != ''){
					// 显示发送的成语
					$('#show_view').append('<li class="msg_out">'+ text +'</li>');
					
					// 发送成语
				    $.ajax({
				        url: 'Game_Idiom_Action.do',
				        type: 'post',
			            dataType: 'text',
				        data: {reqIdiom: text},
				        success: function(data){
				        	// 将json字符串转换为json对象
							var parsedJson = jQuery.parseJSON(data);
							// 通过key找到value，显示系统的回答
							$('#show_view').append('<li class="msg_in">'+parsedJson.msg+'</li>');
						    // 滚动条到最底部
							$('#show_view').scrollTop($('#show_view')[0].scrollHeight);
				        }
				    });
				}
			}
		}
	});
	
	setInterval(startRequest,1000);
	
	function startRequest()
	{
		$("#right_view").text((new Date()).toString());
	}
});
