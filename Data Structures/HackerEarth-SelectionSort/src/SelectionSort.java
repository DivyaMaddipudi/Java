import java.util.*;

class SelectionSort {
	public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		int min;
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}



			for(int i=0;i<size;i++) {
				min = i;	
				for(int j=i+1;j<size;j++) {
					if(arr[j] < arr[min]) {

						min = j;

					}
				}
					int temp = arr[i];
					arr[i] = arr[min];
					arr[min] = temp;

		}

		for(int i=0;i<size;i++) {
			System.out.print(arr[i] +" ");
		}
	}
}
