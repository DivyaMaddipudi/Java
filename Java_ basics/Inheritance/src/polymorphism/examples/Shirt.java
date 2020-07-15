package polymorphism.examples;

public class Shirt extends Clothing {
	private char size;
	private char colorCode;
	
	public Shirt(double price, char size, char colorCode) {
		super("shirt", price);
		this.size = size;
		this.colorCode = colorCode;
	}
	
	public void display() {
		super.display();
		System.out.println("size :" + size);
		System.out.println("color code :" + colorCode );
	}

}
