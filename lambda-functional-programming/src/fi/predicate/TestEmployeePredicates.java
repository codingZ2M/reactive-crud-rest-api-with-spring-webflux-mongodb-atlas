package fi.predicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
 
public class TestEmployeePredicates {
	
    public static void main(String[] args){
    	
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,38,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");
         
        List<Employee> employees = new ArrayList<Employee>();
        
        Predicate<Employee> predicate  = ( Employee emp)    ->  {  
        	                      							      return emp.getAge() > 21 && emp.getGender().equalsIgnoreCase("M"); 
        	                          					};
   String adultMaleData =  EmployeePredicates.isAdultMale(  predicate,     e3 );
   
   
   String adultFemaleData =  EmployeePredicates.isAdultFemale(  (emp)  ->   emp.getAge() > 18 && emp.getGender().equalsIgnoreCase("F"),    e5 );
                
        System.out.println(adultMaleData);
        System.out.println(adultFemaleData);
        
          int age =21;
        String adultFemaleAge =  EmployeePredicates.isAgeMoreThan(  emp  ->   emp.getAge() > age && emp.getGender().equalsIgnoreCase("F"),    e7 );
        System.out.println(adultFemaleAge);
        
        System.out.println("**************************************************************************");
        
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);
        employees.add(e8);
        employees.add(e9);
        employees.add(e10);
        
        System.out.println("Only All Male Emploees With Age > 21" +"\n" + "---------------------------------------------------------------" );
        		
        List<Employee> allAdultMaleData =  EmployeePredicates.isAllAdultMale(   emp    ->   emp.getAge() > 21 && emp.getGender().equalsIgnoreCase("M"),     employees );
        
        Iterator <Employee> iterator = allAdultMaleData.iterator();
	       while(iterator.hasNext()) {
                 Employee employee =  iterator.next(); 
        System.out.println(employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + "Male & & Age Is > 21 - Status: Eligible");
	       }
	       
	       System.out.println("**************************************************************************");
	        
	       System.out.println("Only All Female Emploees With Age > 18" +"\n" + "---------------------------------------------------------------" );
   		
	        List<Employee> allAdultFemaleData =  EmployeePredicates.isAllAdultFemale(   emp    ->   emp.getAge() > 18 && emp.getGender().equalsIgnoreCase("F"),     employees );
	        
	        Iterator <Employee> iteratorForFemaleEmployees = allAdultFemaleData.iterator();
		       while(iteratorForFemaleEmployees.hasNext()) {
	                 Employee employee =  iteratorForFemaleEmployees.next(); 
	        System.out.println(employee.getFirstName() +"  |  "+ employee.getAge() +"  |  "+ employee.getGender()+ "  " + "Female & & Age Is > 18 - Status: Eligible");
		       }
    }
};






