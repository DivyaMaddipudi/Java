package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import entity.Diary;
import entity.LoginUsers;

public class DiaryModel {
	

	public boolean addDiaryContent(DataSource dataSource, Diary newDiaryContent) {
		
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			
			
			Date date = newDiaryContent.getDate();
			String content = newDiaryContent.getContent();
			String query = "insert into diary (date, content) values (?, ?)";
			

			mySt = conn.prepareStatement(query);
			mySt.setDate(1, date);
			mySt.setString(2, content);
			
			return mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	
	}
}
