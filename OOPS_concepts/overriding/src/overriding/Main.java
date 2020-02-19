package overriding;

class Base {
	
	public void f() {
		System.out.println("f() in base");
	}
	
	public void g() {
		System.out.println("g() in base");
	}
}

class Derived extends Base {

	public void g() { //overriding the function g()
		System.out.println("g() in base");
	}
	
	public void h() {
		System.out.println("h() in derived");
	}
}

public class Main {

	public static void main(String[] args) {
		
		Base b = new Base();
		
		b.f();
		b.g();
		
		System.out.println();
		
		Derived d = new Derived();
		d.f();
		d.g(); //in derived
		d.h(); // in derived
		
		System.out.println();
		
		Base b2 = new Derived();
		
		b2.f();
		b2.g();
		((Derived)b2).h();

	}

}
