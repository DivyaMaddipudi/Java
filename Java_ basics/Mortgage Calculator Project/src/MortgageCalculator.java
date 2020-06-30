
public class MortgageCalculator {
	private int principal;
	private double rateAnnualy;
	private int years;
	
	private static byte PERCENT = 100;
	private static byte MONTH_IN_YEARS = 12;
	
	public double[] getRemainingBalances() {
		var balances = new double[getNumberOfPayments()];
		for(short month=1;month <= balances.length; month++ ) {
			balances[month - 1] = calculateBalance(month);
		}
		return balances;
	}
	

	public MortgageCalculator(int principal, double rateAnnualy, int years) {
		super();
		this.principal = principal;
		this.rateAnnualy = rateAnnualy;
		this.years = years;
	}

	public double calculateMortgage() {	

		double monthlyRate = getMonthlyRate();
		double numberOfPayments = getNumberOfPayments();
		
		return principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)/(Math.pow(1 + monthlyRate, numberOfPayments) - 1));
	}
	
	public double calculateBalance(short numberOfPaymentsMade) {
		
		double monthlyRate = getMonthlyRate();
		double numberOfPayments = getNumberOfPayments();

		double balance = principal
	              * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsMade))
	              / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
		
		return balance;
	}
	
	
	private int getNumberOfPayments() {
		return years * MortgageCalculator.MONTH_IN_YEARS;
	}

	private double getMonthlyRate() {
		return rateAnnualy/MortgageCalculator.PERCENT/MortgageCalculator.MONTH_IN_YEARS;
	}

}
