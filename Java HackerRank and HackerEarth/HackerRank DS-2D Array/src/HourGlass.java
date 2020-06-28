/*
 * 
 * input:
 * 		1 1 1 0 0 0
		0 1 0 0 0 0
		1 1 1 0 0 0
		0 0 2 4 4 0
		0 0 0 2 0 0
		0 0 1 2 4 0
		
		-----------
		explaination:
		
		2 4 4
		  2
		1 2 4
		
		sum of all these values is 19 and it is the max value
		
	output:
		19
		
 */
import java.util.Scanner;
public class HourGlass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[6][6];
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int sum;
		int maxsum = Integer.MIN_VALUE; //since, -ve values can also results
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				sum = 0;
				sum += arr[i][j];
				sum += arr[i][j+1];
				sum += arr[i][j+2];
				
				sum += arr[i+1][j+1];
				
				sum += arr[i+2][j];
				sum += arr[i+2][j+1];
				sum += arr[i+2][j+2];
				
				if(maxsum < sum) {
					maxsum = sum;
				}
			}
		}
		System.out.println(maxsum);
	}

}
