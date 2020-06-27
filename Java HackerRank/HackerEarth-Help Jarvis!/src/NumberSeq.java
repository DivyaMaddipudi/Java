/*
 * 1432 ---> after sorting 1234. since, 1234 is seq of numbers print YES
 * 1435 ---> after sorting 1345. hence, print NO 
 */

import java.util.*;
import java.util.Arrays; 
class NumberSeq {
	
	public static int isConsecutive(String str) 
	{ 
	     
	    int start; 
	  
	     
	    int length = str.length(); 
	  
	    
	    for (int i = 0; i < length / 2; i++)  
	    { 
	  
	        String new_str = str.substring(0, i + 1); 
	  
	        
	        int num = Integer.parseInt(new_str); 
	  
	         
	        start = num; 
	        while (new_str.length() < length)  
	        { 
	   
	        	num++;           
	            new_str = new_str + String.valueOf(num); 
	        } 
	  
	        if (new_str.equals(str))  
	        return start; 
	    } 
	  
	    return -1; 
	} 
	  
	
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();
   
        for(int i=0;i<cases;i++) {
            long n = s.nextLong();

            String str= Long.toString(n);
            char arr[] = str.toCharArray(); 
          
            Arrays.sort(arr);
            String res = String.valueOf(arr);
            int start = isConsecutive(res); 
            if (start != -1) 
                System.out.println("Yes" ); 
            else
                System.out.println("No"); 

            
            
            
        }

    }
}
