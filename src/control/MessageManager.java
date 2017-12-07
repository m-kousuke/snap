package control;

import java.util.ArrayList;

import beans.AnalysisData;
import beans.Message;
import beans.Student;

public class MessageManager {

	public ArrayList<Message> decideMessageManager(ArrayList<AnalysisData> analysisDataList,
			ArrayList<Student> studentList, int lessonId) {

		ArrayList<Message> messageList = new ArrayList<Message>();
		for (int i = 0; i < studentList.size(); i++) {
			if (i < analysisDataList.size()) {
				int x = 0;
				if (analysisDataList.get(i).getIndegree() == 0 && analysisDataList.get(i).getOutdegree() == 0) {
					x = 1;
				} else if (analysisDataList.get(i).getOutdegree() < analysisDataList.get(i).getOutdegreeMean() / 2) {
					x = 2;
				} else if (analysisDataList.get(i).getBetweenness() < analysisDataList.get(i).getBetweennessMean()
						/ 2) {
					x = 3;
				}
				Message message = new Message(0, analysisDataList.get(i).getLessonId(),
						analysisDataList.get(i).getStudentId(), x, analysisDataList.get(i).getMembership(), 0);
				messageList.add(message);
			} else {
				Message message = new Message(0, lessonId, studentList.get(i).getId(), 1,0, 0);
				messageList.add(message);
			}

		}
		return messageList;
	}

}