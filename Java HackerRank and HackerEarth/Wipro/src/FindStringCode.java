import java.util.Scanner;

/*
 * FindStringCode
 * 
 * STEP1. In each word, find the Sum of the 
 * Difference between the first letter and the last letter, second letter and 
 * the penultimate letter, and so on till the centre of the word. 
 * STEP2. Concatenate the sums of each word to form the result.
 * 
 * For example:- 
 * If the given string is "WORLD WIDE WEB". 
 * STEP1. In each word, find the Sum of the Difference 
 * between the first letter and the last letter, second letter and 
 * the penultimate letter, and so on till the centre of the word. 
 * WORLD = [W-D]+[O-L]+[R] = [23-4]+[15-12]+[18] = [19]+[3]+[18] = [40] 
 * WIDE = [W-E]+[I-D] = [23-5]+[9-4]= [18]+[5] =[23] 
 * WEB = [W-B]+[E] = [23-2]+[5]=[21]+[5] = [26]
 * 
 * STEP2. Concatenate the sums of each word to form the result 
 * [40][23][26]
 * [402326] 
 * The answer (output) should be the number 402326.
 * 
 * NOTE1: The value of each letter is its position in the English 
 * alphabet system i.e. a=A=1, b=B=2, c=C=3, and so on till z=Z=26. 
 * So, the result will be the same for "WORLD WIDE WEB" or 
 * "World Wide Web" or "world wide web, or any other 
 * combination of uppercase a. lowercase letters.
 * 
 * IMPORTANT Note: In Step1, after subtracting the 
 * alphabets, we should use the absolute values for 
 * calculating the sum. For instance, in the below example,
 * both [H-O] and [E-L] result in negative number -7, but the 
 * positive number 7 (absolute value of -7) is used for 
 * calculating the sum of the differences.
 * Hello = [H-O]+[E-L]+[L] = [8-15]+[5-12]+[12] = [7]+[7]+[12] = [26]
 * 
 * Assumptions: The given string (sentence) will contain only 
 * alphabet characters and there will be only one space 
 * character between any two consecutive words.
 * 
 * You are expected to write a function that 
 * takes a string (sentence) as input, performs the above 
 * mentioned processing on the sentence and returns the
 * result (number).
 * 
 * Example1: 
 * input1 = "World Wide Web" 
 * output1 = 402326
 * 
 * Example2: 
 * input1 = "Hello World" 
 * output1 = 2640 
 * Explanation: 
 * Hello = [H-O]+[E-L]+[L] = [8-15]+[5-12]+[12] = [7]+[7]+[12] = [26] 
 * WORLD = [W-D]+[O-L]+[R] = [23-4]+[15-12]+[18] = [19]+[3]+[18] = [40] 
 * Result = Number formed by concatenating [26] and [40] = 2640
 */

public class FindStringCode {
	public static int asciiValue(char ch) {
		int value = (int)(ch) - 64;
		return value;
		
	}
	public static int difference(String val) {
		int difference = 0;
		int len = val.length();
		if(len%2 == 0) {
			for(int i=0;i<len/2;i++) {
				difference = difference + Math.abs((asciiValue(val.charAt(i)) - asciiValue(val.charAt(len - i - 1))));
			}
		} else {
			for(int i=0;i<len/2;i++) {
				difference = difference + Math.abs((asciiValue(val.charAt(i)) - asciiValue(val.charAt(len - i - 1))));
			}	
			difference = difference + asciiValue(val.charAt(len/2));
		}
		return difference;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String str1 = str.toUpperCase();
		
		String[] st = str1.split(" ");

		String stringSum = "";
		for(String val:st) {
			stringSum = stringSum + difference(val);
		}
		int finalValue = Integer.parseInt(stringSum);
		System.out.println(finalValue);
	}

}
