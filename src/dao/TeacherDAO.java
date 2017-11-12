package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Teacher;
import utility.DriverAccessor;

public class TeacherDAO extends DriverAccessor {

	// ユーザIDからパスワードを返す
	public Teacher loginTeacher(String teacherId) {

		Connection con = null;
		con = createConnection();

		try {
			String sql = "select * from teachers where teacher_id = '" + teacherId + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();

			Teacher teacher = new Teacher(rs.getInt("id"), rs.getString("teacher_id"), rs.getString("password"),
					rs.getString("teacher_name"));

			stmt.close();
			rs.close();
			closeConnection(con);

			return teacher;

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