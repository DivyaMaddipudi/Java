import java.io.*;
import java.util.*;

public class StringsIntro {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int lenA = A.length();
        int lenB = B.length();
        int len = lenA + lenB; 
        System.out.println(len);
        
        if(A.compareTo(B)<=0) {
            System.out.println("No");
        } else if(A.compareTo(B) > 0) {
            System.out.println("Yes");
        }

        String a = A.substring(0, 1).toUpperCase() + A.substring(1);

        String b = B.substring(0, 1).toUpperCase() + B.substring(1);

        System.out.println(a + " " + b);
    }
}


