/*
 * 1432 ---> after sorting 1234. since, 1234 is seq of numbers print YES
 * 1435 ---> after sorting 1345. hence, print NO 
 */

import java.util.*;
import java.util.Arrays; 
class NumberSeq {
	
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();
        int count = 0;
        for(int i=0;i<cases;i++) {
            int n = s.nextInt();

            String str= Integer.toString(n);
            char arr[] = str.toCharArray(); 
             
            Arrays.sort(arr); 
            count = 0;
            for(int j=0;j<(arr.length-1);j++) {
            
            	if(arr[j] + 1 == arr[j+1]) {
            		count = count + 1;
            	} 
            }
            if(count == (arr.length - 1)) {
            	System.out.println("Yes");
            } else {
            	System.out.println("No");
            }

        }

    }
}
