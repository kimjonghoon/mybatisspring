package net.java_school.photo;

public class Photo {
	private int no;
	private String content;

	public Photo() {}

	public Photo(int no, String content) {
		this.no = no;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
