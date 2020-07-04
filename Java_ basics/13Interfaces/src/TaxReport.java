
public class TaxReport {
	private CanCalculateTax calculator;
	
	public TaxReport(CanCalculateTax calculator) {
		this.calculator = calculator;
	}
	
	public void show() {
		var tax = calculator.calculateTax();
		System.out.println(tax);
	}
}
