package divya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
				listUsers.add(new Transactions(rs.getInt("tranc_amt"), rs.getString("tranc_type"), rs.getTimestamp("tranc_date")));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listUsers;

	}

	public boolean addTransaction(DataSource dataSource, Transactions newTransaction) {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			int tranc_amt = newTransaction.getTransc_amt();
			String tranc_type = newTransaction.getTransc_type();
			


			String query = "insert into customers (tranc_amt, tranc_type, tranc_date) values (?, ?, CURRENT_TIMESTAMP)";
			mySt = conn.prepareStatement(query);
			mySt.setInt(1, tranc_amt);
			mySt.setString(2, tranc_type);		
			return mySt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		
	}
}

