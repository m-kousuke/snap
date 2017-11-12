
package beans;

public class Teacher {

	private int id = 0;
	private String teacherId = null;
	private String password = null;
	private String teacherName = null;

	public Teacher(int id, String teacherId, String password, String teacherName) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.password = password;
		this.teacherName = teacherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}