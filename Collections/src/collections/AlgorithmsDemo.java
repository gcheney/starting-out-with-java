package collections;

import java.util.*;

public class AlgorithmsDemo {

   public static void main(String args[]) {
      // Create and initialize linked list
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.add(new Integer(-8));
      list.add(new Integer(20));
      list.add(new Integer(-20));
      list.add(new Integer(8));
      
      // Create a reverse order comparator
      Comparator<Integer> c = Collections.reverseOrder();
      
      // Sort list by using the comparator
      Collections.sort(list, c);
      
      // Get iterator
      Iterator<Integer> li = list.iterator();
      
      //Display list with iterator
      System.out.print("List sorted in reverse: ");
      while(li.hasNext()){
         System.out.print(li.next() + " ");
      }
      System.out.println();
      
      Collections.shuffle(list);
      
      // display randomized list - for loop
      System.out.print("List shuffled: ");
      for(Integer i : list) {
         System.out.print(i + " ");
      }
      
      System.out.println();
      System.out.println("Minimum: " + Collections.min(list));
      System.out.println("Maximum: " + Collections.max(list));
   }
}
