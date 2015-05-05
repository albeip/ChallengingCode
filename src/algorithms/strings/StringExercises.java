package algorithms.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringExercises {
	/**
	 * To set the first match index as an initial start point
	 */
	private static boolean hasStarted = false;
	private static int currentStartIndex = 0;
	private static int finalStartIndex = 0;
	private static int finalEndIndex = 0;
	private static int minLen = Integer.MAX_VALUE;
	private static int currentLen = 0;

	public static String findSmallestSubStringWithAllChars(String big, String small) {
	    if (null == big || null == small || big.isEmpty() || small.isEmpty()) {
	        return null;
	    }
	    Map<Character, Integer> frequencyMap          = createFrequencyMap(small);
	    Map<Character, Integer> encounteredMap        = new HashMap<Character, Integer>();
	    Set<Character>          coveredCharacterSet   = new HashSet<Character>();
	    int                     charactersToBeCovered = frequencyMap.size();
		/**
		 * Whether we have already found the match and now looking for other
		 * alternatives.
		 */
		boolean isFound = false;
	    for (int i = 0; i < big.length(); i++) {
	        char currentCharacter = big.charAt(i);
	        if (!frequencyMap.containsKey(currentCharacter)) {
				continue;
			}
            int encounteredCount = updateEncounteredMap(encounteredMap,currentCharacter);
            Integer frequencyCount = frequencyMap.get(currentCharacter);
            if (encounteredCount >= frequencyCount) {
    			coveredCharacterSet.add(currentCharacter);
    		}	        
	        if (isFound) {
	            if (currentCharacter == big.charAt(currentStartIndex)) {
	                encounteredMap.put(currentCharacter, encounteredMap.get(currentCharacter) - 1);
	                currentStartIndex++;
	                while (currentStartIndex < i) {
	                	char currentKey = big.charAt(currentStartIndex);
	                	if (encounteredMap.containsKey(currentKey)) {
							if (encounteredMap.get(currentKey) > frequencyMap.get(currentKey)) {
								encounteredMap.put(currentKey, encounteredMap.get(currentKey) - 1);
							} else {
								break;
							}
						}
	                    currentStartIndex++;
	                }
	            }
	            currentLen = i - currentStartIndex;
	            updateMinLength(i);				
			} else {
	            if (!hasStarted) {
	                hasStarted = true;
	                currentStartIndex = i;
	            }	            
	            if (coveredCharacterSet.size() == charactersToBeCovered) {
	                currentLen = i - currentStartIndex;
	                isFound = true;
	                updateMinLength(i);
	            }
			}	        
	    }
	    System.out.println("start: " + finalStartIndex + " finalEnd : " + finalEndIndex);
	    return big.substring(finalStartIndex, finalEndIndex + 1);
	}

	private static int updateEncounteredMap(
			Map<Character, Integer> encountered, char currentCharacter) {
        Integer encounteredFrequency = encountered.get(currentCharacter);
        if (encounteredFrequency == null) {
			encounteredFrequency = 1;
		} else {
			encounteredFrequency++;
		}
        encountered.put(currentCharacter, encounteredFrequency);
        return encounteredFrequency;
	}

	private static void updateMinLength(int index) {
	    if (minLen > currentLen) {
	        minLen = currentLen;
	        finalStartIndex = currentStartIndex;
	        finalEndIndex = index;
	    }

	}
	
	private static Map<Character, Integer> createFrequencyMap(String symbols) {
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (char character : symbols.toCharArray()) {
			Integer count = frequencyMap.get(character);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			frequencyMap.put(character, count);
		}
		return frequencyMap;
	}

	public static void main(String[] args) {

	    String big = "this is a test string";
	    String small = "tist";
	    System.out.println("len: " + big.length());
	    System.out.println(findSmallestSubStringWithAllChars(big, small));
	}
}