import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		GCD obj = new GCD();
		System.out.println(obj.gcd(num1,num2));
		
	}
	
	public Integer gcd(int num1,int num2) {
		while(num1 != num2) {
			if(num1 > num2) {
				num1 = num1 - num2;
			} else {
				num2 = num2 - num1;
			}
			
		}
		return num2;
		
	}
}
