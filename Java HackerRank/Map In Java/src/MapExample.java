import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

	static String CountStr(String[] inputArr) {
		Map<String, Integer> countStr =  new TreeMap<String, Integer>();
		
		for(String input: inputArr) {
			countStr.put(input, input.length());
		}
		return (Arrays.toString(countStr.entrySet().toArray()));
	}
	public static void main(String[] args) {
	  
		String output = CountStr(new String[] {"a", "bb", "bb", "a"});
		System.out.println(output);

	}

}
