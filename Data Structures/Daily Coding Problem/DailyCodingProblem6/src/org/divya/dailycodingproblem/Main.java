/*
 * 
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * 
 */

package org.divya.dailycodingproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void alphabetsList(String val) {
		ArrayList<String> lists = new ArrayList<String>();
		ArrayList<String> resultList = new ArrayList<String>();
		char[] arr = new char[26];
		String res = "";
		int num = 97;
		for(int i=0;i<arr.length;i++) {
			arr[i] = (char) num;
			num++;	
		}
		
		if(val.length() >= 3) {
			for(int i=0;i<val.length();i++) {
				char str = val.charAt(i);
				int intVal = str - '0';
				res = res + arr[intVal-1];
				
			}
			lists.add(res);
		} else if(val.length() == 2 || val.length() == 1) {
			if(Integer.parseInt(val) < 26) {
				res = res + arr[Integer.parseInt(val) -1];
				lists.add(res);
			}
		} 
		
		for(String result:lists) {
			System.out.println(result);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int len = input.length();
		
		HashSet<String> inp = new HashSet<String>();
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<=i;j++) {
				if(! inp.contains(input.substring(j, i+1))){
					inp.add(input.substring(j, i+1));
				}
			}
		}
		
		
		for(String val: inp) {
			alphabetsList(val);
			//System.out.println(val);
		}
		
	}

}
