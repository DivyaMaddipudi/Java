/*
 * 
	Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

	For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */

package org.divya.DailyCodingProblem;

import java.util.*;

public class Main {
	
	public static void findValues(List<Integer> list, int k) {
		int count = 0;
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i) + list.get(j)  == k) {
					count = count + 1;
				}
			}
		}
		
		if(count != 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<4;i++) {
			list.add(sc.nextInt());
		}
		int k = sc.nextInt();
		
		findValues(list, k);
		
	}

}
