
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Student;
import utility.DriverAccessor;

public class StudentDAO extends DriverAccessor {

	// ユーザIDからパスワードを返す
	public Student loginStudent(String studentId, String password) {

		Connection con = null;
		con = createConnection();

		try {
			String sql = "select * from students where student_id ='" + studentId + "' AND password ='" + password
					+ "'";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();

			Student student = new Student(rs.getInt("id"), rs.getString("student_id"), rs.getString("password"),
					rs.getString("student_name"));

			stmt.close();
			rs.close();
			closeConnection(con);

			return student;

		} catch (

		SQLException e)

		{
			e.printStackTrace();
			return null;
		} finally

		{
		}
	}

	public ArrayList<Student> searchStudent() {

		Connection con = null;
		con = createConnection();

		try {
			String sql = "select * from students;";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Student> studentList = new ArrayList<Student>();
			while (rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("student_id"), rs.getString("password"),
						rs.getString("student_name"));
				studentList.add(student);
			}

			stmt.close();
			rs.close();
			closeConnection(con);

			return studentList;

		} catch (

		SQLException e)

		{
			e.printStackTrace();
			return null;
		} finally

		{
		}
	}

	public ArrayList<Student> searchStudentForPeer(String studentId) {

		Connection con = null;
		con = createConnection();

		try {
			String sql = "select * from students where student_id !='" + studentId + "'";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Student> studentList = new ArrayList<Student>();
			while (rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("student_id"), rs.getString("password"),
						rs.getString("student_name"));
				studentList.add(student);
			}

			stmt.close();
			rs.close();
			closeConnection(con);

			return studentList;

		} catch (

		SQLException e)

		{
			e.printStackTrace();
			return null;
		} finally

		{
		}
	}

	public String searchStudentName(String studentId) {

		Connection con = null;
		con = createConnection();

		try {
			String sql = "select student_name from students where student_id = '" + studentId + "'";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			String studentName = rs.getString("student_name");

			stmt.close();
			rs.close();
			closeConnection(con);

			return studentName;

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
