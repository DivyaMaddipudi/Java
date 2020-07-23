import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Fix the Formula:
---------------
Kely has been tricked by her brother to answer a question with a number. She is perplexed. 
Here is the question "Fo+23the3*like2+" it took time for her to understand. Now she wants
to automate it with a program so that any time her brother comes with such tricky String 
She could answer with lesser efforts. 

Here is what we have to do, separate the math operators and the digits. 
Like in the above String you can see the operators (+, *, +) and digits (2, 3, 3, 2). 
Rest all characters are ignored. 

Now arrange the digits and operators in the order of the appearance to get the correct 
result. 
2+3*3+2 to be solved as 
(2+3) = 5 
Then, (5*3) = 15 
Then, (15+2) =17 
So for the given String "Fo+23the3*like2+" final answer is 17 

Help Kely by writing a program to solve the above given problem.  
Prototype: public int fixTheFormula(String input1) 

Assumptions:
-----------
1. Numbers present in the String are always considered as single digits (0-9)
2. Only operators used in the String are (+, *, -)
3. Always we will have length +1 numbers to operators (In the above example 3 operators and 4 numbers).

----------------------------------------------------------------------------------------
Sample Input/Output-1:
----------------------
input1= we8+you2-7to/*32
output= 2 

Explanation: Here the operators are [+, -, /, *] and the numbers are [8, 2, 7, 3, 2] 
Thus we would be getting 8+2 => 10-7 => 3/3 => 1*2 => 2
Final answer is 2. 
----------------------------------------------------------------------------------------
Sample Input/Output-2: 
----------------------
input1= i*-t5s-t8h1e4birds
output= 35 
Explanation: Here the operators are [*, -, -] and the numbers are [5, 8, 1, 4] 
Thus we would be getting 5*8 => 40-1 => 39-4 => 35 
Final answer is 35. 
----------------------------------------------------------------------------------------
*/

public class FixFormula {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ArrayList<String> operators = new ArrayList<>();
		ArrayList<String> numbers = new ArrayList<>();
		String val;
		
		for(int i=0;i<str.length();i++) {
			
			val = "";
			if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'  ) {
				 val = val + str.charAt(i);
				 operators.add(val);
				 
			} else if((int) str.charAt(i) >= 48 && (int) str.charAt(i) < 58) {
				val = val + str.charAt(i);
				numbers.add(val);
			}
		}
		
		int sum = 0;
		String operator = operators.get(0);
		
		switch(operator) {
		case "+":
			sum = Integer.parseInt(numbers.get(0)) + Integer.parseInt(numbers.get(1));
			break;
		case "-":
			sum = Integer.parseInt(numbers.get(0)) - Integer.parseInt(numbers.get(1));
			break;
		case "*":
			sum = Integer.parseInt(numbers.get(0)) * Integer.parseInt(numbers.get(1));
			break;
		case "/":
			sum = Integer.parseInt(numbers.get(0)) / Integer.parseInt(numbers.get(1));
			break;
		}
		
		for(int i=1;i<operators.size();i++) {
		
			switch(operators.get(i)) {
			case "+":
				sum = sum + Integer.parseInt(numbers.get(i+1));
				break;
			case "-":
				sum = sum - Integer.parseInt(numbers.get(i+1));
				break;
			case "*":
				sum = sum * Integer.parseInt(numbers.get(i+1));
				break;
			case "/":
				sum = sum / Integer.parseInt(numbers.get(i+1));
				break;
			default: 
				break;
			}
		}
		System.out.println(sum);
	}

}
