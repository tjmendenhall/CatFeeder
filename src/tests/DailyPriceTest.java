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
public class DailyPriceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link model.Feeder#returnDailyPrice(double)}.
	 */
	@Test
	public void testReturnDailyPrice() {
		Feeder test1 = new Feeder();
		Feeder test2 = new Feeder(8, 1, 2, .5, .07);
		Feeder test3 = new Feeder(3, 1, 2, .8, .07);
		
		assertEquals(1.28, test1.returnDailyPrice(test1.getCansADay()), .01);
		assertEquals(8.56, test2.returnDailyPrice(test2.getCansADay()), .01);
		assertEquals(5.14, test3.returnDailyPrice(test3.getCansADay()), .01);	
	}

}
