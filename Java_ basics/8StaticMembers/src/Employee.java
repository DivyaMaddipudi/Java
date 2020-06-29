
public class Employee {

	private int baseSalary;
	private int hourlyRate;
	
	public static int numberOfEmployees;

	public Employee(int baseSalary, int hourlyRate) {
		setBaseSalary(baseSalary);
		setHourlyRate(hourlyRate);
		numberOfEmployees++;
	}
	
	public static void printNumberOfEmployees() {
		System.out.println(numberOfEmployees);
		int wage = new Employee(100,20).calculateWage(10); //Since, calculateWage() belongs to employee obj 
		System.out.println(wage);
	}

	private void setBaseSalary(int baseSalary) {
		if (baseSalary<=0) 
			throw new IllegalArgumentException("baseSalary can't be lessthan 0");
		this.baseSalary = baseSalary;

	}

	private int getBaseSalary() {
		return baseSalary;
	}

	private void setHourlyRate(int hourlyRate) {
		if(hourlyRate <= 0)
			throw new IllegalArgumentException("hourlyRate can't be lessthan 0");
		this.hourlyRate = hourlyRate;
	}
	private int getHourlyRate() {
		return hourlyRate;
	}

	public int calculateWage(int extraHours) {
		return baseSalary + (hourlyRate * extraHours);
	}

}
