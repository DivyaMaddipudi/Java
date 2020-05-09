package initializers; //used for confg specific activities

class Sample {
	
	static {
		
		//when class is loaded into memory then executed
		//executed once per class
		System.out.println("static initializer");
	}
	
	static {
		System.out.println("static initializer1");
	}
	
	{
		//executed once per object
		System.out.println("non static initializer");
	}
	
	{
		System.out.println("non static");
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		Sample obj = new Sample();
		Sample obj1 = new Sample();
		Sample obj2 = new Sample();

	}

}
