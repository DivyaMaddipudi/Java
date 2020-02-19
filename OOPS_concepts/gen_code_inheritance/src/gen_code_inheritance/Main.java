package gen_code_inheritance;


class Vehicle {}

class TwoWheeler extends Vehicle {}

class FourWheeler extends Vehicle {}

class Bike extends TwoWheeler {}

class Car extends FourWheeler {}

public class Main {

	public static void test(Vehicle v) {
		
	}
	
	public static void main(String[] args) {
		test(new Vehicle());
		test(new TwoWheeler());
		test(new FourWheeler());
		test(new Bike());
		test(new Car());

	}

}
