import java.text.NumberFormat;

public class MortgageReport {
	
	private MortgageCalculator calculator ;
	private final NumberFormat currency;
	
	public MortgageReport(MortgageCalculator calculator) {
		super();
		this.calculator = calculator;
		currency = NumberFormat.getCurrencyInstance();
	}

	public void printMortgage() {		
		double mortgageValue = calculator.calculateMortgage();
		String mortgageFormatted = currency.format(mortgageValue);
		
		System.out.println("Mortgage");
		System.out.println("---------");
		System.out.println(mortgageValue);
	}
	
	public void printPaymentSchedule() {
		System.out.println("Mortgage Payment");
		System.out.println("----------------");
		for(double balance : calculator.getRemainingBalances()) {
			System.out.println(currency.format(balance));
		}
	}
}
