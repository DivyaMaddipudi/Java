import java.util.Scanner;

public class sumOfDigits {
	
	static int sum = 0;
	static int rev = 0;
	static int reverse(int num) {
		while(num != 0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		return rev;
	}
	static int summing(int rev) {
		int number = rev;
		int length = String.valueOf(rev).length();
		
		for(int i=1;i<=length;i++) {
			
			while(rev != 0)
			{ 		
				sum = sum + rev%10;
				rev = rev/10;			
				
			}
			rev = (int) (number/Math.pow(10, i));
			System.out.println("sum" + sum);
			System.out.println(rev);
			
		}
		return sum;		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int val = reverse(num);
		int sum = summing(val);
		System.out.println(sum);
		
	}

}
