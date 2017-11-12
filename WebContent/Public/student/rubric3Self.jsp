<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="beans.LearningFile"%>
<%@ page import="java.util.ArrayList"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<LearningFile> fileList = (ArrayList<LearningFile>) request.getAttribute("fileList");
	@SuppressWarnings("unchecked")
	ArrayList<Integer> responseDataList = (ArrayList<Integer>) request.getAttribute("responseDataList");
	String studentId = (String) session.getAttribute("studentId");
	int lessonId = (Integer) session.getAttribute("lessonId");
%>

<!DOCTYPE html>
<html>
<head>
<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>自己評価画面3</title>
</head>
<jsp:include page="../common/jsp/student.jsp" />

<div class="container">
	<div class="row" style="padding: 90px 0 0 0">
		<div class="col-xs-4 col-sm-4 col-md-4">
			<button class="btn btn-success">登録した学習成果物</button>
			<br>
			<br>
			<%
				if (fileList.size() == 0) {
					out.println("<br>");
				} else if (fileList.size() != 0) {
					out.println("※ファイル名をクリックするとDownloadされます");
					out.println("<br>");
					for (int h = 0; h < fileList.size(); h++) {
						out.println("<br>");
						out.println("<a href='../LearningFile/" + studentId + "/" + lessonId + "/"
								+ fileList.get(h).getFileName() + "' download='" + fileList.get(h).getFileName() + "'>");
						out.println(fileList.get(h).getFileName());
						out.println("</a>");
					}
				}
			%>
			<br>
		</div>

		<div class="col-xs-8 col-sm-8 col-md-8">
			<form action="RecieveResponseDataBySelfAssessmentStudentServlet" method="POST">
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
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response1 value=4 required>");
										} else if ((responseDataList.get(0) == 4)) {
											out.println("<input type='radio' name=Response1 value=4 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response1 value=4 required>");
										}
									%>
									<br>
									完璧な記述
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response1 value=3 required>");
										} else if ((responseDataList.get(0) == 3)) {
											out.println("<input type='radio' name=Response1 value=3 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response1 value=3 required>");
										}
									%>
									<br>
									記述はあるが改善の余地あり
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response1 value=2 required>");
										} else if ((responseDataList.get(0) == 2)) {
											out.println("<input type='radio' name=Response1 value=2 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response1 value=2 required>");
										}
									%>
									<br>
									記述が不十分
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response1 value=1 required>");
										} else if ((responseDataList.get(0) == 1)) {
											out.println("<input type='radio' name=Response1 value=1 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response1 value=1 required>");
										}
									%>
									<br>
									記述がない
									<br>
								</div>
							</td>
						</tr>

						<tr>
							<td>上記で提案した授業における声掛けの具体例と、そのように考える理由</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response2 value=4 required>");
										} else if ((responseDataList.get(1) == 4)) {
											out.println("<input type='radio' name=Response2 value=4 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response2 value=4 required>");
										}
									%>
									<br>
									完璧な記述
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response2 value=3 required>");
										} else if ((responseDataList.get(1) == 3)) {
											out.println("<input type='radio' name=Response2 value=3 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response2 value=3 required>");
										}
									%>
									<br>
									記述はあるが改善の余地あり
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response2 value=2 required>");
										} else if ((responseDataList.get(1) == 2)) {
											out.println("<input type='radio' name=Response2 value=2 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response2 value=2 required>");
										}
									%>
									<br>
									記述が不十分
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response2 value=1 required>");
										} else if ((responseDataList.get(1) == 1)) {
											out.println("<input type='radio' name=Response2 value=1 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response2 value=1 required>");
										}
									%>
									<br>
									記述がない
									<br>
								</div>
							</td>
						</tr>

						<tr>
							<td>ICTを活用して、家庭学習と授業を学びを結びつけるための工夫</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response3 value=4 required>");
										} else if ((responseDataList.get(2) == 4)) {
											out.println("<input type='radio' name=Response3 value=4 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response3 value=4 required>");
										}
									%>
									<br>
									完璧な記述
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response3 value=3 required>");
										} else if ((responseDataList.get(2) == 3)) {
											out.println("<input type='radio' name=Response3 value=3 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response3 value=3 required>");
										}
									%>
									<br>
									記述はあるが改善の余地あり
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response3 value=2 required>");
										} else if ((responseDataList.get(2) == 2)) {
											out.println("<input type='radio' name=Response3 value=2 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response3 value=2 required>");
										}
									%>
									<br>
									記述が不十分
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response3 value=1 required>");
										} else if ((responseDataList.get(2) == 1)) {
											out.println("<input type='radio' name=Response3 value=1 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response3 value=1 required>");
										}
									%>
									<br>
									記述がない
									<br>
								</div>
							</td>
						</tr>
						<tr>
							<td>「あなたがＣｈａｎｇｅ」したこと</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response4 value=4 required>");
										} else if ((responseDataList.get(3) == 4)) {
											out.println("<input type='radio' name=Response4 value=4 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response4 value=4 required>");
										}
									%>
									<br>
									完璧な記述
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response4 value=3 required>");
										} else if ((responseDataList.get(3) == 3)) {
											out.println("<input type='radio' name=Response4 value=3 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response4 value=3 required>");
										}
									%>
									<br>
									記述はあるが改善の余地あり
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response4 value=2 required>");
										} else if ((responseDataList.get(3) == 2)) {
											out.println("<input type='radio' name=Response4 value=2 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response4 value=2 required>");
										}
									%>
									<br>
									記述が不十分
									<br>
								</div>
							</td>
							<td>
								<br>
								<div style="text-align: center">
									<%
										if (responseDataList.size() == 0) {
											out.println("<input type='radio' name=Response4 value=1 required>");
										} else if ((responseDataList.get(3) == 1)) {
											out.println("<input type='radio' name=Response4 value=1 required checked>");
										} else if ((responseDataList.size() > 0)) {
											out.println("<input type='radio' name=Response4 value=1 required>");
										}
									%>
									<br>
									記述がない
									<br>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div align="right">
					<input type="hidden" name="rubricSize" value=4>
					<input type="submit" class="btn btn-warning" value="登録する">
				</div>
			</form>
			<!-- 相互評価を行うか選択させる。選択させる部分は、Linkにする -->
			<form action="SearchRubricStudentServlet" method="POST">
				<a href="SearchStudentForPeerStudentServlet" class="btn btn-primary">相互評価</a>
				<input type="hidden" name="lessonId" value=<%=lessonId%>>
				<input type="submit" class="btn btn-default" value="前の画面にもどる">
			</form>
		</div>
	</div>
</div>

</body>
</html>