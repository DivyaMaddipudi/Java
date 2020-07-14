package divya.leetcode;

import java.util.Scanner;

class Main {
    public int reverse(int x) {
        int rev=0;
        int rem=0;
        int prev=0;
        boolean negativeFlag = false;
        if(x < 0) {
            
            negativeFlag = true; 
            x = -x ; 

        }
        while(x != 0) {
            rem = x%10;
            rev = rev*10 + rem;
            if ((rev - rem)/10 != prev) 
            {  
                return 0; 
            } 
                prev = rev;
                x = x/10;
        }
        return (negativeFlag == true)? -rev : rev; 
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int val = sc.nextInt();
    	System.out.println(new Main().reverse(val));
    }
}