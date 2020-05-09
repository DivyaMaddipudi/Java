package inheritance;

class BasicCalc {
	
	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}
}

class ScientificCalc extends BasicCalc {
	
	public double sin(int deg) {
		double rad = deg * 3.14 / 180;
		return Math.sin(rad);
	}
	
}


public class Main {

	public static void main(String[] args) {
		BasicCalc obj = new BasicCalc();
		
		System.out.println(obj.add(10, 20));
		System.out.println(obj.sub(40, 20));
		
		System.out.println();

		ScientificCalc sCal = new ScientificCalc();
		
		System.out.println(sCal.add(10, 20));
		System.out.println(sCal.sub(40, 20));
		System.out.println(sCal.sin(90));
		
		BasicCalc bCal2 = new ScientificCalc();	
		System.out.println(bCal2.add(10, 20));
		System.out.println(bCal2.sub(40, 20));
		System.out.println(((ScientificCalc)bCal2).sin(90));

	}

}
