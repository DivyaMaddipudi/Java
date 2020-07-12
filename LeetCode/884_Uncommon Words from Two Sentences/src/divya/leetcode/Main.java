package divya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



class Main {


	public String[] uncommonFromSentences(String A, String B) {
		
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word: A.split(" ")) 
			map.put(word, map.getOrDefault(word, 0) + 1);

		for(String word: B.split(" ")) 
			map.put(word, map.getOrDefault(word, 0) + 1);
		
		List ans = new ArrayList();
        for (String word: map.keySet())
            if (map.get(word) == 1)
                ans.add(word);
        
        String[] arr = new String[ans.size()];
        arr = (String[]) ans.toArray(arr);
        
        
        
        return arr;
		

	}

	public static void main(String[] args) {
		String A = "this apple is sour";
		String B = "this apple is";

		System.out.println(new Main().uncommonFromSentences(A, B));

	}

}