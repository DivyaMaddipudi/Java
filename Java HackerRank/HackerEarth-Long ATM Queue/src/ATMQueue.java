/*
 * 
 *  Input format:
	The first line of input contains one positive integer N. 
	The second line contains N space-separated integers arr[i] denoting the height of i-th person. 
	Each group has group members standing in increasing order of their height.
	
	ip:
	4
	1 2 3 4
	op:
	1
	
	Output format:
	Print the minimum number of groups that are at least present in the queue?
 */

import java.util.*;
class ATMQueue{
public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=1;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]>arr[i+1])
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
