package findLongWord;
import java.util.Scanner;
public class UserMainCode {
	
	public String findLongWord(String input1) {
		
		StringBuffer s2 = new StringBuffer();
		
		if(input1.length() <= 10) {
			return input1;
		}
		else
		{
			
			s2.append(input1.charAt(0));
			s2.append(input1.length()-2);
			s2.append(input1.charAt(input1.length()-1));
			return s2.toString();
		}	
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1;
		s1 = sc.nextLine();
		UserMainCode obj = new UserMainCode();
		System.out.println(obj.findLongWord(s1));
	
}
}
