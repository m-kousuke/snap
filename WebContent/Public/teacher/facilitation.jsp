<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	session.setAttribute("lessonId", Integer.parseInt(request.getParameter("lessonId")));
	System.out.println(session.getAttribute("lessonId"));
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
		<a href="GoFacilitationForStudentServlet"> <font size="+2">
				ファシリテーションを実行する </font>
		</a>
	</p>



</body>
</html>