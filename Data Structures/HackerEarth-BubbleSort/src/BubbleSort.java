/*
 * Count number of swaps in an array.
 */
import java.util.*;

class BubbleSort {

    public static int bubblesort(int[] arr) {
        int count = 0;
        int len = arr.length;

        boolean swap = true;
        
        while(swap != false) {
            count = count + 1;
            swap = false;

            for(int i=0;i<(len - 1);i++) {
                if(arr[i]>arr[i+1]) {     
                int temp;
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                swap = true;
                }
            }
        }
        return count;
    }

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(bubblesort(arr));
        
    }
}
