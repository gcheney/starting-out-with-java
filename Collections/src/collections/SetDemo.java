package collections;

import java.util.*;

public class SetDemo {

  public static void main(String args[]) { 
     int count[] = {34, 22, 10, 60, 30, 22};
     Set<Integer> set = new HashSet<Integer>(); //no duplicates
     
     try {
        for(int i = 0; i < count.length; i++){
           boolean added = set.add(count[i]);
           if(added)
        	   System.out.println(count[i] + " was added");
           else
        	   System.out.println(count[i] + " was NOT added");
        }
  
        System.out.println("The set is: ");
        System.out.println(set);
  
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(set);//sorts in ascending order
        System.out.println("The sorted list is:");
        System.out.println(sortedSet);

        System.out.println("The First element of the set is: "+ sortedSet.first());
        
        System.out.println("The last element of the set is: "+ sortedSet.last());
     }
     catch(Exception e){
    	 System.out.println(e.getMessage());
     }
  }
} 
