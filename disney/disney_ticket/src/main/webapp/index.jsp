<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
var socket =null;
$(function(){
	function parseObj(strData){//转换对象
	    return (new Function( "return " + strData ))();
	};
	//创建socket对象
	socket = new WebSocket("ws://"+ window.location.host+"${pageContext.request.contextPath}/main?token=T1BUX1RPS0VOX1RFU1Q6eHVwZW5nZmVpOjIwMTYxMDMxMTc0NzU1");
	//连接创建后调用
	socket.onopen = function() {
		$("#showMsg").append("连接成功...<br/>");
	};
	//接收到服务器消息后调用
	socket.onmessage = function(message) {
		var data=parseObj(message.data);
		$("#showMsg").append("<span style='display:block'>"+data.msg+"</span>");
	};
	//关闭连接的时候调用
	socket.onclose = function(){
		alert("close");
	};
	//出错时调用
	socket.onerror = function() {
		alert("error");
	};
	$("#sendButton").click(function() {
		socket.send($("#msg").val());
	});
	$("#disconnectButton").click(function() {
		socket.close();
	});
});
</script>
</head>
<body>
	<div id="showMsg" style="border: 1px solid; width: 500px; height: 400px; overflow: auto;"></div>
	<div>
		<input type="text" id="msg" /> 
		<input type="button" id="sendButton" value="发送" />
		<input type="button" id="disconnectButton" value="断开连接" />
	</div>
</body>
</html>