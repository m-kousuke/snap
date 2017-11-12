<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="beans.LearningFile"%>
<%@ page import="java.util.ArrayList"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<LearningFile> fileList = (ArrayList<LearningFile>) request.getAttribute("fileList");
	String studentId = (String) session.getAttribute("studentId");
	int lessonId = (Integer) session.getAttribute("lessonId");
%>

<!DOCTYPE html>
<html>
<head>
<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>ルーブリック確認画面4</title>
</head>
<jsp:include page="../common/jsp/student.jsp" />

<div class="container">
	<div class="row" style="padding: 90px 0 0 0">
		<div class="col-xs-4 col-sm-4 col-md-4">
			<button class="btn btn-success">学習成果物登録</button>
			<br>
			<br>
			①下の
			<button class="btn btn-default">
				<span class="glyphicon glyphicon-folder-open"></span>
			</button>
			をおしてください
			<br>
			②
			<Strong>必ず最後に「upload」をおしてください</Strong>
			<form action="UploadFileStudentServlet" method="POST" class="form-inline" enctype="multipart/form-data">
				<div class="input-group">
					<input type="file" id="file_input" name="fl" size="75" style="display: none;" required>
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" onclick="$('#file_input').click();">
							<i class="glyphicon glyphicon-folder-open"></i>
						</button>
					</span>
					<div class="input-group">
						<input id="file" type="text" class="form-control" required disabled>
					</div>
				</div>
				<button type="submit" class="btn btn-info">upload</button>
			</form>
			<br>

			<form action="DeleteFileStudentServlet" method="POST">
				<%
					if (fileList.size() == 0) {
						out.println("<br>");
					} else if (fileList.size() != 0) {
						out.println("※ファイル名をクリックするとDownloadされます");
						for (int h = 0; h < fileList.size(); h++) {
							out.println("<br>");
							out.println("<a href='../LearningFile/" + studentId + "/" + lessonId + "/"
									+ fileList.get(h).getFileName() + "' download='" + fileList.get(h).getFileName() + "'>");
							out.println(fileList.get(h).getFileName());
							out.println("</a>");
							out.println("&nbsp;&nbsp;&nbsp;");
							out.println("<button type='submit' class='btn btn-danger btn-sm' name='fileId' value="
									+ fileList.get(h).getId() + ">消去</button>");
						}
					}
				%>
			</form>
			<br>
		</div>

		<div class="col-xs-8 col-sm-8 col-md-8">
			<!-- rubricのみを表示 -->
			<table class="table table-bordered" style="table-layout: fixed;">
				<thead>
					<tr>
						<th>大項目</th>
						<th>小項目</th>
						<th>A</th>
						<th>B</th>
						<th>C</th>
						<th>D</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td rowspan="4">内容評価</td>
						<td>ＩＣＴを活用した授業のデザイン（2つ以上）と，ＩＣＴ活用の「教訓」の言及</td>
						<td>完璧な記述</td>
						<td>記述はあるが改善の余地あり</td>
						<td>記述が不十分</td>
						<td>記述がない</td>
					</tr>
					<tr>

						<td>上記で提案した授業における声掛けの具体例と、そのように考える理由</td>
						<td>完璧な記述</td>
						<td>記述はあるが改善の余地あり</td>
						<td>記述が不十分</td>
						<td>記述がない</td>
					</tr>
					<tr>
						<td>ICTを活用して、家庭学習と授業を学びを結びつけるための工夫</td>
						<td>完璧な記述</td>
						<td>記述はあるが改善の余地あり</td>
						<td>記述が不十分</td>
						<td>記述がない</td>
					</tr>
					<tr>
						<td>「あなたがＣｈａｎｇｅ」したこと</td>
						<td>完璧な記述</td>
						<td>記述はあるが改善の余地あり</td>
						<td>記述が不十分</td>
						<td>記述がない</td>
					</tr>
				</tbody>
			</table>
			<!-- 自己評価、相互評価を行うか選択させる。選択させる部分は、Linkにする -->
			<a href="SearchRubricForSelfStudentServlet" class="btn btn-primary">自己評価</a>
			<a href="SearchStudentForPeerStudentServlet" class="btn btn-primary">相互評価</a>
			<a href="SearchLessonStudentServlet" class="btn btn-default">授業を選ぶ画面にもどる</a>
		</div>
	</div>
</div>

</body>
<script src="../common/colorbox/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#file_input').change(function() {
			$('#file').val($(this).val());
		});
	})
</script>
</html>