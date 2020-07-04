
public class TaxCalculator implements CanCalculateTax {
	
	private double taxableIncome;
	

	public TaxCalculator(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	
	@Override
	public double calculateTax() {
		return taxableIncome * 0.4;
		
	}

}
