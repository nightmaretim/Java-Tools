package editool.tool;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaticStringProcesserTest {

	@Test
	public void testLengthCheck() {
		assertEquals(StaticStringProcesser.lengthCheck("Test" , 3) , false);
		assertEquals(StaticStringProcesser.lengthCheck("Test" , 5) , true);
		assertEquals(StaticStringProcesser.lengthCheck("Test" , 4) , true);
	}

	@Test
	public void testOrderRestNumCutter()
	{
		assertEquals(StaticStringProcesser.orderRestNumCutter("12345" , 3) , "45");
	}

}
