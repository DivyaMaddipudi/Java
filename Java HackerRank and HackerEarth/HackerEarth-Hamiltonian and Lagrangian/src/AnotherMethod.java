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

class AnotherMethod {
	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] array = new int[size];

		for(int i=0;i<size;i++){
			array[i] = s.nextInt();
		}

		int maxValue = array[size -1];

		String str = "";
		for(int i=size-2;i>=0;i--) {
			if(array[i] >= maxValue) {
				maxValue = array[i];
				str = Integer.toString(maxValue) + " " + str ;
			}
		}
		str = str + Integer.toString(array[size -1]);
		System.out.println(str);
	}
}
