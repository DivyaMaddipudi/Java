import java.util.Calendar;
import java.util.Scanner;


public class DayOfTheWeek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int month = sc.nextInt();
		
		int date = sc.nextInt();
		
		int year = sc.nextInt();
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, date );
		cal.set(Calendar.YEAR, year);
		
		String[] weeks = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY",
		                  "SATURDAY"};
		
		System.out.println(weeks[cal.get(Calendar.DAY_OF_WEEK)-1]);
		

	}

}
