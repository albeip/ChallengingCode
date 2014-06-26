package algorithm.ooyala;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithm.ooyala.PalindromeExercises;

public class PalindromeExercisesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testIsPalindrome() {
		String toEvaluateValue = "civic";
		boolean isPalindrome = PalindromeExercises.isPalindrome(toEvaluateValue);
		assertTrue(isPalindrome);
	}
	
	@Test
	public void testRearrange() {
		String[] toEvaluateValues = {"ivcci", "oyotta", "cecarar", "bbb", "babbb"};
		List<String> actualValues = new ArrayList<String>();
		String[] expecteValues = {"civic", "-1", "arcecra", "bbb", "bbabb"};
		for (String string : toEvaluateValues) {
			String result = PalindromeExercises.rearrange(string);
			actualValues.add(result);
			System.out.print(result + "\t");
		}
		System.out.println();
		assertArrayEquals(expecteValues, actualValues.toArray(new String[actualValues.size()]));		
	}

}
