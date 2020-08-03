package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import entity.Diary;
import entity.LoginUsers;

public class DiaryModel {
	

	public boolean addDiaryContent(DataSource dataSource, Diary newDiaryContent) {
		
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			
			
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
		    
		    int usersId = newDiaryContent.getUsers_id();
			String content = newDiaryContent.getContent();
			String query = "insert into diary (users_id, date, content) values (?, ?, ?)";
			

			mySt = conn.prepareStatement(query);
			mySt.setInt(1, usersId);
			mySt.setDate(2, date);
			mySt.setString(3, content);
			
			return mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	
	}

	public List<Diary> printHistory(DataSource dataSource, int userId) {
		List<Diary> diaryHistory = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect = dataSource.getConnection();

			String query = "select * from diary where users_id=" + userId;
			stmt = connect.createStatement();

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				diaryHistory.add(new Diary(rs.getInt("diary_id"), rs.getDate("date"), rs.getString("content")));
				System.out.println(rs.getInt("diary_id"));
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return diaryHistory;
	}

	public void deleteDiaryContent(int userId, DataSource dataSource) {
		Connection connect = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null;

		try {
			connect = dataSource.getConnection();

			String query = "delete from diary where users_id =" + userId;
			stmt = connect.prepareStatement(query);

			stmt.execute();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
}
