import java.util.Scanner;

public class Count {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val = 0;
		int sum = 0;
		String data = String.valueOf(val);
		while((data = sc.nextLine()).length()>0) {
			String[] arrdata = data.split(",");
			if(arrdata.length > 0) {
				for(int i=0;i<arrdata.length;i++) { 
					
					sum = sum + Integer.parseInt(arrdata[i]);
					
				}
				
				System.out.println(sum);
			}
			else {
				System.exit(-1);
			}
		}
		
	}

}
