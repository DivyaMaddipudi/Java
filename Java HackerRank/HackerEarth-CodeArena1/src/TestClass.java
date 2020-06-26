
/*
 * 
 * Count Number of palindromes between two numbers
 * eg: 10 13 ---> 10, 11, 12, 13 hence count = 1 (11 is only palindrome num)
 * 
 */
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int val = 0;
        int count;
        for(int i =0;i<t;i++) {
        	
        	count = 0;
            int a = s.nextInt();
            int b = s.nextInt();
            for(int j=a;j<=b;j++) {
            
            	int num =j;
            	int rev = 0;
            	
            	while(num !=0) {
            		int rem = num%10;
            		rev = rev * 10 + rem;
            		num = num/10;
            	}
            	if(j == rev) {
            		count = count + 1;
            	}
            }
            System.out.println(count);
        }
        
    }
}
