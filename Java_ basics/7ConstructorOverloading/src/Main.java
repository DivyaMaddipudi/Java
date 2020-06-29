
public class Main {

	public static void main(String[] args) {
		var employee1 = new Employee(50_000);
		var employee = new Employee(50_000,20);
		int wage = employee1.calculateWage(10);
		System.out.println(wage);
	}

}
