package beans;

public class Lesson {

	private int id = 0;
	private String subject = null;
	private String title = null;
	private String date = null;

	public Lesson(int id, String subject, String title, String date) {
		super();
		this.id = id;
		this.subject = subject;
		this.title = title;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}