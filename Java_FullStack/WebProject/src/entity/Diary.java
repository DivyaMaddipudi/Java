package entity;

import java.sql.Date;

public class Diary {
	
	private int diary_id;
	private int users_id;
	private Date date;
	private String content;
	
	public Diary(int diary_id, Date date, String content) {
		super();
		this.diary_id = diary_id;
		this.date = date;
		this.content = content;
	}
	
	public Diary(String content) {
		super();
		this.content = content;
	}

	public Diary(Date date, String content) {
		this.date = (Date) date;
		this.content = content;
	}
	

	public Diary(int users_id, String content) {
		super();
		this.users_id = users_id;
		this.content = content;
	}

	public Diary(int diary_id, int users_id, Date date, String content) {
		super();
		this.diary_id = diary_id;
		this.users_id = users_id;
		this.date = date;
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

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	
	
}
