package org.divya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.divya.entity.User;

public class UsersModel {
	
	public List<User> listUsers(DataSource dataSource) {
		ArrayList<User> listUser = new ArrayList<>();
		
		Connection conn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from users";
			myStmt = conn.createStatement();
			
			myRs = myStmt.executeQuery(query);
			
			while(myRs.next()) {
				listUser.add(new User(myRs.getInt("users_id"), myRs.getString("username"), myRs.getString("email")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listUser;
	}

	public void addUser(DataSource dataSource, User newUser) {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			String username = newUser.getUsername();
			String email = newUser.getEmail();
			String query = "insert into users (username, email) values (?, ?)";
			mySt = conn.prepareStatement(query);
			mySt.setString(1, username);
			mySt.setString(2, email);
			mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void updateUser(DataSource dataSource, User updatedUser) {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			int usersId = updatedUser.getUsers_id();
			String username = updatedUser.getUsername();
			String email = updatedUser.getEmail();
			String query = "update users set username = ?, email =? where users_id = ?";
			mySt = conn.prepareStatement(query);
			mySt.setString(1, username);
			mySt.setString(2, email);
			mySt.setInt(3, usersId);
			mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void deleteUser(DataSource dataSource, int UsersId) {
		
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			
			String query = "delete from users where users_id = ?";
			mySt = conn.prepareStatement(query);
		
			mySt.setInt(1, UsersId);
			mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
