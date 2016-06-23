package collections;

import java.util.*;

public class CollectionsDemo {

	public static void main(String[] args) {
	      List<String> a1 = new ArrayList<String>();
	      a1.add("Zara");
	      a1.add("Mahnaz");
	      a1.add("Ayan");
	      System.out.println(" ArrayList Elements");
	      System.out.print("\t" + a1);

	      List<String> l1 = new LinkedList<String>();
	      l1.add("Zara");
	      l1.add("Mahnaz");
	      l1.add("Ayan");
	      System.out.println();
	      System.out.println(" LinkedList Elements");
	      System.out.print("\t" + l1);
	      System.out.println();
	      
	      Iterator<String> it = l1.iterator();
	      
	      while(it.hasNext())
	    	  System.out.println(it.next());

	      Set<String> s1 = new HashSet<String>(); 
	      s1.add("Zara");
	      s1.add("Mahnaz");
	      s1.add("Ayan");
	      System.out.println();
	      System.out.println(" Set Elements");
	      System.out.print("\t" + s1);
	      System.out.println();
	      
	      for(String str : s1)
	    	  System.out.println(str);

	      Map<String, String> m1 = new HashMap<String, String>(); 
	      m1.put("Zara", "8");
	      m1.put("Mahnaz", "31");
	      m1.put("Ayan", "12");
	      m1.put("Daisy", "14");
	      System.out.println();
	      System.out.println(" Map Elements");
	      System.out.print("\t" + m1);
	   }
}
