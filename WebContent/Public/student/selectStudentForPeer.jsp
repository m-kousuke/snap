<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="beans.LearningFile"%>
<%@ page import="beans.Student"%>
<%@ page import="java.util.ArrayList"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<LearningFile> fileList = (ArrayList<LearningFile>) request.getAttribute("fileList");
	@SuppressWarnings("unchecked")
	ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
	@SuppressWarnings("unchecked")
	ArrayList<Student> studentPeerList = (ArrayList<Student>) request.getAttribute("studentPeerList");
	String studentId = (String) session.getAttribute("studentId");
	int lessonId = (Integer) session.getAttribute("lessonId");
%>

<!DOCTYPE html>
<html>
<head>
<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>学習者選択画面(相互評価)</title>
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
			<form action="GoPeerAssessmentStudentServlet" method="POST">
				<table class="table">
					<thead>
						<tr>
							<th>
								<font size="+1">誰に対して相互評価を行うか選択して下さい</font>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<%
									for (int i = 0; i < studentList.size(); i++) {
										out.println("<label>");
										out.println("<input type='radio' required name='subjectStudentId' value="
												+ studentList.get(i).getStudentId() + ">");
										out.println(studentList.get(i).getStudentName());
										out.println("</label>");
										out.println("&nbsp;&nbsp;&nbsp;");
									}
								%>
							</td>
						</tr>
					</tbody>
				</table>
				<div align="right">
					<input type="submit" class="btn btn-info" value="選択した学習者に対して相互評価を行う">
				</div>
				<br>
			</form>

			<%if(studentPeerList.size()!=0){ %>
			<form action="GoCheckPeerAssessmentStudentServlet" method="POST">
				<table class="table">
					<thead>
						<tr>
							<th>
								<font size="+1">自分が受けた相互評価を確認して下さい</font>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<%
									for (int i = 0; i < studentPeerList.size(); i++) {
										out.println("<label>");
										out.println("<input type='radio' required name='subjectStudentId' value="
												+ studentPeerList.get(i).getStudentId() + ">");
										out.println(studentPeerList.get(i).getStudentName());
										out.println("</label>");
										out.println("&nbsp;&nbsp;&nbsp;");
									}
								%>
							</td>
						</tr>
					</tbody>
				</table>
				<div align="right">
					<input type="submit" class="btn btn-info" value="確認する">
				</div>
				<br>
			</form>
			<%}else if(studentPeerList.size()==0){
				out.println("<br>");
			}
			%>

			<!-- 相互評価を行うか選択させる。選択させる部分は、Linkにする -->
			<form action="SearchRubricStudentServlet" method="POST">
				<a href="SearchRubricForSelfStudentServlet" class="btn btn-primary">自己評価</a>
				<input type="hidden" name="lessonId" value=<%=lessonId%>>
				<input type="submit" class="btn btn-default" value="前の画面にもどる">
			</form>
		</div>
	</div>
</div>

</body>
</html>