package polymorphism.examples;

public class Trousers extends Clothing{
	
	private char size;
	private char gender;
	
	public Trousers(double price, char size, char gender) {
		super("trousers", price);
		this.size = size;
		this.gender = gender;
	}
	


	public void setSize(char size) {
		this.size = size;
	}

	public char getSize() {
		return size;
	}
	
	public String getGender() {
		
		String genderValue ="";
		switch(gender) {
		case 'M':
			genderValue = "Male";
			break;
		case 'F':
			genderValue = "Female";
			break;
		default:
			genderValue = "Others";
			break;
		}
		return genderValue;
		
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void display() {
		super.display();
		System.out.println("size is: " + size);
		System.out.println("Gender is: " + gender);
	}
	
	

}
