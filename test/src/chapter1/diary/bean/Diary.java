package chapter1.diary.bean;

import java.util.GregorianCalendar;

public class Diary {
	private GregorianCalendar time;
	private String title;
	private String content;
	private String authorName;

	public Diary(String authorName, String content, GregorianCalendar time, String title) {
		super();
		this.time = time;
		this.title = title;
		this.content = content;
		this.authorName = authorName;
	}

	public Diary() {
		super();
	}

	public GregorianCalendar getTime() {
		return time;
	}

	public void setTime(GregorianCalendar time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
