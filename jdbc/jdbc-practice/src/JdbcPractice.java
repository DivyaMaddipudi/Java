import java.sql.*;

class JdbcPractice {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/example";
		String uname = "student";
		String pass = "student";
		String Query = "SELECT * FROM EMPLOYEE";
		
		try {
		Connection conn = DriverManager.getConnection(url, uname, pass);
		System.out.println("Connection successfull");
		
		Statement st =  conn.createStatement();
		ResultSet rs = st.executeQuery(Query);
		
		
		
		while(rs.next()) {
		String employeeData = rs.getInt(1) + " : " + rs.getString(2);
		System.out.println(employeeData);
		}
		
		
		st.close();
		conn.close();
		
		}catch (Exception e) {
			System.out.println("Connection Error");
			System.out.println(e.getMessage());
		}
		
	}
}