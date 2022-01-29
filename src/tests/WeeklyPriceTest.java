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
public class WeeklyPriceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link model.Feeder#returnWeeklyPrice(double)}.
	 */
	@Test
	public void testReturnWeeklyPrice() {
		Feeder test1 = new Feeder();
		double price1 = test1.returnDailyPrice(test1.getCansADay());
		Feeder test2 = new Feeder(8, 1, 2, .5, .07);
		double price2 = test2.returnDailyPrice(test2.getCansADay());
		Feeder test3 = new Feeder(3, 1, 2, .8, .07);
		double price3 = test3.returnDailyPrice(test3.getCansADay());
		
		assertEquals(8.99, test1.returnWeeklyPrice(price1), .01);
		assertEquals(59.92, test2.returnWeeklyPrice(price2), .01);
		assertEquals(35.95, test3.returnWeeklyPrice(price3), .01);	
	}

}
