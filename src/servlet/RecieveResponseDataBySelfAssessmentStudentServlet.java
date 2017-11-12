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

public class RecieveResponseDataBySelfAssessmentStudentServlet extends HttpServlet {

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
		int lessonId = (int) session.getAttribute("lessonId");

		/*
		 * studentIdとlessonIdで学習成果物をDBから引っ張ってくる
		 */
		LearningFileDAO fileDAO = new LearningFileDAO();
		ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
		fileList = fileDAO.searchFileForRubric(studentId, lessonId);
		request.setAttribute("fileList", fileList);

		/*
		 * studentIdとlessonIdで自己評価の記録をDBに登録
		 */
		AssessmentDAO assessmentDAO = new AssessmentDAO();
		assessmentDAO.registResponseDataBySelfAssessment(studentId, responseDataList, lessonId);

		/*
		 * studentIdとlessonIdで自己評価の記録をDBから引っ張ってくる
		 */
		responseDataList = assessmentDAO.searchResponseDataBySelfAssessment(studentId, lessonId);
		request.setAttribute("responseDataList", responseDataList);

		getServletContext().getRequestDispatcher("/Public/student/rubric" + lessonId + "Self.jsp").forward(request,
				response);
	}
}
