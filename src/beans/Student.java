
package beans;

public class Student {

	private int id = 0;
	private String studentId = null;
	private String password = null;
	private String studentName = null;

	public Student(int id, String studentId, String password, String studentName) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.password = password;
		this.studentName = studentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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