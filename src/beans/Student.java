
package beans;

public class Student {

	private int id = 0;
	private String password = null;
	private String studentName = null;

	public Student(int id, String password, String studentName) {
		super();
		this.id = id;
		this.password = password;
		this.studentName = studentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}