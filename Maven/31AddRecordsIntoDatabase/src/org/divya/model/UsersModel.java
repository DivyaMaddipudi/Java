package org.divya.model;

import java.sql.Connection;
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

	public void addUser(User newUser) {
		
		
	}


}
