package lambdas.drink.prices;

public class DrinkCostTest {

	public static void main(String[] args) {

		CostOfSales costOfSales = (cost, sellingPrice) -> (cost / sellingPrice) * 100;

		// Using Lambda Expression...
		double costOfSalesOfBeverage =	DrinkUtility.beverageCostPercentage( costOfSales,  12.0,  19.0 );
		System.out.println("Cost of Sales of a Beverage: " + costOfSalesOfBeverage);

		// METHOD REFERENCE....
		//  double costOfSalesOfBeverage =	DrinkUtility.beverageCostPercentage( DrinkCostTest::getCostOfSales,  12.0,  19.0 );
		//  System.out.println("Cost of Sales of a Beverage: " + costOfSalesOfBeverage);



		// Using Anonymous class..
		/*double cost=	DrinkUtility.beverageCostPercentage ( new CostOfSales() {
			@Override
			public double costOfSalesOfBeverage(double costPrice, double sellingPrice) {
				double costOfSalesOfBeverage;			        
				costOfSalesOfBeverage = (costPrice / sellingPrice) * 100;
				return  costOfSalesOfBeverage;
			}

		}, 12.0,  19.0 );

		System.out.println("Cost of Sales of a Beverage: " + cost);
*/

		String drinkName="Vodka";
		double whiskyOuncePrice = 4.0;
		double vodkaOuncePrice = 5.0;  
		int numberOfOunces = 3;


		if (drinkName.equals("Whisky") ) {

			double costOfDrink = DrinkUtility.costOfDrink( (ouncePrice, noOfOunces) -> (ouncePrice * noOfOunces),  whiskyOuncePrice ,  numberOfOunces);     
			System.out.println("Cost of a Whisky : $" + costOfDrink +" USD");
		}

		else if (drinkName.equals("Vodka") ) {

			double costOfDrink = DrinkUtility.costOfDrink( (ouncePrice, noOfOunces) -> (ouncePrice * noOfOunces),  vodkaOuncePrice,  numberOfOunces );     
			System.out.println("Cost of a Vodka : $" + costOfDrink +" USD");
		}



	}
}