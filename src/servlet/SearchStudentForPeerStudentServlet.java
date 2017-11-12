
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LearningFile;
import beans.Student;
import dao.AssessmentDAO;
import dao.LearningFileDAO;
import dao.StudentDAO;

public class SearchStudentForPeerStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		String studentId = (String) session.getAttribute("studentId");
		int lessonId = (int) session.getAttribute("lessonId");

		/*
		 * 学習者をすべてDBから持ってくる
		 */
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = studentDAO.searchStudentForPeer(studentId);
		request.setAttribute("studentList", studentList);

		/*
		 * studentIdとlessonIdで学習記録データをDBあら引っ張ってくる
		 */
		LearningFileDAO fileDAO = new LearningFileDAO();
		ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
		fileList = fileDAO.searchFileForRubric(studentId, lessonId);
		request.setAttribute("fileList", fileList);

		/*
		 * 自分が誰から相互評価を受けているかDBから確認する
		 */
		AssessmentDAO assessmentDAO = new AssessmentDAO();
		ArrayList<Student> studentPeerList = new ArrayList<Student>();
		studentPeerList = assessmentDAO.searchStudentByPeerAssessment(studentId, lessonId);
		request.setAttribute("studentPeerList", studentPeerList);

		getServletContext().getRequestDispatcher("/Public/student/selectStudentForPeer.jsp").forward(request, response);
	}
}
