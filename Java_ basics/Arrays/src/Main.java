import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int[] values;
		
		values = new int[3];
		
		for(int i=0; i<values.length; i++)
		{
			Scanner input = new Scanner(System.in);
			values[i] = input.nextInt();
		}

		for(int i=0; i<values.length; i++)
		{
			System.out.println(values[i]);
		}
	}

}
