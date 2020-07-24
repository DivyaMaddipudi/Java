/*
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

	Example 1:
	
	Input: 2
	Output: [0,1,1]
	Example 2:
	
	Input: 5
	Output: [0,1,1,2,1,2]

 * 
 */
package divya.leetcode;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] binBits = new int[num + 1];
		int count;
		
		for(int i = 0; i <= num; i++) {
			count = 0;
			int val = i;
			while(val > 0) {
				
				int rem = val%2;
				
				if(rem == 1) {
					count = count + 1;
				}
				val=val/2;	
			}
			
			binBits[i] = count;
		}

		for(int i=0;i<=num;i++) {
			System.out.println(binBits[i]);
		}
	}
}
