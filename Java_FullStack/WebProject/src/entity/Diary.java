package entity;

import java.sql.Date;

public class Diary {
	
	private int diary_id;
	private Date date;
	private String content;
	
	public Diary(int diary_id, Date date, String content) {
		super();
		this.diary_id = diary_id;
		this.date = date;
		this.content = content;
	}

	public Diary(java.util.Date date, String content) {
		this.date = (Date) date;
		this.content = content;
	}

	public int getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
