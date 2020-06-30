/*
 * 
 * input:
 * 		1(number of test cases)
 * 		5(N) 1(M)
 * 		1 4 3 2 5
 * output: 
 * 		4
 * 	
 * M is 1 and N is 5 so you have to calculate maximum and minimum sum using (5-1 =) 4 elements.
	Maximum sum using the 4 elements would be (2+3+4+5=)14.
	Minimum sum using the 4 elements would be (1+2+3+4=)10.
	Difference will be 14-10=4.


 */
import java.util.*;

class SumDifference {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();

        while(testCases != 0) {
            int N = s.nextInt();
            int M = s.nextInt();

            int[] array = new int[N];
            for(int i=0;i<N;i++){
                array[i] = s.nextInt();
            }
            int numberOfDigits = N - M;
            Arrays.sort(array);
            int maxSum = 0;
            int minSum = 0;
            for(int i=0;i<numberOfDigits;i++) {
                minSum = minSum + array[i];
            }
            for(int i=N-1;i>=N-numberOfDigits;i--) {
            	maxSum = maxSum + array[i];
            }
            int sum = maxSum - minSum;
            System.out.println(sum);
            testCases--;
        }
    }
}

