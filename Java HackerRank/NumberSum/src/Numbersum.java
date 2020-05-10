import java.util.Scanner;

public class Numbersum {
	static int sum = 0;
	static void summing(int num) {
		sum = 0;
		while(num != 0)
		{ 
			
			int val = num%10;
			sum = sum + val;
			num = num/10;
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		summing(num);
		int length = String.valueOf(sum).length();
		if(length != 1)
		{
			summing(sum);
			System.out.println(sum);
		}
		
		
	}
}
