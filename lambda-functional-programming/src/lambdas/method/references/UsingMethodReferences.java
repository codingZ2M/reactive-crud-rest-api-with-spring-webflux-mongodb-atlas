package lambdas.method.references;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;
/* Method References in Java
 To refer to a method in an object	
 Object :: methodName 
 */
public class UsingMethodReferences {

	 public static void main (String a [] ) {
		 
		 ToIntFunction<String> lengthFunction = String::length;
		 
		ToIntFunction<String> lengthFunction1 = (x) -> x.length();
		 
		 String name = "Ellen";
		 
		 int len = lengthFunction1.applyAsInt(name);
		 
		 System.out.println("Name = " + name + ", length = " + len);
		 
// *********************Using a static method reference ***********************************
		// Function<Integer, String> func2 = Integer::toBinaryString;
		 Function<Integer, String> func2 =    (x) -> Integer.toBinaryString(x);
		 System.out.println(func2.apply(17));
		 
		 
		// Uses a lambda expression
		 BiFunction<Integer, Integer, Integer> func1 = (x, y) -> Integer.sum(x, y);
		 System.out.println(func1.apply(17, 15));
		 
		 // Uses a method reference
		 BiFunction<Integer, Integer, Integer> func4 = Integer::sum;
		 
		 System.out.println(func4.apply(17, 15));
	 
/*
 * Let’s try using a method reference of the overloaded static method valueOf() of the Integer class		 
 */
		// Uses Integer.valueOf(int)
		 Function<Integer, Integer> func5 = Integer::valueOf;
		 
		Function<Integer, Integer> func9 = (x) -> Integer.valueOf(x);
		 
		 // Uses Integer.valueOf(String)
		 Function<Integer, Integer> func6 = Integer::valueOf;
		 
		 // Uses Integer.valueOf(String, int)
		 BiFunction<String, Integer, Integer> func7 = Integer::valueOf;
		 System.out.println(func9.apply(21));
		 
		 System.out.println(func6.apply(100));
		 
		 System.out.println(func7.apply("10001", 2));
		 
		

	 
	 
	 }
	 
	 
	 
}
