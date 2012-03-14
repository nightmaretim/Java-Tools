package editool.tool;

import static org.junit.Assert.*;

import org.junit.Test;

public class FixedBytesStringMakerTest {


	@Test
	public void testConverter() {
		String str1 = "ABCDEF";
		String str2 = "‚ ‚¢‚¤";
		FixedBytesStringMaker fbsm = new FixedBytesStringMaker(10 , str1);
		FixedBytesStringMaker fbsm2 = new FixedBytesStringMaker(10 , str2);
		System.out.print(fbsm.rightOrWrong());
		assertEquals(fbsm.rightOrWrong() , true);
		assertEquals(fbsm.converter(), "ABCDEF    ");
		assertEquals(fbsm2.converter(), "‚ ‚¢‚¤    ");
	}

}
