package Algorithms;

// import java.util.Arrays;

public class Heuristic {
	public static int heuristic(String start, String goal) {
		int distance = 0;
		for(int i = 0; i < start.length(); i++) {
			if(start.charAt(i) != goal.charAt(i)) {
				distance++;
			}
		}
		return distance;
	}
	/*
		Default cost of substitution, 0 is it's the same character, 1 if it's different character, used by Levenshtein distance
	**/
	// private static int costOfSubstitution(char a, char b) {
	// 	return((a == b) ? (0) : (1));
	// }

	/*
		Find the minimum of arbitrary numbers, , used by Levenshtein distance
	**/ 
	// private static int min(int... numbers) {
	// 	return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
	// }

	/*
		Function to calculate estimated cost between two words using Hamming distance
	**/

	// Levenshtein's distance, too overkill and slower compared to Hamming distance
	// public static int levenshteinDistance(String start, String goal) {
	// 	int[][] dp = new int[start.length() + 1][goal.length() + 1];

	// 	for(int i = 0; i <= start.length(); i++) {
	// 		for(int j = 0; j <= goal.length(); j++) {
	// 			if(i == 0) {
	// 					dp[i][j] = j;
	// 			} else if(j == 0) {
	// 					dp[i][j] = i;
	// 			} else {
	// 					dp[i][j] = min(dp[i - 1][j] + 1,
	// 								   dp[i][j - 1] + 1,
	// 								   dp[i - 1][j - 1] + costOfSubstitution(start.charAt(i - 1), goal.charAt(j - 1)));
	// 			}
	// 		}
	// 	}
	// 	return dp[start.length()][goal.length()];
	// }
}
