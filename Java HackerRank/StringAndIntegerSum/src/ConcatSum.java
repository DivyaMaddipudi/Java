import java.util.Scanner;

public class ConcatSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int len = 0;
		int val = 0;
		int rem;
		
		for(int i=0;i<s.length;i++) {
			len = len + s[i].length();
		}
		
		String count = Integer.toString(len);
		if(count.length()>1) {
		while(len!=0) {
			rem = len%10;
			val = val + rem;
			len = len/10;
			}
			System.out.println(val);
		} else {
			System.out.println(len);
		}
		
	}

}
