/*
Find T Value:
------------
Danielle was assigned the task of finding the T-Value by her Manager. She was
given a function called find_tvalue and was provided with 3 integer numbers
input1, input2 and input3. She is expected to return an integer value by following
the two rules:

Rule_1: There are four cases possible based on the value of input2.
	Case 1:
		if input2 is an even prime number then
		Calculate t = input1*input1*(sum of first input2 number of prime numbers).
	Case 2:
		if input2 is an odd prime number then
		Calculate t = input2*input2*(sum of first input3 number of prime numbers)
	Case 3:
		if input2 is an even composite number then
		Calculate t = input3*input3*(sum of first (input2+input3) number of prime numbers)
	Case 4:
		if input2 is an odd composite number then
		Calculate t = sum of first (inputl+input2+input3) prime numbers
	
	
Rule_2: There are two cases possible based on the value of t, which is computed in the above step. 
	Case 1:
		if the above value "t" is a prime, then return t+input3;
	Case 2:
		if the above value "t" is a not a prime, then return t-input3;

Assumptions:
Value of input1 is >=1 and input1<=1000.
Value of input2 is >=2 and input2<=1000.
Value of input3 is >=1 and input3<=1000.
The first prime number 2. And, the Prime numbers series is 2,3,5,7, 11,13...etc. 
The number which is not prime is called as composite number.
Number 1 is neither prime nor composite.
Syntax:
int find_tvalue(int input1 int input2, int input3);
-----------------------------------------------------------------------------
Sample Input/Output-1: 
inputl=1
input2=2
input3=1
output=6
Explanation:
Applying rule_1:
	input2=2 is an even prime number. So Find t = 1*1*(sum of first 2 prime numbers).
	t = 1*1*(2+3) = 1*1*5 = 5. 
Applying rule_2: 
	Now, t=5 is odd prime. so, return t+input3; that is 5+1;
	Hence 6 is the value returned. 
-----------------------------------------------------------------------------
Sample Input/Output-2:
input1=1
input2=5
input3=15
output=8185 
Explanation :
Applying rule_1:
	input2=5 is an odd prime. So, t = input2*input2*(sum of first 15 prime numbers)
	t= 5*5*(2+3+5+7+11+13+17+19+23+29+31+37+41+43+47)
	t = 25*(328) = 8200.
Applying rule2:
	Now, t=8200 is not a prime number. So, return t-input3 ; that is 8200-15 = 8185;
	Hence, 8185 is the value returned.
-----------------------------------------------------------------------------
*/

import java.util.Scanner;

public class FindTValue {

	public static int fintTvalues(int inp1, int inp2, int inp3) {
		int tVal = 0;
		if((inp2 % 2 == 0) && isPrime(inp2)) {
			tVal = tVal + inp1 * inp1 * printPrimes(inp2);
			
		} else if((inp2 % 2 != 0) && isPrime(inp2)){
			tVal = tVal + inp2 * inp2 * printPrimes(inp3);
			
		} else if((inp2 % 2 == 0) && !isPrime(inp2)){
			tVal = tVal + inp3 * inp3 * printPrimes(inp2 + inp3);
			
		} else if((inp2 % 2 != 0) && !isPrime(inp2)){
			tVal = tVal + printPrimes(inp1 + inp2 + inp3);
		}
		return tVal;
	}
	
	public static boolean isPrime(int inp2) {
		int count =0;
		if(inp2 <= 1) {
			return false;
		} else {
		for(int i=2;i<inp2;i++) {
			if(inp2%i == 0) {
				count = count + 1;
				}
			}
		}
		if(count != 0)
			return false;
		return true;
	}
	
	public static int printPrimes(int value) {
		int sum = 0;
		int counter = 1;
		int inp2 = 2;
		while(counter <= value) {
			if(isPrime(inp2)) {
				sum = sum + inp2;
				counter++;
				inp2++;
			} else {
				inp2++;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp1 = sc.nextInt();
		int inp2 = sc.nextInt();
		int inp3 = sc.nextInt();
		
		int tValue = fintTvalues(inp1, inp2, inp3);
		int res = 0;
		if(isPrime(tValue)) {
			res = res + tValue + inp3;
		} else {
			res = res + tValue - inp3;
		}
		System.out.println(res);
	}
}
