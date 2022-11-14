package fi.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierUtil {
	
	//code shows how to pass Supplier as parameter.
	 public static Person personProducer(Supplier<Person> supplier ) {
		 
	        return supplier.get();
	        
	        
	    }
	 public static String personNameProducer(Supplier<String> supplier ) {
	        return supplier.get();
	        
	    }
	 
	 public static Date dateProducer(Supplier<Date> supplier ) {
	        return supplier.get();
	        
	    }
	 
	 
	 public static Date getSystemDate() {
	     return new Date();
	 }
}
