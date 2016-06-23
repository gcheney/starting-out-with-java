package collections;

import java.util.*;

	class Dog implements Comparator<Dog>, Comparable<Dog>{
	   private String name;
	   private int age;
	   
	   /**
	    * Default constructor
	    */
	   public Dog(){
		   
	   }

	   public Dog(String name, int age){
	      this.name = name;
	      this.age = age;
	   }

	   public String getDogName(){
	      return name;
	   }

	   public int getDogAge(){
	      return age;
	   }

	   // Overriding the compareTo method
	   public int compareTo(Dog d){
	      return (this.name).compareTo(d.name);
	   }

	   // Overriding the compare method to sort the age 
	   public int compare(Dog d, Dog d1){
	      return d.age - d1.age;
	   }
	   
	   //Overwriting the equals method
	   public boolean equals(Dog d1) {
		   if(this.age == d1.getDogAge() && this.name.equals(d1.getDogName()))
			   return true;
		   else
			   return false;
	   }
	}

public class ComparatorDemo {
	public static void main(String args[]){
	      // Takes a list o Dog objects
	      List<Dog> list = new ArrayList<Dog>();

	      list.add(new Dog("Shaggy",3));
	      list.add(new Dog("Lacy",2));
	      list.add(new Dog("Roger",10));
	      list.add(new Dog("Tommy",4));
	      list.add(new Dog("TYmmy",1));
	      Collections.sort(list);// Sorts the array list

	      System.out.println("Dogs: ");
	      for(Dog dog: list)//printing the sorted list of names
	         System.out.print(dog.getDogName() + ", ");

	      // Sorts the array list using comparator
	      Collections.sort(list, new Dog());
	      System.out.println(" ");
	      
	      //printing the sorted list of ages
	      for(Dog dog: list) { 
	         System.out.print(dog.getDogName() +"  : "+ dog.getDogAge() + ", ");
	      }
	      
	      Dog sameDog = new Dog("TYmmy",1);
	      System.out.println();
	      
	      for(Dog dog: list) { 
		         if(dog.equals(sameDog))  {
		        	 System.out.println(dog.getDogName() 
		        			 + " is the same as " + sameDog.getDogName());
		         }
		         else  {
		        	 System.out.println(dog.getDogName() 
		        			 + " is NOT the same as " + sameDog.getDogName());
		         }
		  }
	      
	   }
	
}
