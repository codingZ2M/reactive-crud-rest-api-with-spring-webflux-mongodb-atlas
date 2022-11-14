package lambdas.drink.prices;

public class DrinkUtility {
	
	int qty;
	
	public static double beverageCostPercentage(CostOfSales costOfSales, double costPrice,  double sellingPrice) {
		
		double costOfSalesOfBeverage;
        
		costOfSalesOfBeverage = costOfSales.costOfSalesOfBeverage(costPrice, sellingPrice);

		return  costOfSalesOfBeverage;
	}

public static double costOfDrink(DrinkCost drinkCost, double ouncePrice,  int noOfOunces) {
		
		double costOfDrink;
        
		costOfDrink = drinkCost.costOfDrink(ouncePrice, noOfOunces);

		return  costOfDrink;
	}

}
