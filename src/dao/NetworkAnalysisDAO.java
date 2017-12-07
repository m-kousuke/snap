package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import beans.AnalysisData;
import utility.DriverAccessor;

public class NetworkAnalysisDAO extends DriverAccessor {

	public void registAnalysisDataDAO(int lessonId, ArrayList<Double> indegree, double indegreeMean,
			ArrayList<Double> outdegree, double outdegreeMean, ArrayList<Double> betweenness, double betweennessMean,
			ArrayList<Integer> membership) {

		Connection connection = null;
		connection = (Connection) createConnection();

		try {
			// System.out.println(indegree);
			String sql = "insert into analysis_data(lesson_id,student_id,indegree,indegree_mean,outdegree,outdegree_mean,"
					+ "betweenness,betweenness_mean,membership) values(?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);
			for (int i = 1; i <= indegree.size(); i++) {
				stmt.setInt(1, lessonId);
				stmt.setInt(2, i);
				stmt.setDouble(3, indegree.get(i - 1));
				stmt.setDouble(4, indegreeMean);
				stmt.setDouble(5, outdegree.get(i - 1));
				stmt.setDouble(6, outdegreeMean);
				stmt.setDouble(7, betweenness.get(i - 1));
				stmt.setDouble(8, betweennessMean);
				stmt.setInt(9, membership.get(i - 1));
				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void communityDAO(ArrayList<ArrayList<Integer>> community, int lessonId) {

		Connection connection = null;
		connection = (Connection) createConnection();

		try {
			// System.out.println(betweenness);
			String sql = "insert into communities(lesson_id,community,student_id) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			for (int i = 0; i < community.size(); i++) {
				for (int j = 0; j < community.get(i).size(); j++) {
					stmt.setInt(1, 1);
					stmt.setInt(2, i + 1);
					stmt.setInt(3, community.get(i).get(j));
					stmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public ArrayList<AnalysisData> receiveAnalysisDataDAO(int lessonId) {

		Connection con = null;
		con = (Connection) createConnection();

		try {
			String sql = "select * from analysis_data where lesson_id = '" + lessonId + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<AnalysisData> analysisDataList = new ArrayList<AnalysisData>();

			while (rs.next()) {
				AnalysisData analysisData = new AnalysisData(rs.getInt("id"), rs.getInt("lesson_id"),
						rs.getInt("student_id"), rs.getDouble("indegree"), rs.getDouble("indegree_mean"),
						rs.getDouble("outdegree"), rs.getDouble("outdegree_mean"), rs.getDouble("betweenness"),
						rs.getDouble("betweenness_mean"), rs.getInt("membership"));

				analysisDataList.add(analysisData);
			}

			stmt.close();
			rs.close();
			closeConnection(con);

			return analysisDataList;
		} catch (

		SQLException e)

		{
			e.printStackTrace();
			return null;
		} finally

		{
		}
	}

}