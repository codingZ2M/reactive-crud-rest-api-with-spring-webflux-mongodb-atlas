package fi.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {

    	  //Supplier instance using Lambda Expression..
    	   Supplier<Person> supplier  = ()-> { return new Person("Rick", 30, "Programmer"); }; 	   
    	   
      Person p = SupplierUtil.personProducer(supplier);
      
        System.out.println("Person Detail:\n" + p.getName() + ", " + p.getAge() + ", " + p.getAddress());
        
       
      
       Supplier<Date> dateSupplier= () -> SupplierUtil.getSystemDate();
        
        //Supplier instance using method reference to a static method
     //   Supplier<Date> dateSupplier= SupplierUtil::getSystemDate;
         
            Date systemDate = SupplierUtil.dateProducer(dateSupplier);   
        System.out.println("systemDate->" + systemDate);
        
       
        
        // Supplier instance using method Reference...
        /*
         In a method reference, you place the object (or class) that contains
          the method before the :: operator and the name of the method after
           it without arguments.
         */
        Person person = new Person("Rick", 30, "Programmer");
     
       Supplier<String> personName  = person::getName;
       
       Supplier<String> personName1  = () -> person.getName();
       
        String perName = SupplierUtil.personNameProducer(personName1);
          System.out.println("Person Name:\n" + perName );

        
    }

}