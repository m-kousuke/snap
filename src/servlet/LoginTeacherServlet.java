package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Teacher;
import control.LoginManager;
import dao.TeacherDAO;

public class LoginTeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String teacherId = request.getParameter("teacherId");
		String password = request.getParameter("password");

		/*
		 * DBから受け取る
		 */
		TeacherDAO loginDAO = new TeacherDAO();
		Teacher teacher = loginDAO.loginTeacher(teacherId);
		LoginManager checkLoginManager = new LoginManager();
		int checkId = checkLoginManager.checkTeacher(teacher, teacherId, password);

		if (checkId == 0) {
			getServletContext().getRequestDispatcher("/Public/teacher/loginError.jsp").forward(request, response);
		} else if (checkId == 1) {

			HttpSession session = request.getSession(true);
			session.setAttribute("teacherId", teacher.getTeacherId());
			session.setAttribute("password", teacher.getPassword());
			session.setAttribute("teacherName", teacher.getTeacherName());

			getServletContext().getRequestDispatcher("/Public/teacher/topPage.jsp").forward(request, response);
		}
	}
}