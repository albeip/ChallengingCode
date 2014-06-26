package algorithm.ooyala;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilTest {

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
	public void testFormatCase01() {
		String value = "100";
		String formatedValue = StringUtil.format(value);
		System.out.println(formatedValue);
		assertTrue(formatedValue.equals("$100.00"));
	}

	@Test
	public void testFormatCase02() {
		String value = "1234.5";
		String formatedValue = StringUtil.format(value);
		System.out.println(formatedValue);
		assertTrue(formatedValue.equals("$1,234.50"));
	}

	@Test
	public void testFormatCase03() {
		String value = "12345678.901";
		String formatedValue = StringUtil.format(value);
		System.out.println(formatedValue);
		assertTrue(formatedValue.equals("$12,345,678.90"));
	}

	@Test
	public void testFormatCase04() {
		String value = "-123.12";
		String formatedValue = StringUtil.format(value);
		System.out.println(formatedValue);
		assertTrue(formatedValue.equals("-$123.12"));
	}
	
}
