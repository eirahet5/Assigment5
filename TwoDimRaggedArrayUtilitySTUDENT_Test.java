import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{7,2,9,4,8,3},{5},{8,1,3,2},{11,6,7,2}};
	private double[][] dataSetSTUDENT2 = {{7.2,2.5,9.3,4.8,5.5,3.2},{5.9},{8.1,1.7,3.3},{11.6,6.9,7.3,2.7}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(78.0, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT), 0.001);
		assertEquals(80.0, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2), 0.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(5.2,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
		assertEquals(5.714,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2),.001);
			
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,1),.001);
		assertEquals(5.9,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2,1),.001);	
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(31.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,0),.001);
		assertEquals(32.8,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2,0),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
		assertEquals(11.6,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT2),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readfile(outputFile);
		assertEquals(7.0, array[0][0],.001);
		assertEquals(2.0, array[0][1],.001);
		assertEquals(9.0, array[0][2],.001);
		assertEquals(4.0, array[0][3],.001);
		assertEquals(8.0, array[0][4],.001);
		assertEquals(3.0, array[0][5],.001);
		assertEquals(5.0, array[1][0],.001);
		assertEquals(8.0, array[2][0],.001);
		assertEquals(1.0, array[2][1],.001);
		assertEquals(3.0, array[2][2],.001);
		assertEquals(2.0, array[2][3],.001);	
		assertEquals(11.0, array[3][0],.001);
		assertEquals(6.0, array[3][1],.001);
		assertEquals(7.0, array[3][2],.001);
		assertEquals(2.0, array[3][3],.001);
		
	}
}
