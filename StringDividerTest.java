package editool.tool;

import org.junit.Test;

import junit.framework.TestCase;

public class StringDividerTest extends TestCase {

	public void testStringDivider() {
	}

	public void testStringDividerStringChar() {

	}

	public void testStringDividerStringIntArray() {

	}

	public void testDelimiterDivider() {

	}

	public void testDelimiterDividerWith() {

	}

	public void testNumArrangementDivider() {

	}

	@Test
	public void testNumArrangementDividerByteSpaceTrim() {
		String str = "AAAAA‚ ‚¢‚¤‚¦‚¨BBBBB";
		int num[] ={5,10,5};
		StringDivider sd = new StringDivider(str,num);
		String kekka[] = sd.numArrangementDividerByteSpaceTrim();

		assertEquals(kekka[0] , "AAAAA");
		assertEquals(kekka[1] , "‚ ‚¢‚¤‚¦‚¨");
		assertEquals(kekka[2] , "BBBBB");

	}

	@Test
	public void testNumArrangementDividerByte() {
		String str = "AAAAA‚ ‚¢‚¤‚¦‚¨BBBBB";
		int num[] ={5,10,5};
		StringDivider sd = new StringDivider(str,num);
		String kekka[] = sd.numArrangementDividerByte();

		assertEquals(kekka[0] , "AAAAA");
		assertEquals(kekka[1] , "‚ ‚¢‚¤‚¦‚¨");
		assertEquals(kekka[2] , "BBBBB");

	}

	@Test
	public void testCheckNumArrangementDivider()
	{
		String str = "AAAAA‚ ‚¢‚¤‚¦‚¨BBBBB";
		int num[] ={5,5,5};
		StringDivider sd = new StringDivider(str,num);
		boolean kekka = sd.checkNumArrangementDivider();
		assertEquals(kekka , true);
	}

	@Test
	public void testCheckNumArrangementDividerByte()
	{
		String str = "AAAAA‚ ‚¢‚¤‚¦‚¨BBBBB";
		int num[] ={5,10,5};
		StringDivider sd = new StringDivider(str,num);
		boolean kekka = sd.checkNumArrangementDividerByte();
		assertEquals(kekka , true);
	}
}
