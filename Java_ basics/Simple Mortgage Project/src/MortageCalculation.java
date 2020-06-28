import java.text.NumberFormat;
import java.util.Scanner;

public class MortageCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final byte percent = 100;
		final byte months = 12;

		int principle = 0;
		double rateAnnualy = 0;
		double rateMonthly = 0;
		int numberOfPayments = 0;
		int years = 0;

		while(true) {
			principle = sc.nextInt();
			if(principle>=1000 && principle<= 1_000_000) {
				break;
			}
			System.out.println("Enter between 1K and 1M");
		}

		while(true) {
			rateAnnualy = sc.nextDouble();
			if(rateAnnualy>=1 && rateAnnualy<=30) {
				rateMonthly = rateAnnualy/percent/months; //monthly rate
				break;
			}
			System.out.println("Enter between 1 and 30");

		}

		while(true) {
			years = sc.nextByte();
			if(years>=1 && years<=30) {
				numberOfPayments = years * months; //number of payments
				break;
			}
			System.out.println("Enter between 1 and 30");
		}

		double mortgageValue = principle * (rateMonthly * Math.pow(1 + rateMonthly, numberOfPayments)/(Math.pow(1 + rateMonthly, numberOfPayments) - 1));

		String res = NumberFormat.getCurrencyInstance().format(mortgageValue);

		System.out.println(res);


	}

}
