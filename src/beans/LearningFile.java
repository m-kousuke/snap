
package beans;

public class LearningFile {

	private int id = 0;
	private String path = null;
	private int lessonId = 0;
	private String studentId = null;
	private String fileName = null;
	private String time = null;
	private int kind = 0;

	public LearningFile(int id, String path, int lessonId, String studentId, String fileName, String time, int kind) {
		super();
		this.id = id;
		this.path = path;
		this.lessonId = lessonId;
		this.studentId = studentId;
		this.fileName = fileName;
		this.time = time;
		this.kind = kind;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}
}