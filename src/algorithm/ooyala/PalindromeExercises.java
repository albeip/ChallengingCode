package algorithm.ooyala;

import java.util.HashMap;
import java.util.Map;

public class PalindromeExercises {
	
	public static boolean isPalindrome(String word) {
		String reverveWord = (new StringBuilder(word)).reverse().toString();
		return word.equals(reverveWord);
	}
	
	public static String rearrange(String word) {
		Map<Character, Integer> mapOfOccurrences = new HashMap<Character, Integer>();
		char[] characters = word.toCharArray();
		for (char character : characters) {
			int count = 1;
			if (mapOfOccurrences.containsKey(character)) {
				count = mapOfOccurrences.get(character);
				count++;
			}
			mapOfOccurrences.put(character, count);
		}		
		StringBuilder 
		prefix  = new StringBuilder(), 
		infix   = new StringBuilder(), 
		postfix = new StringBuilder();
		for (char character : mapOfOccurrences.keySet()) {
			int numOfOccurrences = mapOfOccurrences.get(character);
			for (int i = 0; i < numOfOccurrences/2; i++) {
				prefix.append(character);
				postfix.append(character);
			}
			if (numOfOccurrences%2 == 1) {
				infix.append(character);
			}
		}
		if (infix.length() > 1) {
			return "-1";
		}
		return prefix.append(infix).append(postfix.reverse()).toString();
	}
}