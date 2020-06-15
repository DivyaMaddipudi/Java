import java.util.Scanner;

public class WiproExample {
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	
	String st = "Wipro Technologies";

	
	String[] data = st.split(" ");
	for(String x: data) {
	
		System.out.print(position(x) + " ");
	}
	}
	
	public static String captial(String x) {
		String val = "";
		
		
		for(int i = (x.length()-1); i>=0;i--) {
			
			
			val = val + x.charAt(i);
		
		}
		
		
		return val;
		
	}
	
	public static String position(String st) {
		int index = 0;
		String res = "";
		for(int i =0;i<st.length();i++) {
			if(Character.isUpperCase(st.charAt(i))) {
				index = i;
			}
		 res = captial(st);
		for(int j = 0;j<st.length();j++) {
			Character.toUpperCase(st.charAt(index));
		}
		
		
	}
		return res;	
	}
	
}
