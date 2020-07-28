package divya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import divya.entity.Transactions;

public class TransactionsModel {


	public List<Transactions> listTransactionsById(int customerId, DataSource dataSource) {

		//1. Initialize connection objects
		List<Transactions> listUsers = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect = dataSource.getConnection();
			int cus_id = customerId;
			//2. create sql query
			String query = "select tranc_amt, tranc_type, tranc_date  from transactions where cus_id =" + cus_id;
			stmt = connect.createStatement();

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				listUsers.add(new Transactions(rs.getInt("tranc_amt"), rs.getString("tranc_type"), rs.getDate("tranc_date")));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listUsers;

	}

	public boolean addTransaction(Transactions newTransaction, DataSource dataSource ) {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			
			//int cus_id = cusId;
			//System.out.println(cus_id);
			int cus_id = newTransaction.getCus_id();
			int tranc_amt = newTransaction.getTransc_amt();
			String tranc_type = newTransaction.getTransc_type();
			
			java.util.Date date=new java.util.Date();
			
			java.sql.Date tranc_date=new java.sql.Date(date.getTime());
			
			java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());

			
			System.out.println(sqlTime);
			System.out.println(tranc_date);
			
//			String selectId = "select cus_id from customers where username =" + username;
			
			
			String query = "insert into transactions (cus_id, tranc_amt, tranc_type, tranc_date) values (?, ?, ?, ?)";
			mySt = conn.prepareStatement(query);
			mySt.setInt(1, cus_id);
			mySt.setInt(2, tranc_amt);
			mySt.setString(3, tranc_type);
			mySt.setTimestamp(4, sqlTime);
			
			return mySt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		
	}
}

