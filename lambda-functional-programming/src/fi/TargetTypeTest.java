package fi;

public class TargetTypeTest {

	public static void main(String[] args) {
		
		Adder adder;
		//Creates an Adder using a lambda expression
		adder  = (double x, double y) ->  x + y ;
		
		double sum1 = adder.add(10, 89);
		
			 adder = (double x, double y) ->  x * y ;
			
			 double sum2 = adder.add(10.34, 89.11);
	
			
			//calling default method of the functional interface
		//	adder.doSomeWork();
			
			//Creates a Joiner using a lambda expression
			Joiner joiner = ( x,  y) -> x + y;
			
	//Joins two strings
			String str = joiner.join("Hello", " lambda");
			
			System.out.println("sum1 = " + sum1);
			System.out.println("sum2 = " + sum2);
			System.out.println("str = " + str);
			
		//	joiner.doSomeWork();
   }	
}