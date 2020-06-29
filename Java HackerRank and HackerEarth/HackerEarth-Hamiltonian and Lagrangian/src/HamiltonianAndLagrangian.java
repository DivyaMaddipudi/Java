/*
 * 
 * Output all the integers separated in the array from left to right that are not smaller than those on its right side.
 * input: 
 * 		16, 17, 4, 3, 5, 2
 * output: 
 * 		17 5 2
 * 
 */

import java.util.*;

class HamiltonianAndLagrangian {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] array = new int[size];

        for(int i=0;i<size;i++){
            array[i] = s.nextInt();
        }

        String str = "";
        int count  = 0;
        for(int i=0;i<size-1;i++) {
        	count = 0;
            for(int j = i+1;j<size;j++) {
                if(array[i] > array[j]) {
                     count = count + 1;    
                }   
                if(count == (size-1) - i) {
               	 str = str + Integer.toString(array[i]) + " ";
                }
            }
            
        }
        str = str + Integer.toString(array[size -1]);
        System.out.println(str);
    }
}
