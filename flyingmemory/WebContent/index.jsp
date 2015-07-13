<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="<%= request.getContextPath()%>/resources/icons/logo.ico" type="image/x-icon" />
		<title>飞翔的记忆</title>
	</head>
	<body>
		<s:action name="MenuAction" executeResult="true"></s:action>
	</body>
</html>