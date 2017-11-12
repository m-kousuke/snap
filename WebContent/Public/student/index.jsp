<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/snap/Public/common/css/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="/snap/Public/common/bootstrap/css/bootstrap.min.css" media="all" />
<title>ログイン画面</title>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-brand">snap</div>
	</nav>

	<div class="container">
		<div id="form">
			<p class="form-title">ログインフォーム</p>
			<form action="/snap/Public/student/LoginStudentServlet" method="POST">
				<p>名前：</p>
				<p class="studentId">
					<input type="text" name="studentId" required maxlength="10">
				</p>
				<p>パスワード：</p>
				<p class="pass">
					<input type="password" name="password" required maxlength="10">
				</p>
				<p class="submit">
					<input type="submit" value="ログイン" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>