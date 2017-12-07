package beans;

public class Message {

	private int id = 0;
	private int lessonId = 0;
	private int studentId = 0;
	private int messageId = 0;
	private int membership = 0;
	private int rock = 0;

	public Message(int id, int lessonId, int studentId, int messageId, int membership, int rock) {
		this.id = id;
		this.lessonId = lessonId;
		this.studentId = studentId;
		this.messageId = messageId;
		this.membership = membership;
		this.rock = rock;
	}

	public Message() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getMembership() {
		return membership;
	}

	public void setMembership(int membership) {
		this.membership = membership;
	}

	public int getRock() {
		return rock;
	}

	public void setRock(int rock) {
		this.rock = rock;
	}

}