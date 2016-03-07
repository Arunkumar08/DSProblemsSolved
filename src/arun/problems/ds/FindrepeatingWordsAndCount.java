package arun.problems.ds;

import java.util.HashMap;
import java.util.Map;

public class FindrepeatingWordsAndCount {

	public static void main(String a[]) {
	
		String input = "How many How is in this senentence, How will you find it";
		if(input != null
				&& !input.equals("")) {
			String[] wordArray = input.split(" ");
			Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
			for(String word : wordArray) {
				Integer count = wordCountMap.get(word);
				if (count != null) {
					count = count + 1;
				} else {
					count = 1;
				}
				wordCountMap.put(word, count);
			}
			System.out.println(wordCountMap);
		}
	}
}
