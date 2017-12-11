package beans;

public class MessageText {

	private int id = 0;
	private String message = null;

	public MessageText(int id, String message) {

		this.id = id;
		this.message = message;
	}

	public MessageText() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}