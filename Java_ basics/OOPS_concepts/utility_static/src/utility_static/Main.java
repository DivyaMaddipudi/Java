package utility_static;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyDateUtil {
	
	static final String TARGET_DATE_PATTERN = "mm/dd/yyyy";
	
	public static String getFormatedDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat(TARGET_DATE_PATTERN);
		return sdf.format(d);
	}
}

public class Main {

	public static void main(String[] args) {
		
		
		Date now = new Date();
		System.out.println(now);
		
		String formatedDate = MyDateUtil.getFormatedDate(now);
		System.out.println(formatedDate);
		

	}

}
