import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDetails {

	public static void main(String[] args) {
		
		EmployeeDAO dao = new  EmployeeDAO();
		Employee e1 = dao.getEmployee(2);
		System.out.println(e1.username);
		
	}

}

class EmployeeDAO {
	public Employee getEmployee(int id) {
		try {
		String query = "select username from employee where id="+id;
		Employee e = new Employee();
		e.id = id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "student", "student");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString(1);
		e.username = name;
		
		return e;
	
		}catch (Exception e) {
			System.out.println("err");
			System.out.println(e.getMessage());
		}
		return null;
	}
}

class Employee {
	
	int id;
	String username;
	
}
