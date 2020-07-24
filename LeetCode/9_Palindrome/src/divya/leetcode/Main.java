package divya.leetcode;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int rev = 0;
		int num = x;
		if(x<0) {
			System.out.println("false");
		} else {
			while (x != 0) {
				int rem = x % 10;
				rev = rev * 10 + rem;
				x = x / 10;
			}
			if (rev == num) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}

		}
	}

}
