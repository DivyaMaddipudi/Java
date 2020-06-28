import java.text.NumberFormat;
import java.util.Scanner;

public class MortageCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final byte percent = 100;
		final byte months = 12;
		
		int p = 0;
		double rate = 0;
		double r = 0;
		int n = 0;
		int years = 0;
		
		while(true) {
		p = sc.nextInt();
		if(p>=1000 && p<= 1_000_000) {
			break;
		}
		System.out.println("Enter between 1K and 1M");
		}
		
		while(true) {
		 rate = sc.nextDouble();
		 if(rate>=1 && rate<=30) {
			  r = rate/percent/months; //monthly rate
			 break;
		 }
		 System.out.println("Enter between 1 and 30");
		 
		}
		
		while(true) {
		 years = sc.nextByte();
		 if(years>=1 && years<=30) {
			 n = years * months; //number of payments
			 break;
		 }
		 System.out.println("Enter between 1 and 30");
		}
		
		double M = p * (r * Math.pow(1 + r, n)/(Math.pow(1 + r, n) - 1));
		
		String res = NumberFormat.getCurrencyInstance().format(M);
		
		System.out.println(res);
		

	}

}
