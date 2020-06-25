import java.util.*; 

class Sample { 
	
	public static void main (String[] args) { 		

		int arr[] = {2, 4, 5, 10, 10, 90, 2, 10, 2, 2}; 
		int n = arr.length; 
		Arrays.sort(arr); 
		
		int largest = 0;
		int k = 0;
		
		for (int i = 0; i < n; i++) 
		{ 
			int count = 1;
			for (int j = i + 1; j < n; j++) {
		        if (arr[i] == arr[j]) {
		            count++;
		        }
		    }
			if (count > largest) {
		        k = arr[i];
		        largest = count;
		    }
		}
		System.out.println(k + " " + largest);
	} 
} 
