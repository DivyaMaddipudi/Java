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
	1
	3
	10 20
	20 30
	30 40
	50 2
	
	output
	For Day #1:
	30

 */
package divya.codearena;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();
		int numOfItems = sc.nextInt();
		
		int[] price = new int[numOfItems];
		int[] weight = new int[numOfItems];
		for(int i=0;i<numOfItems;i++) {
			price[i] = sc.nextInt();
			weight[i] = sc.nextInt();
		}
		
		int maxWeight = sc.nextInt();
		int itemsCount = sc.nextInt();
		
		int res = 0;
        for (int i=0; i<itemsCount; i++) 
        	res += weight[i]; 
        
        int index = 0;
        int currSum = res;
		for(int i=itemsCount;i<numOfItems;i++) {
			currSum += weight[i] - weight[i-itemsCount]; 
	           if(currSum == maxWeight) {
	        	   index = i;
	           }
		}
		int cost = 0;
		for(int i=index;i<itemsCount;i++) {
			cost = cost + price[i];
		}
		System.out.println(cost);
	}

}
