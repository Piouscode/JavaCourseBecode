package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class $5_CountingWords {
public static void main(String[] args) {
	String filePath = "src/$5_CountingWords.txt";
	Map<String, Integer> wordCount_Map = new HashMap<>();

	String mostFrequentWord = null;
	int maxWordCount = 0;

	try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		String line;
		while ((line = reader.readLine()) != null) {
			String[] multipleWords = line.split("\\s+");
			for (String singleWord : multipleWords) {
				if (wordCount_Map.containsKey(singleWord)) {
					int count = wordCount_Map.get(singleWord);
					wordCount_Map.put(singleWord, count + 1);
				} else {
					wordCount_Map.put(singleWord, 1);
				}
				// Update most used word
				if (wordCount_Map.get(singleWord) > maxWordCount) {
					mostFrequentWord = singleWord;
					maxWordCount = wordCount_Map.get(singleWord);
				}
			}
		}
	} catch (IOException e) {
		System.out.println("Error reading file: " + e.getMessage());
	}

	System.out.println("Word count overview:");

	for (String word : wordCount_Map.keySet()) {
		int count = wordCount_Map.get(word);
		System.out.println(word + ": " + "Count:" + " " + count);
	}

	System.out.println("Most used word: " + mostFrequentWord + " (" + maxWordCount + " times)");
}
}


