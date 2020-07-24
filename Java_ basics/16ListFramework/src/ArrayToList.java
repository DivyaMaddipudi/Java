import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToList {
	
	public static void main(String[] args) {
		String[] days =  {"sunday", "monday", "tuesday", "wednesday", "thrusday", "friday", "saturday"};
		
		ArrayList<String> daysList = new ArrayList(Arrays.asList(days));
		for(String day: daysList) {
			if(day.equals("sunday")) {
				System.out.println(day.toUpperCase());
			} else {
				System.out.println(day);
			}
		}
		System.out.println((daysList));
	}

}
