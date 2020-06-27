/*
 * Array Rotation ------ Rotates Array N given times
 * 
 * ex:
 *  input:   1 2 3 4 5 and 2 times(right rotation)
 * 	output:  4 5 1 2 3	
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayRotation {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
        //BufferedReader
     
        BufferedReader sc = new 
        BufferedReader(new InputStreamReader(System.in));
        

        int testCases = Integer.parseInt(sc.readLine());

		while(testCases > 0) {	
		
		String s[]=sc.readLine().split(" "); 
		
		int size =Integer.parseInt(s[0]);

		int rot =Integer.parseInt(s[1]);
		
		rot = rot%size;	
		
		int[] arr = new int[size];
		
		
		String line = sc.readLine(); 
		String[] strs = line.trim().split("\\s+");
		for (int i = 0; i < size; i++) {
		    arr[i]  = Integer.parseInt(strs[i]);
		}


		while(rot > 0) {	
		int temp = arr[size - 1];
		
		for(int i= size - 1;i>0;i--) {
			
			arr[i] = arr[i-1];
			
		}
		arr[0] = temp;
        rot--;
		
	}
		
		for(int i1=0;i1<size;i1++) {
			System.out.print(arr[i1] + " ");
		}
		System.out.println();
		testCases --;
		}
		
	}

}



