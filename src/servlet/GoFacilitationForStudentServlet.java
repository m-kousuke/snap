package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AnalysisData;
import beans.Message;
import beans.Student;
import control.MessageManager;
import dao.AssessmentDAO;
import dao.MessageDAO;
import dao.NetworkAnalysisDAO;
import dao.StudentDAO;
import rJava.NetworkAnalysis;

public class GoFacilitationForStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		int lessonId = (int) session.getAttribute("lessonId");

		// 二次元リストで相互評価の結果を受け取る
		AssessmentDAO assessmentDAO = new AssessmentDAO();
		List<ArrayList<String>> peerAssessmentList = assessmentDAO.responseDataForNetworkAnalysis(lessonId);

		// Rに相互評価の結果を送る
		NetworkAnalysis na = new NetworkAnalysis();
		ArrayList<Double> indegree = na.indegree(peerAssessmentList);
		ArrayList<Double> outdegree = na.outdegree(peerAssessmentList);
		ArrayList<Double> betweenness = na.betweenness(peerAssessmentList);
		ArrayList<ArrayList<Integer>> community = na.community(peerAssessmentList);
		double indegreeMean = na.indegreeMean(peerAssessmentList);
		double outdegreeMean = na.outdegreeMean(peerAssessmentList);
		double betweennessMean = na.betweennessMean(peerAssessmentList);
		ArrayList<Integer> membership = na.menbership(peerAssessmentList);

		// studentListをDBから持ってくる
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> studentList = studentDAO.searchStudent();

		// 社会ネットワーク分析の結果を登録

		NetworkAnalysisDAO networkAnalysisDAO = new NetworkAnalysisDAO();
		networkAnalysisDAO.registAnalysisDataDAO(lessonId, indegree, indegreeMean, outdegree, outdegreeMean,
				betweenness, betweennessMean, membership);
		networkAnalysisDAO.communityDAO(community, lessonId);

		// DBからネットワーク分析の結果を持ってくる
		ArrayList<AnalysisData> analysisDataList = networkAnalysisDAO.receiveAnalysisDataDAO(lessonId);

		// 社会ネットワーク分析の結果からメッセージの特定
		MessageManager messageManager = new MessageManager();
		ArrayList<Message> messageList = messageManager.decideMessageManager(analysisDataList, studentList,lessonId);

		// メッセージの登録
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.registMessageDAO(messageList);


		response.sendRedirect(response.encodeRedirectURL("/snap/Public/teacher/facilitationSuccess.jsp"));
	}

}
