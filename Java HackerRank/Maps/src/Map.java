import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

class Employee {
	private String name;
	private String no;
	
	public Employee(String name, String no) {
		super();
		this.name = name;
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
}
public class Map {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> emplis = new ArrayList<Employee>();
		String data;
		
		while((data = sc.nextLine()).length()>0) {
			String[] arr = data.split(",");
			if(arr.length != 2 || arr[0].length() == 0 || arr[1].length() == 0) {
				System.out.println("Invalid");
			} else {
				Employee emp = new Employee(arr[0], arr[1]);
				emplis.add(emp);
			}
		}
		Iterator it =  emplis.iterator();
		while(it.hasNext()) {
			Employee emp = (Employee)it.next();
			System.out.println(emp.getName() + emp.getNo());
		}

	}

}
