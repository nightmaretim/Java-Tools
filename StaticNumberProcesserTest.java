package editool.tool;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaticNumberProcesserTest {

	@Test
	public void testDisitCheck() {
		int a = 40000;

		assertEquals(StaticNumberProcesser.disitCheck(a, 4),false);
		assertEquals(StaticNumberProcesser.disitCheck(a, 5),true);
		assertEquals(StaticNumberProcesser.disitCheck(a, 6) , true);

	}

	@Test
	public void testDisitCheckDouble() {
		double a = 1750.235;

		boolean b = StaticNumberProcesser.disitCheckDouble(a, 4,3);

		assertEquals(StaticNumberProcesser.disitCheckDouble(a, 3,3),false);
		assertEquals(StaticNumberProcesser.disitCheckDouble(a, 4,3),true);
		assertEquals(StaticNumberProcesser.disitCheckDouble(a, 5,3) , true);
		assertEquals(StaticNumberProcesser.disitCheckDouble(a, 5,2),false);
		assertEquals(StaticNumberProcesser.disitCheckDouble(a, 5,3),true);
		assertEquals(StaticNumberProcesser.disitCheckDouble(a, 5,4) , true);

	}

	@Test
	public void testParseIntPlus()
	{
		String str = "5";
		try
		{
			int i = StaticNumberProcesser.parseIntPlus(str);

		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}

}
