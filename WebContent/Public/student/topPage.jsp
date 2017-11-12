<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>ホーム画面</title>
</head>

<jsp:include page="../common/jsp/student.jsp" />

	<div class="container">
		<div class="row" style="padding: 90px 0 0 0">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div style="margin-top: 0px; padding-bottom: 0px;">
					<a href="SearchLessonStudentServlet">
						<font size="+2">
							<span class="glyphicon glyphicon-phone" aria-hidden="true"></span> 学習をふりかえる
						</font>
					</a>
					<br>
					<br>
				</div>
			</div>
		</div>
	</div>

  </body>
</html>