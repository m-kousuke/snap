package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LearningFile;
import dao.LearningFileDAO;

public class DeleteFileStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int fileId = Integer.parseInt(request.getParameter("fileId"));

		/*
		 * DBにアクセスして学習成果物を消去
		 */
		LearningFileDAO deleteDAO = new LearningFileDAO();
		deleteDAO.deleteFile(fileId);

		/*
		 * 本当はファイルごと消去したいけど、クエリをあんまり送りたくないので×
		 */

		HttpSession session = request.getSession(false);
		String studentId = (String) session.getAttribute("studentId");
		int lessonId = (int) session.getAttribute("lessonId");

		/*
		 * studentIdとlessonIdで学習記録データをDBあら引っ張ってくる
		 */
		LearningFileDAO fileDAO = new LearningFileDAO();
		ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
		fileList = fileDAO.searchFileForRubric(studentId, lessonId);
		request.setAttribute("fileList", fileList);

		getServletContext().getRequestDispatcher("/Public/student/rubric" + lessonId + ".jsp").forward(request,
				response);
	}
}