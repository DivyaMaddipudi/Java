import java.io.*;
import java.util.*;

public class StringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String A1 = A.toLowerCase();
        String B = "";
        int len = A1.length();
        for(int i=len-1;i>=0;i--) {
            B = B + A1.charAt(i);
        }
        if(A1.equals(B)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
            
        }
        
    }
}



