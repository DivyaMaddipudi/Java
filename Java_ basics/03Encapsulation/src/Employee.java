
public class Employee {
	
	private int baseSalary;
	private int hourlyRate;
	
	public void setBaseSalary(int baseSalary) {
		if (baseSalary<=0) 
			throw new IllegalArgumentException("baseSalary can't be lessthan 0");
		this.baseSalary = baseSalary;
		
	}
	
	private int getBaseSalary() {
		return baseSalary;
	}
	
	public void setHourlyRate(int hourlyRate) {
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
