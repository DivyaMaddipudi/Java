/*
 * 
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair)
 * returns the first and last element of that pair. 
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 * 
 * 
 */

package divya.dailycodingproblem;

import java.util.*;

public class Main {
	
	public static Pair<Integer, Integer> cons(int num1, int num2) {
		Pair<Integer, Integer> p1 = Pair.of(num1, num2);
		return p1;	
	}

	public static int car(Pair<Integer, Integer> pairValue) {
		int firstValue = pairValue.getValue1();
		return firstValue;
		
	}
	
	public static int cdr(Pair<Integer, Integer> pairValue) {
		int secondValue = pairValue.getValue2();
		return secondValue;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pairValue1 = sc.nextInt();
		int pairvalue2 = sc.nextInt();
		
		Pair<Integer, Integer> pairValue = cons(pairValue1, pairvalue2);
		System.out.println("Constructed Pair is :");
		System.out.println(pairValue);
		
		System.out.println("First value :" + car(pairValue));
		System.out.println("Second value :" + cdr(pairValue));

		
	}

}
