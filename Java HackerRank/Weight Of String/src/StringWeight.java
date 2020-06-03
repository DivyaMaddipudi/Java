import java.util.Scanner;

public class StringWeight {
	
	 

	static int weightValue(String str, int val) {
		
		int sum = 0;
		if(val == 1) {
			
		for(int i=0;i<str.length();i++) {
			
			int asciiValue = str.charAt(i);
			int value = asciiValue - 64;
		    sum = sum + value;
			}
		
		} else if(val==0) {
			str = str.replaceAll("[AEIOU]", "");
			for(int i=0;i<str.length();i++) {
				int asciiValue = str.charAt(i);
				int value = asciiValue - 64;
			    sum = sum + value;
			}	
			
		} 
			
		return sum;
	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
	
		String st = " ";
		 
		st= sc.next();
		st +=sc.next();
		
		int val = sc.nextInt();	
	    sc.close();

		String resultStr="";  
		
		for (int i=0;i<st.length();i++)  
		{  
		if (st.charAt(i)>64 && st.charAt(i)<=122)   
		{    
		resultStr=resultStr+st.charAt(i);  
		}  
		}  
		String str = resultStr.toUpperCase();
		
		int weight = weightValue(str, val);
		System.out.println(weight);
		
		
	}

}
