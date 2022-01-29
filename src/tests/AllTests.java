package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Jan 29, 2022
 */
@RunWith(Suite.class)
@SuiteClasses({ DailyPriceTest.class, FeedingPriceTest.class, WeeklyPriceTest.class })
public class AllTests {

}
