package corona_threat;

import java.sql.*;

public class TotalPatients {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dburl = "jdbc:mysql://localhost:3306/virus";
		String user = "student";
		String pass = "student";

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dburl, user, pass);

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.createStatement();

			// 3. Execute SQL query

			/*
			 * Insert into database
			 * 
			 * int rowsAffected = myStmt.executeUpdate("insert into corona " +
			 * "(state, city, male, female) " + "values" +
			 * "('Tamilnadu', 'Chennai', 15, 20)");
			 * 
			 * int rowsAffected = myStmt.executeUpdate("insert into corona " +
			 * "(state, city, male, female) " + "values" +
			 * "('Tamilnadu', 'Coimbatore', 25, 10)");
			 * 
			 * int rowsAffected = myStmt.executeUpdate("insert into corona " +
			 * "(state, city, male, female) " + "values" + "('Kerala', 'Wayanad', 15, 15)");
			 * 
			 */

			myRs = myStmt.executeQuery("SELECT  state, SUM(male + female) TotalNum	FROM    corona  GROUP   BY state");

			StateWiseTotal(myConn, "state");
			TotalPeopleEffected(myConn, "state");

			System.out.println("\nTotal number of infected people in a state: \n");

			System.out.println("State\t\t" + "Total People\t");

			// 4. Result

			while (myRs.next()) {
				String joinedStates = myRs.getString("state");
				String totalPeople = myRs.getString("TotalNum");

				System.out.printf("%-20s %-20s\n", joinedStates, totalPeople);
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}
	}

	private static void TotalPeopleEffected(Connection myConn, String string) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		System.out.println("\nTotal number of people infected all over the states: \n");

		try {
			// Prepare statement
			myStmt = myConn.prepareStatement("SELECT SUM(male+female) TotalPeople FROM corona");

			// Execute SQL query
			myRs = myStmt.executeQuery();

			System.out.println("Total People Infected: \t");

			// Process result set
			while (myRs.next()) {
				String sum = myRs.getString("TotalPeople");
				System.out.printf("%-20s \n", sum);

			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}
	}

	private static void StateWiseTotal(Connection myConn, String state) throws SQLException {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		System.out.println("\nTotal number of males and females infected in a state: \n");

		try {
			// Prepare statement
			myStmt = myConn.prepareStatement("SELECT  state, SUM(male), SUM(female) FROM    corona GROUP   BY state");

			// Execute SQL query
			myRs = myStmt.executeQuery();

			System.out.println("State\t\t" + "Total Males\t" + "Total Females");

			// Process result set
			while (myRs.next()) {
				String states = myRs.getString("state");
				String totalMale = myRs.getString("SUM(male)");
				String totalFemale = myRs.getString("SUM(female)");

				System.out.printf("%-20s %-20s %-20s\n", states, totalMale, totalFemale);

			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs) throws SQLException {

		close(null, myStmt, myRs);
	}
}
