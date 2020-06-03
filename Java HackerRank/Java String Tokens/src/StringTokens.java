import java.io.*;
import java.util.*;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\Z");

        String s = scan.next().trim();
        // Write your code here.
        
        if(s.length() > 0){
            
        String[] str = s.split("[!,?._'@\\s]+");        
        int len = str.length;
        System.out.println(len);
        
        for(int i=0;i<len;i++) {
            System.out.println(str[i]);
        }
    } else {
            System.out.println(0);
        }
        scan.close();
    }
}

