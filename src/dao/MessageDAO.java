package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Message;
import beans.MessageText;
import utility.DriverAccessor;

public class MessageDAO extends DriverAccessor {

	public void registMessageDAO(ArrayList<Message> messageList) {

		Connection con = null;
		con = createConnection();

		try {
			String sql = "insert into messages (lesson_id,student_id,message_id,membership,rock) values (?,?,?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			for (int i = 0; i < messageList.size(); i++) {
				stmt.setInt(1, messageList.get(i).getLessonId());
				stmt.setInt(2, messageList.get(i).getStudentId());
				stmt.setInt(3, messageList.get(i).getMessageId());
				stmt.setInt(4, messageList.get(i).getMembership());
				stmt.setInt(5, messageList.get(i).getRock());
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
		}
	}

	public ArrayList<Message> searchMessageDAO(String studentId) {

		Connection con = null;
		con = createConnection();
		try {
			String sql = "select * from messages where student_id ='" + studentId + "'and rock = 0 ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Message> messageList = new ArrayList<Message>();

			while (rs.next()) {
				Message message = new Message(rs.getInt("id"), rs.getInt("lesson_id"), rs.getInt("student_id"),
						rs.getInt("message_id"), rs.getInt("membership"), rs.getInt("rock"));
				messageList.add(message);
			}
			stmt.close();
			rs.close();
			closeConnection(con);
			return messageList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public ArrayList<MessageText> receiveMessageText(ArrayList<Message> messageList) {
		// TODO 自動生成されたメソッド・スタブ

		Connection con = null;
		con = createConnection();

		try {
			String sql = "select * from messages_text";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<MessageText> messageTextList = new ArrayList<MessageText>();

			while (rs.next()) {
				MessageText messageText = new MessageText(rs.getInt("id"), rs.getString("message"));
				messageTextList.add(messageText);
			}
			return messageTextList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}

	}
}