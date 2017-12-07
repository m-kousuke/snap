
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Student;
import utility.DriverAccessor;

public class AssessmentDAO extends DriverAccessor {

	public void registResponseDataBySelfAssessment(String studentId, ArrayList<Integer> responseData, int lessonId) {

		Connection con = null;
		con = createConnection();

		try {
			/*
			 * 重複登録を避けるためのプログラム
			 */
			String searchSql = "select count(*) from response_data_self_assessment where student_id = '" + studentId
					+ "' AND lesson_id =" + lessonId;

			Statement checkStmt = con.createStatement();
			ResultSet rs = checkStmt.executeQuery(searchSql);
			rs.next();
			// rs.getInt(1)で行数の確認ができるのでその値をkに代入
			int k = rs.getInt(1);
			checkStmt.close();
			rs.close();

			if (k == 0) {

				String sql = "insert into response_data_self_assessment(id,student_id,response,lesson_id,line) values(?, ?, ?, ?, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);

				for (int i = 0; i < responseData.size(); i++) {
					stmt.setInt(1, 0);
					stmt.setString(2, studentId);
					stmt.setInt(3, responseData.get(i));
					stmt.setInt(4, lessonId);
					stmt.setInt(5, (i + 1));
					stmt.executeUpdate();
				}
				stmt.close();

			} else {
				String sql = "UPDATE response_data_self_assessment SET response = ? WHERE student_id = ? AND lesson_id=? AND line=?";

				PreparedStatement stmt = con.prepareStatement(sql);

				// sql文を何回も送るのは嫌
				for (int i = 0; i < responseData.size(); i++) {
					stmt.setInt(1, responseData.get(i));
					stmt.setString(2, studentId);
					stmt.setInt(3, lessonId);
					stmt.setInt(4, (i + 1));
					stmt.executeUpdate();
				}
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
		}
	}

	public void registResponseDataByPeerAssessment(String studentId, String subjectStudentId,
			ArrayList<Integer> responseData, int lessonId) {

		Connection con = null;
		con = createConnection();

		try {
			/*
			 * 重複登録を避けるためのプログラム
			 */
			String searchSql = "select count(*) from response_data_peer_assessment where student_id = '" + studentId
					+ "' AND subject_student_id='" + subjectStudentId + "' AND lesson_id =" + lessonId;

			Statement checkStmt = con.createStatement();
			ResultSet rs = checkStmt.executeQuery(searchSql);
			rs.next();
			// rs.getInt(1)で行数の確認ができるのでその値をkに代入
			int k = rs.getInt(1);
			checkStmt.close();
			rs.close();

			if (k == 0) {

				String sql = "insert into response_data_peer_assessment(id,student_id,subject_student_id,response,lesson_id,line) values(?,?, ?, ?, ?, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);

				for (int i = 0; i < responseData.size(); i++) {
					stmt.setInt(1, 0);
					stmt.setString(2, studentId);
					stmt.setString(3, subjectStudentId);
					stmt.setInt(4, responseData.get(i));
					stmt.setInt(5, lessonId);
					stmt.setInt(6, (i + 1));
					stmt.executeUpdate();
				}
				stmt.close();

			} else {
				String sql = "UPDATE response_data_peer_assessment SET response = ? WHERE student_id = ? AND subject_student_id = ? AND lesson_id=? AND line=?";

				PreparedStatement stmt = con.prepareStatement(sql);

				// sql文を何回も送るのは嫌
				for (int i = 0; i < responseData.size(); i++) {
					stmt.setInt(1, responseData.get(i));
					stmt.setString(2, studentId);
					stmt.setString(3, subjectStudentId);
					stmt.setInt(4, lessonId);
					stmt.setInt(5, (i + 1));
					stmt.executeUpdate();
				}
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
		}
	}

	public ArrayList<Integer> searchResponseDataBySelfAssessment(String studentId, int lessonId) {

		Connection con = null;
		con = createConnection();

		try {

			String sql = "select * from response_data_self_assessment where student_id = '" + studentId
					+ "'&& lesson_id = '" + lessonId + "'";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Integer> responseData = new ArrayList<Integer>();
			while (rs.next()) {
				responseData.add(rs.getInt("response"));
			}

			stmt.close();
			rs.close();
			closeConnection(con);

			return responseData;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
		}
		return null;
	}

	public ArrayList<Integer> searchResponseDataByPeerAssessment(String studentId, String subjectStudentId,
			int lessonId) {

		Connection con = null;
		con = createConnection();

		try {

			String sql = "select * from response_data_peer_assessment where student_id = '" + studentId
					+ "'&& subject_student_id='" + subjectStudentId + "'&& lesson_id = '" + lessonId + "'";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Integer> responseData = new ArrayList<Integer>();
			while (rs.next()) {
				responseData.add(rs.getInt("response"));
			}

			stmt.close();
			rs.close();
			closeConnection(con);

			return responseData;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
		}
		return null;
	}

	public ArrayList<ArrayList<String>> searchResponseDataBySelfAssessmentForCSV(int lessonId) {

		Connection con = null;
		con = createConnection();

		try {
			String checkSql = "select distinct student_id from response_data_self_assessment where lesson_id = '"
					+ lessonId + "'";
			Statement checkStmt = con.createStatement();
			ResultSet checkRs = checkStmt.executeQuery(checkSql);

			ArrayList<String> studentList = new ArrayList<String>();
			while (checkRs.next()) {
				studentList.add(checkRs.getString("student_id"));
			}
			checkStmt.close();
			checkRs.close();

			ArrayList<ArrayList<String>> responseDataList = new ArrayList<ArrayList<String>>();
			for (int i = 0; i < studentList.size(); i++) {
				ArrayList<String> responseData = new ArrayList<String>();
				String sql = "select response from response_data_self_assessment where student_id = '"
						+ studentList.get(i) + "'&& lesson_id = '" + lessonId + "'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				responseData.add(studentList.get(i));
				while (rs.next()) {
					responseData.add(String.valueOf(rs.getInt("response")));
				}
				responseDataList.add(responseData);
				stmt.close();
				rs.close();
			}

			closeConnection(con);
			return responseDataList;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
		}
		return null;
	}

	public ArrayList<Student> searchStudentBySelfAssessment(int lessonId) {

		Connection con = null;
		con = createConnection();

		try {

			String checkSql = "select distinct student_id from response_data_self_assessment where lesson_id = '"
					+ lessonId + "'";
			Statement checkStmt = con.createStatement();
			ResultSet checkRs = checkStmt.executeQuery(checkSql);

			ArrayList<String> studentIdList = new ArrayList<String>();
			while (checkRs.next()) {
				studentIdList.add(checkRs.getString("student_id"));
			}
			checkStmt.close();
			checkRs.close();

			/*
			 * 本当はあんまりよくないけど、一緒にした。。。
			 */
			ArrayList<Student> studentList = new ArrayList<Student>();
			for (int i = 0; i < studentIdList.size(); i++) {
				String sql = "select * from students where id = '" + studentIdList.get(i) + "'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				Student student = new Student(rs.getInt("id"), null, rs.getString("student_name"));
				studentList.add(student);
				stmt.close();
				rs.close();
			}

			closeConnection(con);
			return studentList;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
		}
		return null;
	}

	public ArrayList<Student> searchStudentByPeerAssessment(String subjectStudentId, int lessonId) {

		Connection con = null;
		con = createConnection();

		try {

			String checkSql = "select distinct student_id from response_data_peer_assessment where lesson_id = '"
					+ lessonId + "' AND subject_student_id = '" + subjectStudentId + "'";
			Statement checkStmt = con.createStatement();
			ResultSet checkRs = checkStmt.executeQuery(checkSql);

			ArrayList<String> studentIdList = new ArrayList<String>();
			while (checkRs.next()) {
				studentIdList.add(checkRs.getString("student_id"));
			}
			checkStmt.close();
			checkRs.close();

			/*
			 * 本当はあんまりよくないけど、一緒にした。。。
			 */
			ArrayList<Student> studentList = new ArrayList<Student>();
			for (int i = 0; i < studentIdList.size(); i++) {
				String sql = "select * from students where id = '" + studentIdList.get(i) + "'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				Student student = new Student(rs.getInt("id"), null, rs.getString("student_name"));
				studentList.add(student);
				stmt.close();
				rs.close();
			}

			closeConnection(con);
			return studentList;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
		}
		return null;
	}

	// ネットワーク分析のためのデータ
	public ArrayList<ArrayList<String>> responseDataForNetworkAnalysis(int lessonId) {


		Connection connection = null;
		connection = createConnection();



		try {
			String sql = "select distinct student_id,subject_student_id from response_data_peer_assessment where lesson_id ='"
					+ lessonId + "'" + "order by student_id,subject_student_id";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<ArrayList<String>> peerAssessmentList = new ArrayList<ArrayList<String>>();
			while (rs.next()) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString("student_id"));
				list.add(rs.getString("subject_student_id"));
				peerAssessmentList.add(list);
			}

			return peerAssessmentList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return null;

	}

}
