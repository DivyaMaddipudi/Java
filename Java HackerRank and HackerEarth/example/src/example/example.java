package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Employee {
	private String firstName;
	private String lastName;
	private String mobileNo;
	
	public Employee(String firstName, String lastName, String mobileNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
public class example {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> empList = new ArrayList<Employee>();
		String data;
		while((data = sc.nextLine()).length()>0) {
			String[] arrdata = data.split(",", 0);
			 if(arrdata.length != 3 || arrdata[0].length() == 0 || arrdata[1].length() == 0 || arrdata[2].length() == 0){
	                System.out.println("Invalid Employee Record");
	            }
	            else{
	                Employee obj = new Employee(arrdata[0],arrdata[1],arrdata[2]);
	                empList.add(obj);
	                System.out.println("Enter Next Employee Details");
	            }
		}

		Collections.sort(empList, new sortByfirstName());
		Iterator itr= empList.iterator();  
        while(itr.hasNext()){  
            Employee emp = (Employee)itr.next(); 
            System.out.println(emp.getFirstName());  
        }
    }

}
class sortByfirstName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1=(Employee)o1;  
        Employee e2=(Employee)o2;  
  
        return e1.getFirstName().compareTo(e2.getFirstName());  
	}
	
}