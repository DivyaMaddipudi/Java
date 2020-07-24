/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.
	
	Find all the elements that appear twice in this array.
	
	Could you do it without extra space and in O(n) runtime?
	
	Example:
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[2,3]

 */
package divya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static List<Integer> findDuplicates(int[] nums) {
		
		int max = 0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		System.out.println(max);
		
        int[] duplicates = new int[max + 1];
        
        List<Integer> dupList = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++) {
        	
            duplicates[nums[i]]++;
            
        }
        
        for(int i=0;i<duplicates.length;i++) {
            if(duplicates[i] > 1) {
                dupList.add(i);
            }
        }
        return dupList;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		
		List<Integer> lis = findDuplicates(arr);
		System.out.println(lis);
		
	}
}
