package oopFundamentals;

import java.util.*;

public class PolymorphismAbstractionDemo {

	public static void main(String[] args) {
		SalariedEmployee s = new SalariedEmployee("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
	    Employee e = new SalariedEmployee("John Adams", "Boston, MA", 2, 2400.00);
	    System.out.println("Call mailCheck using Salary reference --");
	    s.mailCheck();
	    System.out.println("\n Call mailCheck using Employee reference--");
	    e.mailCheck();
	    
	    List<Employee> employees = new ArrayList<Employee>();
	    employees.add(s);
	    employees.add(e);
	    
	    //Array can hold types that extend it
	    for(Employee employee : employees)
	    	System.out.println(employee.toString());
	}

}
