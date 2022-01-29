package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.Feeder;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Jan 29, 2022
 */
public class FeedingPriceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link model.Feeder#returnFeedingPrice(double, double)}.
	 */
	@Test
	public void testReturnFeedingPrice() {
		Feeder test1 = new Feeder();
		Feeder test2 = new Feeder(8, 1, 2, .5, .07);
		Feeder test3 = new Feeder(3, 1, 2, .8, .07);
		assertEquals(.64, test1.returnFeedingPrice(test1.getCanPrice(), test1.getTax()), .01);
		assertEquals(4.28, test2.returnFeedingPrice(test2.getCanPrice(), test2.getTax()), .01);
		assertEquals(2.57, test3.returnFeedingPrice(test3.getCanPrice(), test3.getTax()), .01);	
	}

}
