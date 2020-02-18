package constructor;

class Sample {
	
	private int value;
	
	//constructor
	
	Sample() {
		 value = 10;
	}
	
	//constructor overloading
	
	Sample(int n) {
		value = n;
	}
	
	public void print() {
		System.out.println(value);
	}
}

public class Main {

	public static void main(String[] args) {
		Sample s = new Sample();
		s.print();
		
		Sample s1 = new Sample(100);
		s1.print();

	}

}
