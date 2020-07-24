
import java.util.ArrayList;
import java.util.Arrays;

public class LambdaExpressions {
	
	public static void main(String[] args) {
		String[] days =  {"sunday", "monday", "tuesday", "wednesday", "thrusday", "friday", "saturday"};
		
		ArrayList<String> daysList = new ArrayList(Arrays.asList(days));
		
		// Unaryoperator lambda type
		daysList.replaceAll(s  -> s.toUpperCase());
		
		System.out.println(daysList);
		
		// Predicate lambda type
		daysList.removeIf(s -> s.equals("SUNDAY"));
		
		System.out.println(daysList);
	
	}

}

