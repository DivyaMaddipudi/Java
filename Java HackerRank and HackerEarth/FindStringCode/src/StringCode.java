import java.util.Scanner;

public class StringCode {
	
	static int diff;
	static void code(String[] st) {
		
		for(int i =0;i<st.length;i++) {
			
			int diff = st[i].charAt(i) - st[i].charAt((st[i].length()) - i);
			System.out.println(diff);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str += sc.nextLine();
		
		String[] st = str.split(" ", ',');
		
		
		//for(int i =0;i<st.length;i++) {
			//System.out.println(st[i].toUpperCase());
		//}
		
		code(st);
		//System.out.println(code(st));
		
	}

}
