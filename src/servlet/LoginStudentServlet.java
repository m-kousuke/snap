package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Message;
import beans.MessageText;
import beans.Student;
import control.LoginManager;
import control.SelectMessageManager;
import dao.MessageDAO;
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
			MessageDAO messageDAO = new MessageDAO();
			ArrayList<Message> messageList = messageDAO.searchMessageDAO(studentId);
			System.out.println(messageList);
			ArrayList<MessageText> messageTextList = messageDAO.receiveMessageText(messageList);
			System.out.println(messageTextList);
			SelectMessageManager selectMessageManager = new SelectMessageManager();
			ArrayList<String> selectMessageList = selectMessageManager.selectMessageList(messageList, messageTextList);
			System.out.println(selectMessageList);
			request.setAttribute("selectMessageList", selectMessageList);
			getServletContext().getRequestDispatcher("/Public/student/topPage.jsp").forward(request, response);
		}
	}
}