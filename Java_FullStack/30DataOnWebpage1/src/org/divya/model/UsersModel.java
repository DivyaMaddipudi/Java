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
	public List<User> listUser(DataSource dataSource) {
		List<User> listUser = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect = dataSource.getConnection();

			//2. create sql query
			String query = "select * from users";
			stmt = connect.createStatement();

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				listUser.add(new User(rs.getInt("users_id"), rs.getString("username"), rs.getString("email")));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listUser;

	}

}

