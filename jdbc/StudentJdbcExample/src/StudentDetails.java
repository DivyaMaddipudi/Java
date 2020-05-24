import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class StudentDetails {
	public static void main(String[] args) throws Exception {
		
		List<Student> studentList = new ArrayList<Student>();
		
		Statement st = null;
		ResultSet rs = null;
		String query = "SELECT * FROM STUDENT";
		
		
		String url = "jdbc:mysql://localhost:3306/example";
		String uname = "student";
		String pass = "student";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				Student s = new Student();
				s.setFirstname(rs.getString("firstname"));
				s.setLastname(rs.getString("lastname"));
				s.setAge(rs.getInt("age"));
				
				studentList.add(s);
			}
				
				for(Student value: studentList) {
					System.out.print("FirstName: "+value.getFirstname()+ ", ");
					System.out.print("LastName: "+value.getLastname()+ ", ");
					System.out.print("age: "+value.getAge());
					System.out.println();
				
			}
			
		} catch (Exception e) {
			System.out.println("error");
			System.out.println(e.getMessage());
		}
	}

}
