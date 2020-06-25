/*
 * 
 * N = 24
 * then ---> (4,6) and (1,24) are good pairs but (3,8) and (2,12) are not hence output is 2.
 */

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner s = new Scanner(System.in);
       
        int test_cases = s.nextInt();

        for(int i=0;i<test_cases;i++) {
            int num = s.nextInt();
            
            prime(num);
            //System.out.println(prime(num));
            
        }
    }

    public static boolean nonprime(int n) {
    
    	if( n == 1) {
    		return true;
    	} else {
    	for(int i=2;i<=n/2;i++) {
            if(n%i==0)
                return true;
        }
        return false;
    }
   }
    
    		 
    public static void prime(int num) {
    	int count = 0;
    	int x = 0;
    	
    	int prod = 1;
        List<Integer> pdata = new ArrayList<Integer>();
        List<Integer> npdata = new ArrayList<Integer>();
        for(int i=1;i<=num;i++) {
            if(num%i == 0) {
                if(nonprime(i)) {
                	pdata.add(i);	
                } else {
                	npdata.add(i);
                }
            }
        }
        
        Integer[] values = pdata.toArray(new Integer[0]);
        Integer[] npvalues = npdata.toArray(new Integer[0]);
        
        for(int i = 0; i< npvalues.length;i++) {
        	prod = prod * npvalues[i];
        	System.out.println(npvalues[i]);
        }
        System.out.println(prod);
        
        if(prod == num) {
        	System.out.println("-1");
        } else {
        for(int i=0;i<(values.length) - 1 ;i++) {
        for(int j= i + 1;j<values.length;j++) {
        	
        	if(values[i] * values[j] == num) {
        		count = count + 1;
        		
        		}	
        	}
        }
        System.out.println(count);
        }
    }
}
