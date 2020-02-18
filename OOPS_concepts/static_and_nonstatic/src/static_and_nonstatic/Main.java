package static_and_nonstatic;

class Mymath {
	
	public static int add(int x, int y) {
		return x + y;
	}
	
	public static int sub(int x, int y) {
		return x - y;
	}
}
public class Main {

	public static void main(String[] args) {
		
		// Mymath obj = new Mymath(); --> object is not required as they are static
		
		int a = Mymath.add(10,20);
		int b = Mymath.sub(30, 20);
		
		System.out.println("a is " + a);
		System.out.println("b is " + b);

	}

}
