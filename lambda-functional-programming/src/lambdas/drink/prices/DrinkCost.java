package lambdas.drink.prices;

@FunctionalInterface
public interface DrinkCost {

	public double costOfDrink( double ouncePrice, int noOfOunces );
	
	
}
