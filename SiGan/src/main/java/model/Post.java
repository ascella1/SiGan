package model;

public class Post {
	private String recipient;
	private String subject;
	private String text;
	private String targetTime;
	
	public Post(String recipient, String subject, String text, String targetTime) {
		this.recipient = recipient;
		this.subject = subject;
		this.text = text;
		this.targetTime = targetTime;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getSubject() {
		return subject;
	}

	public String getText() {
		return text;
	}

	public String getTargetTime() {
		return targetTime;
	}
}
