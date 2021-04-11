/**
 * 
 * @author evelyn
 *
 */
public class HolidayBonus {
/**
 * Calculates the holiday bonus's for each company
 * @param data  2d ragged array of doubles
 * @param high  bonus for the highest store in a category
 * @param low  bonus for the lowest store in a category
 * @param other  bonus for all other stores in a category
 * @return an array f bonus for each store
 */
static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
{
	double[] bonus= new double[data.length];
	
	for (int i= 0; i< data.length; i++)
	{
		for (int j = 0; j < data[i].length; j++)
		{
			double highstSales =  TwoDimRaggedArrayUtility.getHighestInColumn(data,j);

			double lowestSales =  TwoDimRaggedArrayUtility.getLowestInColumn(data,j);

			if(data[i][j] > 0) 
			{
				if(data[i][j] == highstSales )
					
					bonus[i]= bonus[i]+ high;

				else if(data[i][j] == lowestSales )

					bonus[i]= bonus[i]+ low;
				else {

					bonus[i]= bonus[i]+ other;
				}
			}
		}


	}

	return bonus;
}


/**
 *
 * @param data the two dimensional array of store sales
 * @param high  bonus for the highest store in a category
 * @param low  bonus for the lowest store in a category
 * @param other  bonus for all other stores in a category
 * @return The total holiday bonus from all company's
 */
static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
 {
	double sumTotal = 0;
	
	double[] bonus= calculateHolidayBonus(data,high,low,other);

	for (int x = 0; x < bonus.length; x++)
	{
		sumTotal = bonus[x]+sumTotal;
	}
	return sumTotal;
 }

}

