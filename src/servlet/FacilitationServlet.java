package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ResponseData;
import control.NetworkAnalysisManager;
import rJava.NetworkAnalysis;

public class SelectPeerAssessmentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session2 = request.getSession();
		String lesson_id =(String) session2.getAttribute("lessonId");
		SelectPeerAssessmentDAO peerAssessmentDAO = new SelectPeerAssessmentDAO();

		// 二次元リストで相互評価の結果を受け取る
		List<ArrayList<String>> peerAssessmentList = peerAssessmentManager.selectPeerAssessment(lesson_id);

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

		// 社会ネットワーク分析の結果を登録

		NetworkAnalysisManager networkManager = new NetworkAnalysisManager();
		networkManager.indegreeManager(indegree, indegreeMean, lesson_id);
		/*
		 * networkManager.indegreeManager(indegree, indegreeMean, lesson_id);
		 * networkManager.outdegreeManager(outdegree, outdegreeMean, lesson_id);
		 * networkManager.betweenessManager(betweenness, betweennessMean,
		 * lesson_id); networkManager.membershipManager(membership, lesson_id);
		 * networkManager.communityManager(community, lesson_id);
		 *
		 */
		// ResponseDataオブジェクト生成
		ArrayList<ResponseData> responseData = networkManager.responseData(lesson_id);
		networkManager.messageManager(lesson_id);
		// ArrayList<ArrayList<Integer>> peerAssessmentList2 =
		// peerAssessmentManager.selectPeerAssessment2(lesson_id);

		/*for (int i = 0; i < responseData.size(); i++) {
			if (responseData.get(i).getIndegree() == 0 && responseData.get(i).getOutdegree() == 0) {
				System.out.println("入次数＝０　出次数＝０");
				System.out.println(responseData.get(i).getStudent_id());
				System.out.println("相互評価を行ってください");
			}else if (responseData.get(i).getOutdegree() < responseData.get(i).getOutdegree_mean()/2) {
				System.out.println("出次数<平均値/2");
				System.out.println(responseData.get(i).getStudent_id());
			}else if (responseData.get(i).getBetweenness() < responseData.get(i).getBetweenness_mean() / 2) {
				System.out.println("媒介中心性<平均値/2");
				System.out.println(responseData.get(i).getStudent_id());
				System.out.println("他のグループの人に相互評価を行ってください");
			}
		}
		*/


		 request.setAttribute("indegree", indegree);
		 request.setAttribute("outdegree", outdegree);
		 request.setAttribute("betweenness", betweenness);
		 request.setAttribute("community", community);
		 request.setAttribute("indegreeMean", indegreeMean);
		 request.setAttribute("outdegreeMean", outdegreeMean);
		 request.setAttribute("peerAssessmentList", peerAssessmentList);
		 request.setAttribute("membership", membership);
		 request.setAttribute("responseData", responseData);

		getServletContext().getRequestDispatcher("/teacher/message.jsp").forward(request, response);

	}

}
