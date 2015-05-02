package algorithm.ooyala;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		String word = "amoma";
		boolean isPalindrome = PalindromeExercises.isPalindrome(word);
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
	
	@Test
	public void testRearrange01() {
		String toEvaluate = "ivcci";
		String rearranged = PalindromeExercises.rearrange(toEvaluate);
		assertEquals("civic", rearranged);
	}
	
	@Test
	public void testRearrange02() {
		String word = "oyotta";
		String rearranged = PalindromeExercises.rearrange(word);
		assertEquals("-1",rearranged);
	}
	
	@Test
	public void testRearrange03() {
		String word = "cecarar";
		String rearranged = PalindromeExercises.rearrange(word);
		assertEquals("arcecra", rearranged);
	}

	@Test
	public void testRearrange04() {
		String word = "bbb";
		String rearranged = PalindromeExercises.rearrange(word);
		assertEquals("bbb", rearranged);
	}
	
	@Test
	public void testRearrange05() {
		String word = "babbb";
		String rearranged = PalindromeExercises.rearrange(word);
		assertEquals("bbabb", rearranged);
	}

}
