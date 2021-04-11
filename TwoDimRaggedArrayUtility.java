/**
 * @author evelyn
 */
import java.io.*;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility 
{
	/**
	 * pass in a file and return a two dimensional ragged array of double
	 * @param file
	 * @return An array of doubles if the file is not empty, and empty if file is null.
	 * @throws FileNotFoundException
	 */
	public static double[][] readfile(File file) throws FileNotFoundException
	{
		double[][] array = new double[0][];
		try 
		{
			BufferedReader ReadFile= new BufferedReader(new FileReader(file));
			
			int lines = 0;
	
			while (ReadFile.readLine() != null) 
			{
				lines++;
			}
			ReadFile.close();
		
			String line;
			int i=0;
			
			array = new double[lines][];
			
			ReadFile = new BufferedReader(new FileReader(file));
			
			while ((line=ReadFile.readLine())!=null)
		{
				String[]str= line.split(" ");
				
				int arrlength=str.length;
				
				array[i]=new double[arrlength];
		
				for(int j=0; j<arrlength; j++)
				{
					array[i][j]= Double.parseDouble(str[j]);
		
				}
						i++;
		}
			ReadFile.close();
		}
			catch(Exception ep)
				{
				
				ep.printStackTrace();
				
				}
		return array;
	}
   
	/**
	 * pass in a two dimensional ragged array of doubles and a file,
	 * and writes the ragged array into the file. Each row is on a separate line and each double is separated by a space.
	 * @param raggedArr
	 * @param file
	 * @throws FileNotFoundException
	 */
   public static void writeToFile(double[][] raggedArr,File file) throws FileNotFoundException
   {
	   try (PrintWriter file1 = new PrintWriter(file))
	   {
		   	for (int i = 0; i < raggedArr.length; i++) 
		   	{
		   		for (int j = 0; j < raggedArr[i].length; j++) 
		   		{
		   			file1.print(raggedArr[i][j] + " ");
		   		}
		   		file1.println();
		   	}
		   	file1.close();
	   }
 }
   /**
    * Pass in a two dimensional ragged array of doubles
    * and returns the total of the elements in the array.
    * @param raggedArr
    * @return The total of the elements in the array
    */
   public static double getTotal(double[][] raggedArr)
   {
       double total=0;
       //find the sum of the values of the 2D array
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               total += raggedArr[i][j];
           }
       }
       return total;
   }
   /**
    * Pass in a two dimensional ragged array of doubles
    * and returns the average of the elements in the array
    * @param raggedArr
    * @return
    */
  
   public static double getAverage(double[][] raggedArr)
   {
       double total=0;
       
       int numOfElements=0;
       
       //find the sum of the values of the 2D array
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               total += raggedArr[i][j];
               //to keep track of the elements in the array.
               numOfElements += 1;
           }
       }
       //find and return the average
       return (total/numOfElements);
   }
   /**
    * Pass in a two dimensional ragged array of doubles and a row index
    * and returns the total of that row. Row index 0 is the first row in the array.
    * @param raggedArr
    * @param rowIndex
    * @return The total of the row
    */
 
   public static double getRowTotal(double[][] raggedArr,int rowIndex)
   {
       double total=0;
       
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           total += raggedArr[rowIndex][j];

       }
       return total;
   }
   /**
    * Pass in a two dimensional ragged array of doubles
    * and a column index and returns the total of that column.
    * @param raggedArr
    * @param colIndex
    * @return The total of the column
    */ 
   public static double getColumnTotal(double[][] raggedArr,int colIndex)
   {
       double total=0;
       
       for(int i=0;i<raggedArr.length;i++)
       {
           if(colIndex<raggedArr[i].length)
               total += raggedArr[i][colIndex];
       }
       return total;
   }
   /**
    *Pass in a two dimensional ragged array of doubles and a
    *row index and returns the largest element in that row.
    * @param raggedArr
    * @param rowIndex
    * @return The highest element in the row 
    */
   
   public static double getHighestInRow(double[][] raggedArr,int rowIndex)
   {
       double highest=0;
       
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           if(raggedArr[rowIndex][j]>highest)
        	   
               highest= raggedArr[rowIndex][j];

       }
       return highest;
   }
   /**
    *returns the largest element of the selected 
    *row in the 2-D array 
    * @param data
    * @param row
    * @return Highest row index.
    */

   public static int getHighestInRowIndex(double[][] data, int row)
   {  
	   double highElementInRow = data[row][0];
	   int highestRowIndex=0;
	   
	   for(int i=0; i < data[row].length; i++)
	   {
		   if(data[row][i] > highElementInRow) 
		   {
			   highElementInRow = data[row][i];
		       highestRowIndex=i;
		   }
	   }
	   return highestRowIndex; 
   }
   /**
    * Takes a two dimensional ragged array of doubles and a
    * row index and returns the smallest element in that row.
    * @param raggedArr
    * @param rowIndex
    * @return Lowest element in row
    */
  
   public static double getLowestInRow(double[][] raggedArr,int rowIndex)
   {
       double lowest = raggedArr[rowIndex][0];
       
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           if(raggedArr[rowIndex][j]<lowest)
        	   
               lowest = raggedArr[rowIndex][j];

       }
       return lowest;
   }
   /**
    * Takes a two dimensional ragged array of doubles and a
    * row index and returns the smallest index in that row.
    * @param data
    * @param row
    * @return Lowest index in the row
    */
   public static int getLowestInRowIndex(double[][] data, int row)
	{
	   double lowElementInRow = data[row][0];
	   
	   int lowestRowIndex=0;
	   for(int i=0; i < data[row].length; i++)
	   {
		   if(data[row][i] < lowElementInRow)
		   {
			   
			  lowElementInRow = data[row][i];
		   
		   	   lowestRowIndex=i;
		   }
	   }
	   return lowestRowIndex; 
	}

   /**
    * Pass in a two dimensional ragged array of doubles
    * and a column index and returns the largest element in that column
    * @param raggedArr
    * @param colIndex
    * @return Highest element in the column
    */
   
   public static double getHighestInColumn(double[][] raggedArr,int colIndex)
   {
	   double highest = Double.MIN_VALUE;
	   
	   for(int i =0; i < raggedArr.length; i++)
	   {
		   if(colIndex < raggedArr[i].length)
		   {
			   if (raggedArr[i][colIndex]>highest)
			   {
				  highest = raggedArr[i][colIndex];
			   }
		   }
		   
	   }
	   return highest;
   }
   /**
    * Returns index of the largest element of the selected column in the 2-D array
    * @param data
    * @param col
    * @return Highest index in the column
    */
   
   public static int getHighestInColumnIndex(double[][] data, int col)
	{	
		   int highestIndex = 0;
		   double highest = Double.MIN_VALUE;
		   for(int i =0; i<data.length; i++)
		   {
			   if (col < data[i].length)
			   {
				   if (data[i][col]>highest)
				   {
					   highestIndex = i;
					   highest = data[i][col];
				   }
			   }
		   }
         return highestIndex;
	}
   /**
    *  Pass in a two dimensional ragged array of doubles and a column
    * index and returns the smallest element in that column
    * @param raggedArr
    * @param colIndex
    * @return The lowest element in the column.
    */
   public static double getLowestInColumn(double[][] raggedArr,int colIndex)
   {
	   double lowElementInColumn = Double.MAX_VALUE;
	   
	   for(int i=0; i < raggedArr.length; i++)
	   {
		   if(colIndex < raggedArr[i].length && raggedArr[i][colIndex] < lowElementInColumn)
		   
			   lowElementInColumn = raggedArr[i][colIndex];
	   }
	   return lowElementInColumn;    
   }
   /**
    * Returns the index of the smallest element of the selected column in the 
    * two dimensional array.
    * @param data
    * @param col
    * @return The lowest index in the column
    */
   public static int getLowestInColumnIndex(double[][] data, int col) 
   {
	   double lowElementInColumn = Double.MAX_VALUE;
	   int lowestColumnIndex=0;
	   	for(int i=0; i < data.length; i++)
	   	{
	   		if(col < data[i].length && data[i][col] < lowElementInColumn)
	   		{
	   			lowElementInColumn = data[i][col];
	   			lowestColumnIndex=i;
	   		}
	   	}
	  return lowestColumnIndex;
  }
   /**
    * pass in a two dimensional ragged array of doubles
    * and returns the largest element in the array.
    * @param raggedArr
    * @return The highest element in the array 
    */
   public static double getHighestInArray(double[][] raggedArr)
   {
	   double high = 0;

		for (double[] array1 : raggedArr)
		{
			for (double array2 : array1) 
			{
				if (array2 > high)
				{
					high = array2;
				}
			}
		}
		return high;

   }
   /**
    * Pass in a two dimensional ragged array of doubles
    * and returns the smallest element in the array.
    * @param raggedArr
    * @return The lowest element in the array.
    */
  
   public static double getLowestInArray(double[][] raggedArr)
   {
	   double low = raggedArr[0][0];
		for (double[] array : raggedArr) 
		{
			for (double array1 : array) 
			{
				if (array1 < low) 
				{
					low = array1;
				}
			}
		}
 	return low;
  }
}
