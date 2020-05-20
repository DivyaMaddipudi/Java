import java.util.Scanner;

public class CreatePin {
	public int generatePin(int input1, int input2, int input3) {
		String i1 = Integer.toString(input1);
		String i2 = Integer.toString(input2);
		String i3 = Integer.toString(input3);
       
		char max = '0';
		StringBuilder strMin 
        = new StringBuilder(); 
		
		StringBuilder strMax 
        = new StringBuilder(); 

		for(int i=0;i<i1.length();i++) {
			
			if(i1.charAt(i)>i2.charAt(i)) {
				strMin.append(i2.charAt(i));
			} else if(i1.charAt(i)>i3.charAt(i)) {
				strMin.append(i3.charAt(i));
			}  else {
				strMin.append(i1.charAt(i));
			}
		}
		
		for(int i=0;i<i1.length();i++) {
			
			if(i1.charAt(i)<i2.charAt(i)) {
				strMax.append(i2.charAt(i));
			} else if(i1.charAt(i)<i3.charAt(i)) {
				strMax.append(i3.charAt(i));
			}  else {
				strMax.append(i1.charAt(i));
			}
		}
	
		for(int i=0;i<i1.length();i++) {
			if(strMax.charAt(i)>max) {
				max = strMax.charAt(i);
			}
		}
		
		
		//System.out.println(strMax.toString());
		int key = Integer.parseInt(max+strMin.toString());
		return key;
		
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		int input3 = sc.nextInt();
		CreatePin pin = new CreatePin();
		System.out.println(pin.generatePin(input1, input2, input3));
		
		
	}

}




//123
//582
//175

//8122