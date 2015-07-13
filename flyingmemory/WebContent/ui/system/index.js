/*$(function(){
	
    $(window).load(function() {
    	$(".main_view").animate({
	      top:'100px'
	    },1000);
    });
    
    $("#control_register").click(function () {
		// 表单重置
		$("#registerForm")[0].reset();
		$("#registerForm").find(".inputErrorCss").remove();
    	$("#register").animate({
	      left:'0px'
	    });
    });
    
    $("#rewind").click(function () {
    	$("#register").animate({
	      left:'-100%'
	    });
    });
    
    $("#control_login").click(function () {
    	$("#login").animate({
	      right:'0px'
	    });
    });
    
    $("#forward").click(function () {
    	$("#login").animate({
	      right:'-100%'
	    });
    });
    
     //文本框失去焦点后
    $('form :input').blur(function(){
         var $parent = $(this).parent();
         $parent.find(".inputErrorCss").remove();
         //验证用户名
         if( $(this).is('#username_R') ){
            if( this.value=="" || this.value.length > 20 ){
                var errorMsg = '用户ID不超过20位.';
                $parent.append('<span class="inputErrorCss">'+errorMsg+'</span>');
            }else{
            }
         }
         //验证密码
         if( $(this).is('#password_R') ){
            if( this.value=="" || ( this.value.length != 6 ) ){
                  var errorMsg = '密码为6位字符.';
                  $parent.append('<span class="inputErrorCss">'+errorMsg+'</span>');
            }else{
            }
         }
    }).keyup(function(){
    	$(this).triggerHandler("blur");
    }).focus(function(){
    	$(this).triggerHandler("blur");
    });
    
	$("#registerBtn").click(function () {
	    $.ajax({
	        url: 'TestAction.do?method=register',
	        type: 'post',
            dataType: 'text',
	        data: $("#registerForm").serialize(),
			beforeSend:function(){
				if($(".inputErrorCss").html() != undefined
				||$("#username_R").val()==""
				||$("#password_R").val()==""){
					return false;
				}
			},
	        success: function(data){
	        	// 将json字符串转换为json对象
				var parsedJson = jQuery.parseJSON(data);
				// 通过key找到value
				if(parsedJson.success){
					showIncludeMsg('S','F',parsedJson.msg,function() {
	    				$("#register").animate({
					      left:'-100%'
					    });
    				});
				}else{
					showIncludeMsg('W','F',parsedJson.msg);
				}
                $("#retMsg").text(parsedJson.success+':'+parsedJson.msg);
                $("#retMsg").val(data);
	        }
	    });
	});
    
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
					showIncludeMsg('S','F',parsedJson.msg,function() {
						window.location.href = contextPath + "/page/common/contact/contact_chat.jsp";
					});
				}else{
					showIncludeMsg('W','F',parsedJson.msg);
				}
	        }
	    });
	});
});
*/