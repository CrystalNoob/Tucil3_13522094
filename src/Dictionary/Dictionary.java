package Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
	public static Set<String> Wordset(String wordsFile) {
		Set<String> wordset = new HashSet<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(wordsFile))) {
			String word;
			while ((word = reader.readLine()) != null) {
				wordset.add(word.trim().toLowerCase());
			}
		} catch(IOException e) {
			System.err.println("Error while reading file: " + e.getMessage());
		}
		return wordset;
	}

	public static List<String> getNeighbors(String word, Set<String> wordSet) {
		List<String> neighbors = new ArrayList<>();
		char[] charsOfWord = word.toCharArray();
		for(int i = 0; i < charsOfWord.length; i++) {
			char originalChar = charsOfWord[i];
			for(char c = 'a'; c <= 'z'; c++) {
				charsOfWord[i] = c;
				String newWord = new String(charsOfWord);
				if(wordSet.contains(newWord) && !newWord.equals(word)) {
					neighbors.add(newWord);
				}
			}
			charsOfWord[i] = originalChar;
		}
		return neighbors;
	}
}
