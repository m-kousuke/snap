package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Student;
import control.LoginManager;
import dao.StudentDAO;

public class LoginStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String studentId = request.getParameter("studentId");
		String password = request.getParameter("password");

		/*
		 * DBから受け取る
		 */
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.loginStudent(studentId, password);

		/*
		 * controlでログイン情報が正しいか確認 judgeは正しいか、誤っているか
		 */
		LoginManager check = new LoginManager();
		int judge = check.checkStudent(student, studentId, password);

		if (judge == 0) {
			response.sendRedirect("/snap/Public/student/loginError.jsp");
		} else if (judge == 1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("studentId", studentId);
			session.setAttribute("studentName", student.getStudentName());
			session.setAttribute("password", password);
			getServletContext().getRequestDispatcher("/Public/student/topPage.jsp").forward(request, response);
		}
	}
}