import java.util.Scanner;

public class Numbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		if(n1 != n2 && n2 != n3 && n3 != n1) {
			System.out.println(0);
		} else if(n1 == n2 || n2 == n3 || n3 == n1) {
			System.out.println(50);
		} else {
			System.out.println(100);
		}
		
	}

}
