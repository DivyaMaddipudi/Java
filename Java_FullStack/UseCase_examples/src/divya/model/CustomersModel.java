package divya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

import divya.entity.Customers;

public class CustomersModel {

	
	public boolean addCustomer(DataSource dataSource, Customers newCustomer) {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			String username = newCustomer.getUsername();
			String password = newCustomer.getPassword();
			String email = newCustomer.getEmail();
			
			String query = "insert into customers (username, password, email) values (?, ?, ?)";
			mySt = conn.prepareStatement(query);
			mySt.setString(1, username);
			mySt.setString(2, password);
			mySt.setString(3, email);			
			return mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

		
	}

	public HashMap<String, String> listCustomers(DataSource dataSource) {
		
		HashMap<String, String> userMap = new HashMap<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect = dataSource.getConnection();

			String query = "select username, password from customers";
			stmt = connect.createStatement();

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				userMap.put(rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userMap;
	}

}
