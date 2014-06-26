package algorithm.ooyala;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PalindromeExercises {
	
	public static boolean isPalindrome(String toEvaluate) {
		StringBuilder result = new StringBuilder(toEvaluate);
		result.reverse();
		return toEvaluate.equals(result.toString());
	}
	
	public static String rearrange(String word) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();		
		for (int i = 0; i < word.length(); i++) {
			Character character = word.charAt(i);
			Integer count = 1;
			if (map.containsKey(character)) {
				count = map.get(character);
				count++;
			}
			map.put(character, count);
		}
		Set<Character> keySet = map.keySet();
		StringBuilder  str1   = new StringBuilder();
		StringBuilder  str2   = new StringBuilder();
		StringBuilder  middle = new StringBuilder();
		for (Character character : keySet) {
			Integer count = map.get(character);
			for(int i = 0; i < count/2; i++) {
				str1.append(character);
				str2.append(character);					
			}
			if (count%2 == 1) {
				middle.append(character);
			}
		}
		if (middle.length() > 1) {
			return "-1";
		}
		return str1.append(middle).append(str2.reverse()).toString();
	}
}