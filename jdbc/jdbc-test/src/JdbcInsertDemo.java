import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertDemo {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dburl = "jdbc:mysql://localhost:3306/virus";
		String user = "student";
		String pass = "student";
		
		try {
			
			myConn = DriverManager.getConnection(dburl, user, pass);
			
			myStmt = myConn.createStatement();
			
		// Inserting a row into db
			
		 int rowsAffected = myStmt.executeUpdate("insert into details " +
			 "(state, male, female, total) " +  "values" + 
			"('Hyderabad', 150, 100, 250)");
			
			
			String sql = "Select * From details";
			myRs = myStmt.executeQuery(sql);
			
			
			while (myRs.next()) {
				System.out.println(myRs.getString("state") + ", " + myRs.getString("male") + ", " + myRs.getString("female") + ", " + myRs.getString("total"));
		}
	}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
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
	}
}
