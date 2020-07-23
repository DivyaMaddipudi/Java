/*
 * 
Given two strings input1 and input2 consisting of random alphabets,
find whether all the alphabets in input1 are in either increasing or decreasing
order based on their ascii value.

For Example,
input1 = "ACZa", its in increasing order. (65, 67, 90, 97)
input1 = "tbGB", its in decreasing order. (116, 98, 71, 66)
In case if input1 is not in either increasing or decreasing order, directly return
Invalid.
After deciding input1 as increasing or decreasing. Consider input2 which
consists of
the same alphabets which are in input1, but the order of the alphabets may
change.

For Example,
input1 = "ACZa" input2 = "CAZa" here 'C' and 'A' are misplaced in input2, so the
count of alphabets which are misplaced is 2.
input1 = "tbGB" input2 = "tGBb" here 'G', 'B', 'b' are misplaced in input2, so the
count of alphabets which are misplaced is 3.
Expected output format : <Increasing or Decreasing>:count of alphabets which are misplaced is input2.

Example 1:
----------
input1 = "ACZa"
input2 = "CAZa"
output = Increasing:2

Example 2:
----------
input1 = "tbGB"
input2 = "tGBb"
output = Decreasing:3

Example 3:
----------
input1 = "ILkQwfg"
input2 = "QwILkfg"
output = Invalid
Explanation: The alphabets in input1 are not in either increasing or decreasing
order

Note:
1. input1 and input2 will be of same length.
2. input1 and input2 will contain unique alphabets in them.
3. 'B' and 'b' are considered as different alphabets because there ascii values
    are different.
FindTheOrder_Wipro.txt
Displaying FindTheOrder_Wipro.txt.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LettersCount {
	
	public static String printOrder(String inp1) {
		String order;
		char charArr[] = inp1.toCharArray();
		Arrays.sort(charArr);
		String str = "";
		
		for(char val: charArr) {
			str = str + val;
		}
		String revStr = "";
		for(int i=str.length() - 1;i>=0;i--) {
			revStr = revStr + str.charAt(i);
		}
		if(str.equals(inp1)) {
			order = "increasing";
		} else if(revStr.equals(inp1)) {
			order = "decreasing";
		} else {
			order = "invalid";
		}
		return order;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp1 = sc.nextLine();
		String inp2 = sc.nextLine();
		int count = 0;
		
		String order = printOrder(inp1);
		
		
		if(inp1.length() == inp2.length()) {
			for(int i=0;i<inp1.length();i++) {
				if(inp1.charAt(i) != inp2.charAt(i)) {
					count = count + 1;
				}
			}
		} 
		if(order == "increasing" || order == "decreasing") {
			System.out.println(order + ":" + count);
		} else {
			System.out.println(order);
		}
	}
}
