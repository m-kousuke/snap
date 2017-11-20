<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	HttpSession session2 = request.getSession(true);
	session2.setAttribute("lessonId", request.getParameter("lessonId"));
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/snap/Public/common/css/style.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="/snap/Public/common/bootstrap/css/bootstrap.min.css" media="all" />
<title>ログイン画面</title>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-brand">snap</div>
	</nav>

	<br>
	<br>
	<br>
	<br>


	<p align="center">
		<a href="FacilitationServlet"> <font size="+2">
				ファシリテーションを実行する </font>
		</a>
	</p>



</body>
</html>