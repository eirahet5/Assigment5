/**
 * @author evelyn
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusSTUDENT_Test {
	private double[][] dataSetSTUDENT1 = {{3,5,2},{2,1},{4,3,6}};
	private double[][] dataSetSTUDENT2 = {{7,2,9,4},{5},{8,1,3},{11,6,7,2}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
		/**
		 * Student test
		 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */

		@Test
		public void testCalculateHolidayBonusA() {
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT1,5000,1000,2000);
			assertEquals(8000.0,result[0],.001);
			assertEquals(2000.0,result[1],.001);
			assertEquals(12000.0,result[2],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT2,5000,1000,2000);
			assertEquals(14000.0,result[0],.001);
			assertEquals(1000.0,result[1],.001);
			assertEquals(4000.0,result[2],.001);
			assertEquals(13000.0,result[3],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
			
		}
		

		/**
		 * Student test
		 * Test calculateHolidayBonus method with a high of 1000, low of 250 and 500 as other
		 */

		@Test
		public void testCalculateHolidayBonusB() {
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT1,1000,250,500);
			assertEquals(1750.0,result[0],.001);
			assertEquals(500.0,result[1],.001);
			assertEquals(2500.0,result[2],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT2,1000,250,500);
			assertEquals(3000.0,result[0],.001);
			assertEquals(250.0,result[1],.001);
			assertEquals(1000.0,result[2],.001);
			assertEquals(2750.0,result[3],.001);
			
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
			
		}

		/**
		 * Student test
		 * Test calculateTotalHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */
	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(22000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT1, 5000, 1000, 2000),.001);
		assertEquals(32000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT2, 5000, 1000, 2000),.001);
	}
	
	/** 
	 * Student test
	 * Test calculateTotalHolidayBonus method with a high of 1000, low of 250 and 500 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusB() {
		assertEquals(4750.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT1, 1000,250,500),.001);
		assertEquals(7000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT2, 1000,250,500),.001);

	}

}

