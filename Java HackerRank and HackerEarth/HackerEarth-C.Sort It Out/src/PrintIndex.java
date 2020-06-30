import java.util.*;

class PrintIndex {
	public static void check(int val, int[] copy) {
		//System.out.println("copy" + Arrays.toString(copy));
		for(int i=0;i<copy.length;i++) {
			if(val == copy[i]) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] array = new int[size];

		for(int i=0;i<size;i++) {
			array[i] = s.nextInt();
		}
		
		int[] copy = Arrays.copyOf(array, array.length);
		
		
		Arrays.sort(array);
		
		//System.out.println(Arrays.toString(array));
		for(int val: array) {
			 check(val, copy);
		}

	}
}
