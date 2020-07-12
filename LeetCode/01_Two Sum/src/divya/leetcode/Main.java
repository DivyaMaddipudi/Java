/*
 *  Given an array of integers, return indices of the two numbers such that 
 *  they add up to a specific target.
 *  
 *  
 *  You may assume that each input would have exactly one solution, 
 *  and you may not use the same element twice.
 *  
 *  Example:
 *  
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 * 	return [0, 1].
 * 
 * 
 */
package divya.leetcode;

import java.util.Arrays;
class Main {
    public int[] twoSum(int[] nums, int target) {
        int x = 0;
        int y = 0;
        
        for(int i=0;i<nums.length -1;i++) {
         
            for(int j=i+1;j<nums.length;j++) {
                
                if(nums[i] + nums[j] == target) { 
                    
                    x = i;
                    y = j;
                }
            }
        }
        return new int[] {x, y};
    }
    
    public static void main(String[] args) {
    	int[] nums = {2, 7, 11, 15};
    	int target = 9;
    	
    	int[] ret = new Main().twoSum(nums, target);
    	System.out.println(Arrays.toString(ret));
    	
    }
}