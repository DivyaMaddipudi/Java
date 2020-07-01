import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

     static long arrayManipulation(int n, int[][] queries) {

        int[] array = new int[n+1];
        int a = 0;
        int b = 0;
        int value = 0;

        
        for(int i=0;i<queries.length;i++) {
            a = queries[i][0] - 1;
            b = queries[i][1] - 1;
            value = queries[i][2];
            
            array[a] += value; 
             
            array[b+1] -= value; 
        }
        long sum = 0, res = Integer.MIN_VALUE; 
        for (int i = 0; i < n; ++i) 
        { 
            sum += array[i]; 
            res = Math.max(res, sum); 
        } 
        return res; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {

                queries[i][j] = sc.nextInt();
            }
        }
        long result = arrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }
}
