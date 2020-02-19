package super_keyword;

class Base {
	
	public void print() {
		System.out.print(" Hello ");
	}
}

class Derived extends Base {
	
	@Override
	public void print() {
		super.print();
		System.out.print(" World ");
	}	
}

public class Main {

	public static void main(String[] args) {
		 
		Base b1 = new Base();
		b1.print();
		
		System.out.println();
		
		Derived d = new Derived();
		d.print();

	}

}
