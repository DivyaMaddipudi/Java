/*
 * Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * 
 */

package org.divya.DailyCodingProblem;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		//int[] arr = {3, 4, -1, 1};
		int[] arr = {1, 2, 0};
		Arrays.sort(arr);
		int input = 1;
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i] > 0 && arr[i] == input) {
				input++;
			} else if(arr[i] <= 0) {
				input++;
			}
			
		}
		System.out.println(input);
	}

}
