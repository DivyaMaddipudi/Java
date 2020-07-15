package polymorphism.examples;

public class Main {

	public static void main(String[] args) {
		
		//Polymorphism
		
		Clothing c1 = new Trousers(26.99, 'M', 'F');
		Clothing c2 = new Shirt(30.99, 'S', 'B');
		
		c1.display();
		System.out.println();
		c2.display();
		
		if(c1 instanceof Trousers) {
			System.out.println(((Trousers)c1).getGender());
		} 

	}

}
