import java.util.Scanner;

public class StringAddition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		String a = sc.next();
		String b = sc.next();
		
		long val1 = Integer.parseInt(a);
		long val2 = Integer.parseInt(b);
		
		long sum = val1 + val2;
		String s = Long.toString(sum);
		System.out.println(s);

	}

}
