package collections;

import java.util.*;

/**
 * Demonstrates a TreeMap - sorted HashMap
 * @author glen
 *
 */
public class TreeMapDemo {

   public static void main(String args[]) {
      // Create a hash map
      TreeMap<String, Double> treeMap = new TreeMap<String, Double>();
      // Put elements to the map
      treeMap.put("Zara", new Double(3434.34));
      treeMap.put("Mahnaz", new Double(123.22));
      treeMap.put("Ayan", new Double(1378.00));
      treeMap.put("Daisy", new Double(99.22));
      treeMap.put("Qadir", new Double(-19.08));
      
	  // Get a set of the entries
      Set<Map.Entry<String, Double>> set = treeMap.entrySet();
      
      // Get an iterator
      Iterator<Map.Entry<String, Double>> i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry<String, Double> map = i.next();
         System.out.print(map.getKey() + ": ");
         System.out.println(map.getValue());
      }
      System.out.println();
      
      for(Map.Entry<String, Double> map : set){
    	  System.out.print(map.getKey() + ": ");
          System.out.println(map.getValue());
      }
      System.out.println();
      
      // Deposit 1000 into Zara's account
      double balance = ((Double)treeMap.get("Zara")).doubleValue();
      treeMap.put("Zara", new Double(balance + 1000));
      System.out.println("Zara's new balance: " +
      treeMap.get("Zara"));
   }
}
