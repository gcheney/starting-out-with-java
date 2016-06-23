package oopFundamentals;

/* File name : MammalInt.java */
/**
 * Implements multiple interfaces, 
 * the interfaces extend each other
 * @author glen
 *
 */
public class MammalInterfaceDemo implements IMammal, Alive{

   public void eat(){
      System.out.println("Mammal eats");
   }

   public void travel(){
      System.out.println("Mammal travels");
   } 

   public int noOfLegs(){
      return 0;
   }
   
   public boolean hasFur() {
	   return true;
   }

   public boolean isAlive() {
	   return true;
   }

   public static void main(String args[]){
      MammalInterfaceDemo m = new MammalInterfaceDemo();
      m.eat();
      m.travel();
      
      if(m.hasFur())
    	  System.out.println("Mammals have fur");
      if(m.isAlive())
    	  System.out.println("This one is alive");
   }
} 