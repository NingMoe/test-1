<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript" src="<%= request.getContextPath()%>/dwr/util.js"></script>
		<script type="text/javascript" src="<%= request.getContextPath()%>/dwr/engine.js"></script>
		<script type="text/javascript" src="<%= request.getContextPath()%>/ui/jquery/jquery-1.9.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/system/icon.css">
		<script type="text/javascript" src="<%= request.getContextPath()%>/ui/system/include.js"></script>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/include.css">
		<link rel="shortcut icon" href="<%= request.getContextPath()%>/resources/icons/logo.ico" type="image/x-icon" />
		<title>飞翔的记忆</title>
		
		<script type="text/javascript">
			var contextPath = request.getContextPath();
			var userName = '${user.userName}';
		</script>
	</head>
	<body>
		<div id="fm_hide">
		</div>
		<div id="fm_face">
			<ul id="fm_face_left">
				<li class="logo_main"></li>
				<c:forEach items="${allMenu}" var="menu">
					<c:if test="${empty menu.parent}">
						<li><a href="${menu.menuUrl}">${menu.menuName}</a>
						<c:if test="${!empty menu.children}">
							<ul class="subnav">
								<c:forEach items = "${menu.children}" var="subMenu">
									<c:if test="${subMenu.menuState == '0'}">
										<li><a href="${contextPath}${subMenu.menuUrl}">${subMenu.menuName}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</c:if>
						</li>
					</c:if>
				</c:forEach>
			</ul>
			<ul id="fm_face_right">
				<li id="fm_login"><a>登录</a></li>
				<li><a>退出</a></li>
				<li><a>个人</a></li>
				<li><a>设置</a></li>
				<li class="right_subnav">
				</li>
			</ul>
		</div>
		<!-- 主页面 -->
<!-- 	<div id="include_msg_show">
		<ul>
			<li id="include_msg_head"><span id="include_msg_head_show"></span></li>
			<li id="include_msg_body"><span id="include_msg_body_show"></span></li>
		</ul>
	</div>
	-->
	</body>
</html>