/*
 * 
 * input:
 * 		5 2
 * 		1 2 3 4 5
 * output:
 * 		3 4 5 1 2
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int d = scanner.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            
            a[i] = scanner.nextInt();
        }
        
        for(int j=1;j<=d;j++) {
            int temp = a[0];
            for(int i=0;i<n-1;i++) {

                a[i] = a[i+1];

            }
            a[n-1] = temp;
        }

        for(int i=0;i<n;i++) {
            System.out.print(a[i]+" ");
        }

        scanner.close();
    }
}
