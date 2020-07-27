/*
 * Navi is a famous shopkeeper in his locality. He gives discounts to his regular customers. Some new rules have been made due to which 
 * he is in trouble. According to the new rules, any shopkeeper can sale his items to only one customer in a day. But every customer has some 
 * issues like the total money they have or the total weight they can handle at a time or number of items they are interested in. 
 * Navi’s friend has decided to help Navi and he promised him that he will purchase items from his shop daily and try to maximize his sale in
 * terms of total price with satisfying the count of items and weight of the items . He will give his requirements as Wmax 
 * (maximum weight he can carry) and C (maximum count of the items he can carry). 
 * Now Navi is interested in knowing the total price of the items he can sell.

	Input
	First line of input will contain D (total number of days). Then for each day first line will contain N (Number of items) . 
	Next each N lines will contains two integers P (price of ith item on that day) and W(weight of ith item on that day) separated by a space. 
	Last line for the input of the particular day will contain Wmax and C separated by a space.

	Output
	For each day output “For Day #day_number:” then in next line print the maximum total price. 
	If his friend is not able to purchase any of the item then print -1.

	input
3
3
10 20
20 30
30 40
50 2

1
4
10 20
20 30
30 30
40 30
90 3


	output
	For Day #1:
	30

 */
package divya.codearena;

import java.util.Scanner;

public class Main {
	public static int subArrays(int[] weight, int k, int maxWeight) {
		int n = weight.length;

		int index = 0;
		for (int i = 0; i < n - k + 1; i++) 
		{ 

			int current_sum = 0; 

			for (int j = 0; j < k; j++) {
				current_sum = current_sum + weight[i + j]; 
				if(current_sum == maxWeight) {
					index = i;
				}
			}
		}
		return index;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();

		for(int i=1;i<=days;i++) {
			int numOfItems = sc.nextInt();
			if(numOfItems == 0) {
				System.out.println("For Day #" +i+":");
				System.out.println("-1");
			} else {

			int[] price = new int[numOfItems];
			int[] weight = new int[numOfItems];

			for(int j=0;j<numOfItems;j++) {
				price[j] = sc.nextInt();
				weight[j] = sc.nextInt();
			}
			
			int maxWeight = sc.nextInt();
			int itemsCount = sc.nextInt();

			int index = subArrays(weight, itemsCount, maxWeight);
			System.out.println(index);

				int cost = 0;
				
				while(itemsCount != 0) {
					cost = cost + price[index];
					index ++;
					itemsCount--;
				}
				System.out.println("For Day #" +i+":");
				System.out.println(cost);
			}

		}

	}

}
