package fi.predicate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeePredicates {
	
    public static String isAdultMale(Predicate<Employee> predicate, Employee employee) {
    	
    	boolean b = predicate.test(employee);
    	
    	  if (b==true) {
    		  return employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + "Male &  Age Is > 21 - Status: Eligible";
    	  }
    	  return employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + " Status: Not Eligible";
    }
     
    
    public static String isAdultFemale(Predicate<Employee> predicate, Employee employee) {
    	boolean b = predicate.test(employee);
    	
  	  if (b==true) {
  		  return employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + "Female & & Age Is > 18 - Status: Eligible";
  	  }
  	  return employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + "  Status: Not Eligible";
    }
     
    
    public static String isAgeMoreThan(Predicate<Employee> predicate, Employee employee) {
    	
    	boolean b = predicate.test(employee);
    	
    	  if (b==true) {
    		  return employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + "Female & & Age Is > " + employee.getAge() + " - Status: Eligible";
    	  }
    	  return employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + "  Status: Not Eligible";
      }
    
    
 public static List<Employee> isAllAdultMale(Predicate<Employee> predicate, List<Employee> employees) {
	 
	List<Employee> allAdultMaleEmployees = new LinkedList<Employee>(); 
	
	     Iterator <Employee> iterator = employees.iterator();
	     
	       while(iterator.hasNext()) {
                    Employee employee =  iterator.next();    	
    	    boolean b = predicate.test(employee);
 
        	  if (b==true) 
        		  
        		  allAdultMaleEmployees.add(employee);
        	
	       }
	      return allAdultMaleEmployees;
	     }
 
 public static List<Employee> isAllAdultFemale(Predicate<Employee> predicate, List<Employee> employees) {
	 
		List<Employee> allAdultFemaleEmployees = new LinkedList<Employee>(); 
		     Iterator <Employee> iterator = employees.iterator();
		       while(iterator.hasNext()) {
	                    Employee employee =  iterator.next();    	
	    	    boolean b = predicate.test(employee);
	 
	        	  if (b==true) 
	        		  allAdultFemaleEmployees.add(employee);
	        	
		       }
		      return allAdultFemaleEmployees;
		     }
} 
