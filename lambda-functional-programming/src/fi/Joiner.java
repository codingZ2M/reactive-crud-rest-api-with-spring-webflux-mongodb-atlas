package fi;

@FunctionalInterface 
public interface Joiner { // User defined Functional Interface..
	
	String join(String s1, String s2);
	/*
	  default public void doSomeWork(){
		    System.out.println("Doing some work in Joiner interface impl...");
		  }
		  default public void doSomeOtherWork(){
		    System.out.println("Doing some other work in interface impl...");
		  }
		  
	@Override
	public String toString();
		  
*/
}

/*
You cannot have more than one method besides static, default and abstract methods
 that override methods in Object in your @FunctionalInterface

*/