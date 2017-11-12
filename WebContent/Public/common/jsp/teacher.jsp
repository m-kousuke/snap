<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String teacherName = (String) session.getAttribute("teacherName");
%>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<div class="navbar-brand">大泉小学校(教師用画面)</div>
		</div>

		<div class="collapse navbar-collapse navbar-fixed-top">
			<ul class="nav navbar-nav pull-right">
				<li class="navbar-text">
					<font size="+1">
						利用者：<%
						out.println(teacherName);
					%>
					</font>
				</li>
				<li>
					<a href="##" onClick="topCheck()">
						<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
						<font size="+1">ホーム画面</font>
					</a>
				</li>
				<li>
					<a href="##" onClick="check()">
						<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						<font size="+1">ログアウト</font>
					</a>
				</li>
			</ul>
		</div>
	</nav>

	<script type="text/javascript">
		function check() {
			if (window.confirm('ログアウトしてよろしいでしょうか？(ログイン画面に戻ります)')) {
				location.href = "LogoutTeacherServlet";
				return true;
			} else {
				window.alert('キャンセルされました');
				return false;
			}
		}
	</script>

	<script type="text/javascript">
		function topCheck() {
			if (window.confirm('ホーム画面に戻ります')) {
				location.href = "topPage.jsp";
				return true;
			} else {
				window.alert('キャンセルされました');
				return false;
			}
		}
	</script>