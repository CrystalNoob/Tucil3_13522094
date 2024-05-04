package CLI;

import java.util.List;
import java.util.Set;
import Algorithms.Astar;
import Algorithms.GBFS;
import Algorithms.UCS;
import Dictionary.Dictionary;

public class CLI {
	public void start(String[] args) throws Exception {
		String algorithm = args[0].toLowerCase();
        String filePath = args[1];
		String startWord = args[2].toLowerCase();
		String endWord = args[3].toLowerCase();
        Set<String> dictionary = Dictionary.Wordset(filePath);

		if (startWord.length() != endWord.length()) {
			throw new Exception("Start word and end word's length are different!");
		}

		List<String> path;
		long startTime, endTime;

		startTime = System.nanoTime();

		switch (algorithm) {
		case "astar":
			path = Astar.findPath(startWord, endWord, dictionary);
			break;
		case "ucs":
			path = UCS.findPath(startWord, endWord, dictionary);
			break;
        case "gbfs":
            path = GBFS.findPath(startWord, endWord, dictionary);
            break;
		default:
			throw new Exception("Invalid algorithm name");
		}

		endTime = System.nanoTime();

        if (path != null) {
            System.out.println("Shortest path from " + startWord + " to " + endWord + ": " + path);
        } else {
            System.out.println("No path found from " + startWord + " to " + endWord);
        }
		System.out.println("Time Elapsed: "+ (endTime - startTime)/1000000 + " ms");
	}
}
