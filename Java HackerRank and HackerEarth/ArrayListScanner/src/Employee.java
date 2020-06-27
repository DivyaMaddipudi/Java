import java.util.*;

public class Employee{
    String FirstName;
    String LastName;
    String Mobile;
    
    public Employee(String fname, String lname,String mobile){
        this.FirstName = fname;
        this.LastName = lname;
        this.Mobile = mobile;
    } 
    public static void main(String []args){
        List<Employee> emp_list = new ArrayList<Employee>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee Details");
        String data;
        
        while((data = scanner.nextLine()).length() > 0){
            String[] arrdata = data.split(",", 0);
            if(arrdata.length != 3 || arrdata[0].length() == 0 || arrdata[1].length() == 0 || arrdata[2].length() == 0){
                System.out.println("Invalid Employee Record");
            }
            else{
                Employee obj = new Employee(arrdata[0],arrdata[1],arrdata[2]);
                emp_list.add(obj);
                System.out.println("Enter Next Employee Details");
            }
        }
        Collections.sort(emp_list,new NameComparator());
        Iterator itr= emp_list.iterator();  
        while(itr.hasNext()){  
            Employee emp = (Employee)itr.next();  
            System.out.println(emp.FirstName);  
        }  
    }
}
class NameComparator implements Comparator{  
    public int compare(Object o1,Object o2){  
        Employee e1=(Employee)o1;  
        Employee e2=(Employee)o2;  
  
        return e1.FirstName.compareTo(e2.FirstName);  
    }  
}