package collections;

import java.util.*;

public class SortedSetTest {

	   public static void main(String[] args) {

	      // Create the sorted set - stores in ascending order
	      SortedSet<String> set = new TreeSet<String>(); 

	      // Add elements to the set
	      set.add("b");
	      set.add("c");
	      set.add("a");

	      // Iterating over the elements in the set
	      Iterator<String> it = set.iterator();
	      
	      while (it.hasNext()) {
	         String element = it.next();
	         System.out.println(element.toString());
	      }
	      
	      for(String s : set)
	    	  System.out.println(s);
	   }
	}
