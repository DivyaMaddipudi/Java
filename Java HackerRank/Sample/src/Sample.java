import java.util.*; 

class Sample { 
	
	public static void main (String[] args) { 
	{ 
		
		int arr[] = {2, 4, 5, 10, 10, 90, 2, 10, 2}; 
		int n = arr.length; 
		
		
		Arrays.sort(arr); 
		 
		int max_count = 1, res = arr[0]; 
		int curr_count = 1; 
		
		for (int i = 1; i < n; i++) 
		{ 
			if (arr[i] == arr[i - 1]) 
				curr_count++; 
			else
			{ 
				if (curr_count > max_count) 
				{ 
					max_count = curr_count; 
					res = arr[i - 1]; 
				} 
				curr_count = 1; 
			} 
		} 
	
		 
		if (curr_count > max_count) 
		{ 
			max_count = curr_count; 
			res = arr[n - 1]; 
		} 
	
		System.out.println(res + " appeared " + max_count + " times ");
	} 
	
	} 
} 
