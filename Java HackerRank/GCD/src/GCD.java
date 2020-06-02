import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		
		while(i1 != i2) {
			if(i1>i2) {
				i1 = i1 - i2;
			} else {
				i2 = i2 - i1;
			}
		}
		System.out.println(i2);
	}
}
