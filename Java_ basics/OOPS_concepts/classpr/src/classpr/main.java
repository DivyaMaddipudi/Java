package classpr;
class Bike {
	
	//data
	boolean power;
	int speed;
	String color;
	
	//methods
	void start() {
		
		power = true;
		speed = 0;
		color = "Black";
	}
	
	void stop() {
		
		power = false;
		speed = 0;
		color = "Blue";		
	}
	
	void accelerate(int newspeed) {
		speed = newspeed;
	}
	
	void printvalues() {
		System.out.println("Current State");
		System.out.println("Power."+ power);
		System.out.println("Speed."+ speed);
		System.out.println("Color."+ color);
	}
	
}
public class main {

	public static void main(String[] args) {
		Bike b1, b2;
		
		b1 = new Bike();
		
		b2 = new Bike();
		
		b1.start();
		
		b2.start();
		
		b1.accelerate(50);
		
		b2.accelerate(60);
		
		b2.stop();
		
		b1.printvalues();
		
		b2.printvalues();

	}

}
