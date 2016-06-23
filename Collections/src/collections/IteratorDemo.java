package collections;

import java.util.*;

public class IteratorDemo {

   public static void main(String args[]) {
      // Create an array list
      ArrayList<String> al = new ArrayList<String>();
      // add elements to the array list
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");

      // Use iterator to display contents of al
      System.out.print("Original contents of al: ");
      Iterator<String> it = al.iterator();
      
      while(it.hasNext()) {
         String element = it.next();
         System.out.print(element + " ");
      }
      System.out.println();
      
	  // Modify objects being iterated using ListIterator
      ListIterator<String> listIt = al.listIterator();
      while (listIt.hasNext()) {
    	  String element = listIt.next();
          listIt.set(element + "+");
      }
      
      System.out.print("Modified contents of al: ");
      it = al.iterator();
      while (it.hasNext()) {
    	 String element = it.next();
         System.out.print(element + " ");
      }
      System.out.println();

      // Now, display the list backwards
      System.out.print("Modified list backwards: ");
      while (listIt.hasPrevious()) {
    	 String element = listIt.previous();
         System.out.print(element + " ");
       }
       System.out.println();
    }
}