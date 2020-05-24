import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class InsertQuery {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/example";
		String uname = "student";
		String pass = "student";
		int id = 6;
		String username = "Deepu";
		//String query = "INSERT INTO employee values(" + id + ",'" + username + "')"; //For Create Statement
		String query = "INSERT INTO employee values(?, ?)"; //For Prepared statement
		
		try {
		Connection conn = DriverManager.getConnection(url, uname, pass);
		System.out.println("Connection successfull");
		PreparedStatement st =  conn.prepareStatement(query); //prepared statement
		st.setInt(1, id);
		st.setString(2, username);
		int count = st.executeUpdate();
		
		System.out.println(count + "rows effected");		
		
		st.close();
		conn.close();
		
		}catch (Exception e) {
			System.out.println("Connection Error");
			System.out.println(e.getMessage());
		}
		
	}
}