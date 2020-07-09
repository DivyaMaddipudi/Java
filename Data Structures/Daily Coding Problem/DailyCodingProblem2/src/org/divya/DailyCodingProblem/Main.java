/*
 * Given an array of integers, return a new array such that each element at index i of the 
   new array is the product of all the numbers in the original array except the one at i.

	For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
	If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * 
 */
package org.divya.DailyCodingProblem;

public class Main {
	public static void main(String[] args) {
		int[] originalArray = {3,2,1};
		int size = originalArray.length;
		int[] newArray = new int[size];
		int product = 1;
		
		for(int i=0;i<size;i++) {
			product = 1;
			for(int j=size -1;j>=0;j--) {
				if(j>i) {
					product = product * originalArray[j];
				} else if(j==i) {
					continue;
				} else if(j<i) {
					product = product * originalArray[j];
				}
				newArray[i] = product;
			}
		}
		
		
		for(int value:newArray) {
			System.out.println(value);
		}
	}
}
