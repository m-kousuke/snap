package beans;

public class Message{

	private int id=0;
	private int lesson_id = 0;
	private String student_id =null;
	private int message = 0;
	private int membership = 0;
	private int rock = 0;

	public Message(int id,int lesson_id,String student_id,int message,int membership,int rock){
		this.id = id;
		this.lesson_id = lesson_id;
		this.student_id = student_id;
		this.message = message;
		this.membership = membership;
		this.rock = rock;
	}


	public Message(){
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getLesson_id() {
		return lesson_id;
	}


	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public int getMessage() {
		return message;
	}


	public void setMessage(int message) {
		this.message = message;
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