package constructor_overloading;

class Complex {
	private double real, img;
	
	public Complex () {
		real = img = 0;
	}
	
	public Complex(int r) {
		real = r;
		img = 0;
	}
	
	public Complex(int r, int i) {
		real = r;
		img = i;
	}
	
	public void print() {
		System.out.println(real + " +i " + img);
	}
}

public class Main {

	public static void main(String[] args) {
		Complex c1, c2, c3;
		
		c1 = new Complex();
		c2 = new Complex(10);
		c3 = new Complex(50,30);
		
		c1.print();
		c2.print();
		c3.print();
	

	}

}
