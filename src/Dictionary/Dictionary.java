package Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
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
}
