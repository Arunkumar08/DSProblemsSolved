package arun.problems.ds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MaxAndMinRepeatedWordsInListOfFiles {

	public void printMaxAndMinRepeatedWordsInTheFiles(final List<File> files) throws IOException {
		Integer maxCount = 0;
		Integer minCount = 1;
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		for(final File file : files) {
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				String[] strArray = line.split(" ");
				for (final String str : strArray) {
					Integer countForStr = wordsMap.get(str);
					if (countForStr == null) {
						countForStr = 0;
					}
					wordsMap.put(str, countForStr++);
					if (countForStr > maxCount)
						maxCount = countForStr;
					if(minCount > countForStr)
						minCount = countForStr;
				}
	        }
			fReader.close();
			bReader.close();
		}
		List<String> maxWords = new ArrayList<String>();
		List<String> minWords = new ArrayList<String>();
		for (final Entry<String, Integer> entry : wordsMap.entrySet()) {
			System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
			if (entry.getValue() == maxCount) {
				maxWords.add(entry.getKey());
			}
			if (entry.getValue() == minCount) {
				minWords.add(entry.getKey());
			}
		}
		System.out.println("Maximum repeated words:");
		for(String str : maxWords) {
			System.out.println(str);
		}
		System.out.println("Minimum repeated words:");
		for(String str : minWords) {
			System.out.println(str);
		}
	}
}
