package collections;

import java.util.*;

/**
 * Demonstrates a HashMap - unsorted Map
 * with key, value pairs
 * @author glen
 *
 */
public class HashMapDemo {

   public static void main(String args[]) {
      // Create a hash map
      HashMap<String, Double> hashMap = new HashMap<String, Double>();
      
      // Put elements in the map
      hashMap.put("Zara", new Double(3434.34));
      hashMap.put("Mahnaz", new Double(123.22));
      hashMap.put("Ayan", new Double(1378.00));
      hashMap.put("Daisy", new Double(99.22));
      hashMap.put("Qadir", new Double(-19.08));
      
      // Get a set of the entries
      Set<Map.Entry<String, Double>> set = hashMap.entrySet();
      
      // Get an iterator
      Iterator<Map.Entry<String, Double>> it = set.iterator();
      
      // Display elements
      while(it.hasNext()) {
         Map.Entry<String, Double> map = it.next();
         System.out.print(map.getKey() + ": ");
         System.out.println(map.getValue());
      }
      System.out.println();
      
      //Display elements with enhanced for-loop
      for(Map.Entry<String, Double> map : set){
    	  System.out.print(map.getKey() + ": ");
          System.out.println(map.getValue());
      }
      System.out.println();
      
      // Deposit 1000 into Zara's account
      double balance = hashMap.get("Zara").doubleValue();
      hashMap.put("Zara", new Double(balance + 1000));
      
      System.out.println("Zara's new balance: " + hashMap.get("Zara"));
   }
}
