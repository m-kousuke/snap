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
import control.SelectMessageManager;
import dao.MessageDAO;

public class SearchMessageStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		String studentId = (String) session.getAttribute("studentId");

		MessageDAO messageDAO = new MessageDAO();
		ArrayList<Message> messageList = messageDAO.searchMessageDAO(studentId);
		ArrayList<MessageText> messageTextList = messageDAO.receiveMessageText(messageList);

		SelectMessageManager selectMessageManager = new SelectMessageManager();
		ArrayList<String> selectMessageList = selectMessageManager.selectMessageList(messageList, messageTextList);

		request.setAttribute("selectMessageList", selectMessageList);

		getServletContext().getRequestDispatcher("/Public/student/topPage.jsp");
	}
}