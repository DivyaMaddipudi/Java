package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practice {
	public static void main(String[] args) throws Exception {
	
		String url = "jdbc:mysql://localhost:8080/example";
		String uname = "student";
		String pass= "student";
		String Query = "SELECT * FROM EMPLOYEE WHERE ID = 3";
		
		Class.forName("com.mysql.jdbc.Driver");//class forname
		
		Connection conn = DriverManager.getConnection("url", "uname", "pass");
		System.out.println("Database connection successful!\n");
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery(Query);
		
		String name = rs.getString("username");
		System.out.println(name);
		
		st.close();
		conn.close();
	}
}

