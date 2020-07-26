/*
 * Given a string S, check if the letters can be rearranged 
 * so that two characters that are adjacent to each other are not the same.

	If possible, output any possible result.  If not possible, return the empty string.
	
	Example 1:
	
	Input: S = "aab"
	Output: "aba"
	Example 2:
	
	Input: S = "aaab"
	Output: ""

 * 
 */
package divya.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		char arr[] = new char[str.length()];

		for(int i=0;i<str.length();i++) {
			arr[i] = str.charAt(i);
		}
		Arrays.sort(arr);
		String updatedStr = "";

		for(int i=0;i<str.length();i++) {
			updatedStr = updatedStr + arr[i];
		}
		String finalResult = "";

		int len = updatedStr.length();
		int count = 0;
		int max = 0;
		char maxChar = 'a';

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<updatedStr.length();i++) { 
			map.put(updatedStr.charAt(i), map.getOrDefault(updatedStr.charAt(i), 0) + 1);
		}
		System.out.println(map);

		for(int i=0;i<updatedStr.length();i++) {
			if (map.get(updatedStr.charAt(i)) > max) {
				max = map.get(updatedStr.charAt(i));
				maxChar = updatedStr.charAt(i);

			}     
		}

		int index = updatedStr.lastIndexOf(maxChar);
		
		int check = (len+1)/2;
		if(max > check ) {
			System.out.println(finalResult);
		} else if(len%2 != 0) {
			if(index < (len-1)) {
				for(int i=0;i<len/2;i++) {
					finalResult = finalResult + updatedStr.charAt(i) + updatedStr.charAt(len-1-i);
				}
				finalResult = finalResult + updatedStr.charAt(len/2);
			} else if(index == (len - 1)) {
				for(int i=index;i>len/2;i--) {
					finalResult = finalResult + updatedStr.charAt(i) + updatedStr.charAt(len-1-i);
				}
				finalResult = finalResult + updatedStr.charAt(len/2);
			}
		} else if(len%2 == 0) {
			if(index < (len-1)) {
				for(int i=0;i<len/2;i++) {
					finalResult = finalResult + updatedStr.charAt(i) + updatedStr.charAt(len-1-i);
				}
				
			} else if(index == (len - 1)) {
				for(int i=index;i>len/2;i--) {
					finalResult = finalResult + updatedStr.charAt(i) + updatedStr.charAt(len-1-i);
				}
				
			}
			System.out.println(finalResult);

		}
	}
}
