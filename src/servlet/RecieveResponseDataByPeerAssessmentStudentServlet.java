package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LearningFile;
import dao.AssessmentDAO;
import dao.LearningFileDAO;
import dao.StudentDAO;

public class RecieveResponseDataByPeerAssessmentStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int rubricSize = Integer.parseInt(request.getParameter("rubricSize"));
		ArrayList<Integer> responseDataList = new ArrayList<Integer>();
		for (int i = 1; i <= rubricSize; i++) {
			responseDataList.add(Integer.parseInt(request.getParameter("Response" + i)));
		}

		HttpSession session = request.getSession(false);
		String studentId = (String) session.getAttribute("studentId");
		String subjectStudentId = (String) session.getAttribute("subjectStudentId");
		int lessonId = (int) session.getAttribute("lessonId");

		/*
		 * subjectStudentIdとlessonIdで学習記録データをDBから引っ張ってくる
		 */
		LearningFileDAO fileDAO = new LearningFileDAO();
		ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
		fileList = fileDAO.searchFileForRubric(subjectStudentId, lessonId);
		request.setAttribute("fileList", fileList);

		//studentIdとsubjectStudentIdの通し番号を取得
		StudentDAO studentDAO = new StudentDAO();
		int accountId = studentDAO.receiveAccountId(studentId);
		int subjectAccountId = studentDAO.receiveSubjectAccountId(subjectStudentId);




		/*
		 * subjectStudentIdとstudentIdとlessonIdで相互評価の記録をDBに登録
		 */
		AssessmentDAO assessmentDAO = new AssessmentDAO();
		assessmentDAO.registResponseDataByPeerAssessment(studentId, subjectStudentId, responseDataList, lessonId);

		/*
		 * accountIdとsubjectAcountIdでネットワーク分析のためのデータを登録
		 */
		assessmentDAO.registDataForAnalysis(accountId, subjectAccountId, lessonId);

		/*
		 * subjectStudentIdとstudentIdとlessonIdで相互評価の結果をDBから引っ張ってくる
		 */
		responseDataList = assessmentDAO.searchResponseDataByPeerAssessment(studentId, subjectStudentId, lessonId);
		request.setAttribute("responseDataList", responseDataList);

		getServletContext().getRequestDispatcher("/Public/student/rubric" + lessonId + "Peer.jsp").forward(request,
				response);
	}
}
