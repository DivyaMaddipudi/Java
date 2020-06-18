import java.util.Scanner;

public class ArrayRotation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases > 0) {
			
		
		int size = sc.nextInt();
		
		int rot = sc.nextInt();
		
		int[] arr = new int[size];
		
		if(rot > size) {
			rot = rot%size;
			
		}
		System.out.println(rot);
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
			
		}
		
		
		
		for(int j=0;j<rot;j++) {
	
		int len = arr.length - 1;
		
		int temp = arr[len];
		
		for(int i= len;i>0;i--) {
			
			arr[i] = arr[i-1];
			
		}
		arr[0] = temp;
		
	}
		
		for(int i1=0;i1<size;i1++) {
			System.out.print(arr[i1] + " ");
			
		}
		testCases --;
		}
		
	}

}


