import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int principal = (int) Console.readNumber();
		double rateAnnualy = Console.readNumber();
		int years = (int) Console.readNumber();
		
		var calculator = new MortgageCalculator(principal, rateAnnualy, years);
		var report = new MortgageReport(calculator);
		
		report.printMortgage();
		report.printPaymentSchedule();
	}

}
