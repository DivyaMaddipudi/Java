import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {

	static Map<String, Integer> CountStr(String[] inputArr) {
		Map<String, Integer> countStr =  new TreeMap<String, Integer>();
		
		for(String input: inputArr) {
			countStr.put(input, input.length());
		}
		//return (Arrays.toString(countStr.entrySet().toArray()));
	    return countStr;
	}
	public static void main(String[] args) { 
	  
		Map<String, Integer> output = CountStr(new String[] {"a", "bb", "bb", "a"});
		System.out.println(output);
		
	}
}


