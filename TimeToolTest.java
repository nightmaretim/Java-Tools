package editool.tool;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeToolTest {

	@Test
	public void testDateCalculationIntYyyymmdd() {
		assertEquals(20101011 , TimeTool.dateCalculationIntYyyymmdd(20101001, 10));
		assertEquals(20101101 , TimeTool.dateCalculationIntYyyymmdd(20101001, 31));
		assertEquals(20111001 , TimeTool.dateCalculationIntYyyymmdd(20101001, 365));

	}

	@Test
	public void testDelSlashYymmddParseYyyymmdd()
	{
		String str  = TimeTool.delSlashYymmddParseYyyymmdd("2011/4/8");
		assertEquals( str, "20110408");
		str  = TimeTool.delSlashYymmddParseYyyymmdd("11/4/8");
		assertEquals( str, "20110408");
	}

	@Test
	public void testDelHifunYymmddParseYyyymmdd()
	{
		String str  = TimeTool.delHifunYymmddParseYyyymmdd("2011-4-8");
		assertEquals( str, "20110408");
		str  = TimeTool.delHifunYymmddParseYyyymmdd("11-4-8");
		assertEquals( str, "20110408");
	}

	@Test
	public void testParseYymmToYyyymm()
	{
		String s = TimeTool.parseYymmToYyyymm("1202");
		assertEquals(s , "201202");

	}

	@Test
	public void testYymmddParseYyyymmdd()
	{
		String s = TimeTool.yymmddParseYyyymmdd("120102");
		assertEquals(s , "20120102");
	}

	/**@Test
	public void testNowYearYy()
	{
		assertEquals(TimeTool.nowYearYy() , 20);
	}**/

}
