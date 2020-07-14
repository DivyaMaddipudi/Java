package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.LoginUsers;

public class LoginUsersModel {
	
	public boolean addUser(DataSource dataSource, LoginUsers newUser) {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			String name = newUser.getName();
			String email = newUser.getEmail();
			String password = newUser.getPassword();
			String query = "insert into loginusers (name, email, password) values (?, ?, ?)";
			mySt = conn.prepareStatement(query);
			mySt.setString(1, name);
			mySt.setString(2, email);
			mySt.setString(3, password);
			return mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getUserDetails(DataSource dataSource, String email, String password) {

		Connection conn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String dbEmail;
		String dbPassword;
		boolean isUser = false;
		
		try {
			conn = dataSource.getConnection();
			 
			String query = "select email, password from loginusers";
			
			myStmt = conn.createStatement();
			
			myRs = myStmt.executeQuery(query);

			if(myRs.next()) {
				dbEmail = myRs.getString("email");
				dbPassword = myRs.getString("password");
				if(email.equals(dbEmail) && password.equals(dbPassword)) {
					isUser = true;
				} else {
					isUser = false;
				}	
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUser;
	}
}
