package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import utility.DriverAccessor;

public class SelectPeerAssessmentDAO extends DriverAccessor {

	public ArrayList<ArrayList<String>> selectPeerAssessment(String lesson_id, Connection connection) {

		try {
			String sql = "select do_id,done_id from peer_assessment where lesson_id ='" + lesson_id + "'order by do_id,done_id";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<ArrayList<String>> peerAssessmentList = new ArrayList<ArrayList<String>>();

			while(rs.next()){
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString("do_id"));
				list.add(rs.getString("done_id"));
				peerAssessmentList.add(list);
			}

			return peerAssessmentList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return null;

	}

	public ArrayList<ArrayList<Integer>> selectPeerAssessment2(String lesson_id, Connection connection) {

		try {
			String sql = "select do_id,done_id from peer_assessment where lesson_id ='" + lesson_id + "'order by do_id,done_id";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<ArrayList<Integer>> peerAssessmentList = new ArrayList<ArrayList<Integer>>();

			while(rs.next()){
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(rs.getInt("do_id"));
				list.add(rs.getInt("done_id"));
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