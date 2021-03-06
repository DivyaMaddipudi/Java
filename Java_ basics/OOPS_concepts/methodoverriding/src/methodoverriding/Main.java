package methodoverriding;

class Searching {
	
	public int search(int a[], int ele) {
	
		// return search(a, ele, 0); --> redundant code
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == ele) {
				return i;
			}
		}
			return -1;
	}

	public int search(int a[], int ele, int pos) {
		for(int i = pos; i < a.length; i++) {
			if(a[i] == ele) {
				return i;
			}
		}
			return -1;
	}
	
	
}

public class Main {

	public static void main(String[] args) {
		int a[] = {10, 20, 30, 40, 30, 60};
		int ele = 30;
		
		Searching obj = new Searching();
		
		int x = obj.search(a, ele);
		int y = obj.search(a, ele, 3);
		
		System.out.println("x is " + x);
		System.out.println("y is " + y);
	}
}
