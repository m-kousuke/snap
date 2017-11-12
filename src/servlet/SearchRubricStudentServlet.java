package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LearningFile;
import beans.Lesson;
import dao.LearningFileDAO;
import dao.LessonDAO;

public class SearchRubricStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int lessonId = Integer.parseInt(request.getParameter("lessonId"));

		HttpSession session = request.getSession(false);
		String studentId = (String) session.getAttribute("studentId");

		/*
		 * lessonIdの値からどの授業を選んだか特定する
		 */
		Lesson lesson = new Lesson(lessonId, null, null, null);
		LessonDAO lessonDAO = new LessonDAO();
		lesson = lessonDAO.identifyLesson(lessonId);

		session.setAttribute("lessonId", lessonId);
		session.setAttribute("title", lesson.getTitle());
		session.setAttribute("subject", lesson.getSubject());
		session.setAttribute("date", lesson.getDate());

		/*
		 * studentIdとlessonIdで学習成果物をDBから引っ張ってくる
		 */
		LearningFileDAO fileDAO = new LearningFileDAO();
		ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
		fileList = fileDAO.searchFileForRubric(studentId, lessonId);
		request.setAttribute("fileList", fileList);

		getServletContext().getRequestDispatcher("/Public/student/rubric" + lessonId + ".jsp").forward(request,
				response);
	}

}
