
package control;

import beans.Student;
import beans.Teacher;

public class LoginManager {

	// ログインが正常にできているかcheckする 上手くいってればcheckId=1,checkId=0
	public int checkStudent(Student student, String studentId, String password) {

		if (student == null) {
			int checkId = 0;
			return checkId;

		} else if (student.getStudentId().equals(studentId) && student.getPassword().equals(password)) {
			int checkId = 1;
			return checkId;

		} else if (!student.getStudentId().equals(studentId) || !student.getPassword().equals(password)) {
			int checkId = 0;
			return checkId;
		}
		return 0;
	}

	public int checkTeacher(Teacher teacher, String teacherId, String password) {

		if (teacher == null) {
			int checkId = 0;
			return checkId;

		} else if (teacher.getTeacherId().equals(teacherId) && teacher.getPassword().equals(password)) {
			int checkId = 1;
			return checkId;

		} else if (!teacher.getTeacherId().equals(teacherId) || !teacher.getPassword().equals(password)) {
			int checkId = 0;
			return checkId;
		}
		return 0;
	}
}
