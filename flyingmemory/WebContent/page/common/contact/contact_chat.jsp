<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/page/system/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript" src="<%= request.getContextPath()%>/dwr/interface/SendMsg.js"></script>
		<script type="text/javascript" src="<%= request.getContextPath()%>/ui/common/contact/contact_chat.js"></script>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/contact_chat.css">

	</head>

<body>
	<center>
		<!-- 主显示区域 -->
		<div class="main_view">
			<ul>
				<!-- 左显示区域 公共显示框和玩家发送框 -->
				<li id="left_view">
					<!-- 公共显示框 -->
					<ul id="show_view">
					</ul>
					<!-- 玩家发送框 -->
					<ul id="write_view">
						<li>
							<!-- <textarea rows="3" cols="49"></textarea> -->
							<input type="text" id="write_text" name="reqIdiom"/>
						</li>
					</ul>
				</li>
				<!-- 右显示区域 在线玩家框 -->
				<li id="right_view">
				</li>
			</ul>
		</div>
		
	</center>
</body>

</html>