/*
 *
 *  input:
 *  	1(numberOfTestCases)
 *  	3(size) 4(checkValue)
 *  	1 2 5 (array elements)
 *  	
 *  output:
 *  	3
 *  	
 *  	After 1 second, array will be 2 3 6
		After 2 second, array will be 3 4 7
		After 3 second, array will be 4 5 8
		Hence, answer = 3
 */

import java.util.*;

class ArrayUpdate {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int numberOfTestCases = s.nextInt();

        while(numberOfTestCases != 0) {

            int size = s.nextInt();
            int checkValue = s.nextInt();
            int[] array = new int[size];

            for(int i=0;i<size;i++) {
                array[i] = s.nextInt();
            }

            int count = 0;
            int minimumValue = array[0];

            for(int i=0;i<size;i++) {
                if(array[i] < minimumValue) {
                    minimumValue = array[i];
                }
            }
            count = checkValue - minimumValue;
            if(count > 0) 
                System.out.println(count);
            else 
                System.out.println("0");
            numberOfTestCases--;

        }

    }
}
