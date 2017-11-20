
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Lesson;
import dao.LessonDAO;

public class SearchLessonTeacherServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		/*
		 * 授業をすべてDBから持ってくる
		 */
		LessonDAO lessonDAO = new LessonDAO();
		ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
		lessonList = lessonDAO.searchLesson();
		session.setAttribute("lessonList", lessonList);

		getServletContext().getRequestDispatcher("/Public/teacher/selectLesson.jsp").forward(request, response);
	}
}
