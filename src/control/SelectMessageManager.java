package control;

import java.util.ArrayList;

import beans.Message;
import beans.MessageText;

public class SelectMessageManager {

	public ArrayList<String> selectMessageList(ArrayList<Message> messageList, ArrayList<MessageText> messageTextList) {

		ArrayList<String> selectMessageList = new ArrayList<String>();
		for (int i = 0; i < messageList.size(); i++) {
			for (int j = 0; j < messageTextList.size(); j++) {
				if (messageList.get(i).getMessageId() == messageTextList.get(j).getId()) {
					String message = new String("lesson" + messageList.get(i).getLessonId() + "において"
							+ messageTextList.get(j).getMessage() + "");
					selectMessageList.add(message);
				}
			}
		}
		return selectMessageList;
	}
}