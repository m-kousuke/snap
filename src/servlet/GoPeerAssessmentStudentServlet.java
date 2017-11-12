
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

public class GoPeerAssessmentStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String subjectStudentId = request.getParameter("subjectStudentId");

		HttpSession session = request.getSession(true);
		String studentId = (String) session.getAttribute("studentId");
		int lessonId = (int) session.getAttribute("lessonId");
		session.setAttribute("subjectStudentId", subjectStudentId);

		StudentDAO studentDAO = new StudentDAO();
		String subjectStudentName = studentDAO.searchStudentName(subjectStudentId);
		session.setAttribute("subjectStudentName", subjectStudentName);

		/*
		 * subjectStudentIdとlessonIdで学習記録データをDBから引っ張ってくる
		 */
		LearningFileDAO fileDAO = new LearningFileDAO();
		ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
		fileList = fileDAO.searchFileForRubric(subjectStudentId, lessonId);
		request.setAttribute("fileList", fileList);

		/*
		 * subjectStudentIdとstudentIdとlessonIdで相互評価の結果をDBから引っ張ってくる
		 */
		AssessmentDAO assessmentDAO = new AssessmentDAO();
		ArrayList<Integer> responseDataList = new ArrayList<Integer>();
		responseDataList = assessmentDAO.searchResponseDataByPeerAssessment(studentId, subjectStudentId, lessonId);
		request.setAttribute("responseDataList", responseDataList);

		getServletContext().getRequestDispatcher("/Public/student/rubric" + lessonId + "Peer.jsp").forward(request,
				response);
	}
}
