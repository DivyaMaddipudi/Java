import java.util.Scanner;

public class Console {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static double readNumber() {
		double number = scanner.nextDouble();
		return number;
	}

}
