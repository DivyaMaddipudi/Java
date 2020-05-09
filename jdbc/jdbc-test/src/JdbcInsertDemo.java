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
		
		String dburl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";
		
		try {
			
			myConn = DriverManager.getConnection(dburl, user, pass);
			
			myStmt = myConn.createStatement();
			
			// Inserting a row into db
			
			// int rowsAffected = myStmt.executeUpdate("insert into employees " +
			// "(last_name, first_name, email, department, salary) " +  "values" + 
			//	"('Bannu', 'Appari', 'bannu@gmail', 'cse', 55000.00)");
			
			
			//Updating
			int rowsAffected = myStmt.executeUpdate("update employees " + 
								"set email = 'bannu@gmail.com' " + 
					 			"where last_name='Bannu' and first_name='Appari' ");
			
			
			myRs = myStmt.executeQuery("select * from employees where last_name = 'Bannu");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("email"));
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
