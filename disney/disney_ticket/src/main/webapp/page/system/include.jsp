<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="No-cache">
		<meta http-equiv="Cache-Control"
			content="no-cache, must-revalidate,text/html; charset=UTF-8">
		<meta http-equiv="Expires" content="0">
		
		<script type="text/javascript" src="<%=path%>/ext/ext-all.js"></script>
		<script type="text/javascript" src="<%=path%>/ext/ext-lang-zh_CN.js"></script>
		
		<link rel="stylesheet" type="text/css" href="<%=path%>/ext/resources/css/ext-all.css" />
		
		<title>SHARE-FREE</title>
	</head>
	<body>
		<!-- 定义全局变量 -->
		<script type="text/javascript">
			Ext.contextPath = '<%=path%>';
		</script>
	</body>
</html>