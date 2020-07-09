/*
 * input: 6
		  10 9 7 10 9 6 (print number of cuts in the secong shot);
		  After 1st cut values are 9 9 7 9 9 6, In the second shot all the 9 are cut. hence output is 4.
		  Sice there are 4 9's in the second cut.
	output: 4

 */

import java.util.Arrays;
import java.util.Scanner;

public class Towers {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nt = sc.nextInt();
		int[] ht = new int[nt];
		for(int i=0;i<nt;i++) {
			ht[i] = sc.nextInt();
		}
		
		Arrays.sort(ht);
		int max = ht[nt-1];
		int secMax = 0;
		
		for(int i=nt-1;i>=0;i--) {
			if(ht[i] == max)
				secMax = ht[i-1];
		}
		//System.out.println(secMax);
		for(int i=0;i<nt;i++) {
			max = ht[nt-1];
			if(ht[i] == ht[nt-1]) {
				ht[i] = secMax;
			}
		}
		
		int count =0;
		max = ht[nt-1];
		for(int i =0;i<nt;i++) {
			if(ht[i] == max) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
