import java.util.Scanner;


public class MostFrequentDigit {	
	
	public static void main(String[] args) {
		
			
		Scanner sc = new Scanner(System.in);
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		int i3 = sc.nextInt();
		int i4 = sc.nextInt();
		
		String s1 = Integer.toString(i1);
		String s2 = Integer.toString(i2);
		String s3 = Integer.toString(i3);
		String s4 = Integer.toString(i4);
		
		String str = s1 + s2 + s3 + s4;
		
		int maxFrequency = 0;
		int finalValue = 0;
		
		int[]frequency = new int[10];
		int index = 0;
		
		
		for(int i = 0; i < str.length(); ++i)
		{
		 int digit = str.charAt(i) - '0';
		 frequency[digit] ++;
		}
		
		for(int i = 0; i < 10; ++i){
			   if(frequency[i] >= maxFrequency){
			     maxFrequency = frequency[i];
			     index = i;
			     
			    }
			  }
		System.out.println(index);		
	}
}
