/*
 *Explaination:
 *			Strings = ["ab", "ab", "abc"]
 *			queries = ["ab", "a", "abx"]
 *			count the number of times elements of queries present in strings.
 *			ab - 2, a - 0, abx - 0
 * input:
 * 		
 * 		4 (Strings size) 
 * 		ab 
 * 		ab
 * 		abc
 * 		4 (queries size)
 * 		ab
 * 		a
 * 		abx
 * 
 * output: 
 * 		2
 * 		0
 * 		1
 * 
 * 
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpareArray {

    static void matchingStrings(String[] strings, String[] queries) {
        int lenq = queries.length;
        int lens = strings.length;
        int[] arr = new int[lenq];
        
        int count;
        for(int i=0;i<lenq;i++) {
        	count = 0;
            for(int j=0;j<lens;j++) {
                if(queries[i].equals(strings[j])) {
                    count = count + 1;
                }
                arr[i] = count;
                
            }
        }

        for(int i=1;i<lenq;i++) {
        	 System.out.println(arr[i]);
        }
        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int stringsCount = scanner.nextInt();
        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            strings[i] = scanner.nextLine();
        }

        int queriesCount = scanner.nextInt();
        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            
            queries[i] = scanner.nextLine();;
        }

        matchingStrings(strings, queries);

        scanner.close();
    }
}
