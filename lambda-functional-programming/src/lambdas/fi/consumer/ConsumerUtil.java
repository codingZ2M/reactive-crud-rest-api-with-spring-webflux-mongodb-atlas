package lambdas.fi.consumer;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerUtil {
	
	public static void acceptAllStudents(List<Student> listOfStudents, Consumer<Student> consumer) {
		   
	      for (Student e : listOfStudents) {
	    	  
	         consumer.accept(e);
	      }
	   }

}



