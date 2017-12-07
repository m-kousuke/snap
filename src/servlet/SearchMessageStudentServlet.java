package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Message;
import dao.MessageDAO;

public class SearchMessageStudentServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		String studentId = (String) session.getAttribute("studentId");

		MessageDAO messageDAO = new MessageDAO();
		ArrayList<Message> messageList = messageDAO.searchMessageDAO(studentId);



	}
}