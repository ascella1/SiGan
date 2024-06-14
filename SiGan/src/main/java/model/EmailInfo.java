package model;

public class EmailInfo {
	
	private int postId;
	private String recipient;
    private String subject;
    private String text;
    private String targetTime;

    public EmailInfo(String recipient, String subject, String text, String targetTime) {
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
        this.targetTime = targetTime;
    }
    
   
    public int getPostId() {
		return postId;
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
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTargetTime(String targetTime) {
		this.targetTime = targetTime;
	}
	
	
}
