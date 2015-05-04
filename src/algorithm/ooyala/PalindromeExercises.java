package algorithm.ooyala;

import java.util.HashMap;
import java.util.Map;

public class PalindromeExercises {
	private static final int DIVISOR = 2;
	
	public static boolean isPalindrome(String word) {
		String reverseWord = (new StringBuilder(word)).reverse().toString();
		return word.equals(reverseWord);
	}
	
	public static String rearrange(String word) {
		Map<Character, Integer> mapOfOccurrences = createAndFillMapOfOccurrences(word);
		StringBuilder 
		prefix  = new StringBuilder(), 
		infix   = new StringBuilder(), 
		postfix = new StringBuilder();
		for (char character : mapOfOccurrences.keySet()) {
			int numOfOccurrences = mapOfOccurrences.get(character);
			int quotient  = getQuotient(numOfOccurrences,  DIVISOR);
			int remainder = getRemainder(numOfOccurrences, DIVISOR);
			for (int i = 0; i < quotient; i++) {
				prefix.append(character);
				postfix.append(character);
			}
			if (isPeerLess(remainder)) {
				infix.append(character);
			}
		}
		if (infix.length() > 1) {
			return "-1";
		}
		return prefix.append(infix).append(postfix.reverse()).toString();
	}
	
	private static Map<Character, Integer> createAndFillMapOfOccurrences(String word) {
		Map<Character, Integer> mapOfOccurrences = new HashMap<Character, Integer>();
		char[] characters = word.toCharArray();
		for (char character : characters) {
			Integer numOfOccurrences = mapOfOccurrences.get(character);
			if (numOfOccurrences == null) {
				numOfOccurrences = 1;
			} else {
				numOfOccurrences++;
			}
			mapOfOccurrences.put(character, numOfOccurrences);
		}
		return mapOfOccurrences;
	}
	
	private static boolean isPeerLess(int number) {
		return number != 0;
	}
	
	private static int getQuotient(int divident, int divisor) {
		return divident / divisor;
	}
	
	private static int getRemainder(int divident, int divisor) {
		return divident % divisor;
	}
}