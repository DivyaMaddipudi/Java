import java.util.*;
class BubbleSort {
	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] array = new int[size];
		for(int i=0;i<size;i++) {
			array[i] = s.nextInt();
		}
		int count = 0;
		for(int k=0;k<size-1;k++) {
			for(int i=0;i<size-k-1;i++) {
				if(array[i] > array[i+1]) {
					System.out.println(array[i+1]);
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
