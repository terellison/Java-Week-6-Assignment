package cop2251.fall17.week6.ellison;


import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecursion
{

	@Test
	public void testSumIt()
	{
		Finder finder = new Finder();

		assertEquals(6, finder.sumIt("1d2d3d") );
		assertEquals(10, finder.sumIt("55") );
		assertEquals(0, finder.sumIt("xx") );
		assertEquals(1, finder.sumIt("00001") );
		assertEquals(3, finder.sumIt("x0x0w1y2") );
		assertEquals(21, finder.sumIt("123456") );
		assertEquals(21, finder.sumIt("x123456x") );
		assertEquals(7, finder.sumIt("1ggggg60") );
	}
	
	@Test
	public void testMax()
	{
		Finder finder = new Finder();

		// assume max is the smallest possible number
		int max = 0;
		
		assertEquals(12, finder.findMax("12x8",max) );
		assertEquals(88, finder.findMax("012x88",max) );
		assertEquals(100, finder.findMax("012x88ttttt9xe33ppp100",max) );
		assertEquals(128, finder.findMax("128",max) );
		assertEquals(0, finder.findMax("abcdef",max) );
		assertEquals(123456, finder.findMax("123456",max) );
		assertEquals(2, finder.findMax("x2x1x",max) );
	}

}
