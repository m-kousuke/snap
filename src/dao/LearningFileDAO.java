package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import beans.LearningFile;
import utility.DriverAccessor;

public class LearningFileDAO extends DriverAccessor {
	public void uploadFile(String path, String studentId, int lessonId, String fileName, int kind) {
		Calendar c = Calendar.getInstance();
		// フォーマットパターンを指定して表示する
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm");

		Connection con = null;
		con = createConnection();

		try {
			/*
			 * 重複登録を避けるためのプログラム
			 */
			String searchSql = "select * from learning_files where student_id = '" + studentId + "' AND lesson_id ='"
					+ lessonId + " ' AND file_name ='" + fileName + "'";
			Statement checkStmt = con.createStatement();
			ResultSet rs = checkStmt.executeQuery(searchSql);
			ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
			while (rs.next()) {
				LearningFile file = new LearningFile(rs.getInt("id"), rs.getString("path"), rs.getInt("lesson_id"),
						rs.getString("student_id"), rs.getString("file_name"), rs.getString("time"), rs.getInt("kind"));
				fileList.add(file);
			}
			checkStmt.close();
			rs.close();

			if (fileList.size() == 0) {

				String sql = "insert into learning_files(id,path,lesson_id,student_id,file_name,time,kind) values(?, ?, ?, ?, ?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, 0);
				stmt.setString(2, path);
				stmt.setInt(3, lessonId);
				stmt.setString(4, studentId);
				stmt.setString(5, fileName);
				stmt.setString(6, sdf.format(c.getTime()));
				stmt.setInt(7, kind);
				stmt.executeUpdate();
				stmt.close();
			} else {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public ArrayList<LearningFile> searchFile(String studentId) {
		Connection con = null;
		con = createConnection();
		try {
			String sql = "select * from learning_files where student_id = '" + studentId + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
			while (rs.next()) {
				LearningFile file = new LearningFile(rs.getInt("id"), rs.getString("path"), rs.getInt("lesson_id"),
						rs.getString("student_id"), rs.getString("file_name"), rs.getString("time"), rs.getInt("kind"));
				fileList.add(file);
			}
			stmt.close();
			rs.close();
			return fileList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public ArrayList<LearningFile> searchFileForRubric(String studentId, int lessonId) {
		Connection con = null;
		con = createConnection();
		try {
			String sql = "select * from learning_files where student_id = '" + studentId + "' AND lesson_id ="
					+ lessonId;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
			while (rs.next()) {
				LearningFile file = new LearningFile(rs.getInt("id"), rs.getString("path"), rs.getInt("lesson_id"),
						rs.getString("student_id"), rs.getString("file_name"), rs.getString("time"), rs.getInt("kind"));
				fileList.add(file);
			}
			stmt.close();
			rs.close();
			return fileList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public ArrayList<LearningFile> searchFileInGraphForStudent(String studentId, int lessonId) {
		Connection con = null;
		con = createConnection();
		try {
			String sql = "select * from learning_files where student_id = '" + studentId + "' AND lesson_id ="
					+ lessonId;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
			while (rs.next()) {
				LearningFile file = new LearningFile(rs.getInt("id"), rs.getString("path"), rs.getInt("lesson_id"),
						rs.getString("student_id"), rs.getString("file_name"), rs.getString("time"), rs.getInt("kind"));
				fileList.add(file);
			}
			stmt.close();
			rs.close();
			return fileList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public void deleteFile(int fileId) {
		Connection con = null;
		con = createConnection();
		try {
			String sql = "delete from learning_files where id =" + fileId;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

}
