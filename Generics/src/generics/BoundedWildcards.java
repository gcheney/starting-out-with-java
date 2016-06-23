package generics;

import java.util.*;

/**
 * This program demonstrates 
 * using bounded wildcards
 * in generic methods
 * @author glen
 *
 */
public class BoundedWildcards {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		System.out.println("sum = " + sumOfList(list));
		
		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum = " + sumOfList(ld));
		
		displayList(list);
		//showList(ld);  --Compile error - not a super class of integer
	}
	
	/**
	 * Returns the sum of a list the extends Number
	 * @param list The list to sum
	 * @return The sum of the list
	 */
	public static double sumOfList(List<? extends Number> list) {
		
	    double s = 0.0;
	    for (Number n : list)
	        s += n.doubleValue();
	    
	    return s;
	}
	
	/**
	 * Displays the current list 
	 * only if it is a super class
	 * of Integer
	 * @param list The list to display
	 */
	public static void displayList(List<? super Integer> list) {
		
	    for (int i = 0; i < list.size(); i++) {
	    	System.out.printf("%d: %d\n", (i+1), list.get(i));
	    }
	}
	
}
