import java.util.Scanner;

public class NumWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		while(num!=0) {
			int rem = num%10;
			sum = sum + rem;
			num = num/10;
		}
		System.out.println(sum);
		String s = Integer.toString(sum);
       String ones[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        String st = "";
        for(int i=0;i<s.length();i++) {
        	st = st + ones[Integer.parseInt(s.substring(i,i+1))] + " ";
        }
        System.out.println(st);
        //System.out.println(ones[Integer.parseInt(s.substring(0,1))] +" "+ones[Integer.parseInt(s.substring(1,2))]);
	}
}
