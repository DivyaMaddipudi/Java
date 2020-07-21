import java.util.Arrays;
import java.util.Scanner;

public class LettersCount {
	
	public static String printOrder(String inp1) {
		String order;
		char charArr[] = inp1.toCharArray();
		Arrays.sort(charArr);
		String str = "";
		
		for(char val: charArr) {
			str = str + val;
		}
		String revStr = "";
		for(int i=str.length() - 1;i>=0;i--) {
			revStr = revStr + str.charAt(i);
		}
		if(str.equals(inp1)) {
			order = "increasing";
		} else if(revStr.equals(inp1)) {
			order = "decreasing";
		} else {
			order = "invalid";
		}
		return order;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp1 = sc.nextLine();
		String inp2 = sc.nextLine();
		int count = 0;
		
		String order = printOrder(inp1);
		
		
		if(inp1.length() == inp2.length()) {
			for(int i=0;i<inp1.length();i++) {
				if(inp1.charAt(i) != inp2.charAt(i)) {
					count = count + 1;
				}
			}
		} 
		if(order == "increasing" || order == "decreasing") {
			System.out.println(order + ":" + count);
		} else {
			System.out.println(order);
		}
	}
}
