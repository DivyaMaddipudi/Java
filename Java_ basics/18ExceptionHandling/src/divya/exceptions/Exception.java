package divya.exceptions;

public class Exception {

	public static void main(String[] args) {
		
		try {
			int value = 12/0;
			System.out.println(value);
		} catch(ArithmeticException ae) {
			System.out.println(ae);
		}

	}

}
