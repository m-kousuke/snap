package utility;

import java.io.File;
import java.util.ArrayList;

import beans.Student;
import dao.StudentDAO;

public class mkdir {

	public static void main(String args[]) {
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = studentDAO.searchStudent();
		String path = "/Applications/Eclipse_4.6.3.app/Contents/workspace/snap/WebContent/Public/LearningFile/";
		/*
		 * OSによってpathは変化する(下のpathはCentOSの場合)
		 * String path = "usr/share/tomcat/webapps/snap/Public/LearningFile/";
		 */

		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 1; j <= 4; j++) {
				File newDir = new File(path + studentList.get(i).getStudentId() + "/" + j);
				newDir.mkdirs();
			}
		}
	}
}