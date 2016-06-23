package oopFundamentals;

	class Animal2{

	   public void move(){
	      System.out.println("Animals can move");
	   }
	}

	class Dog extends Animal2{

	   public void move(){
		  super.move(); // invokes the super class method
	      System.out.println("Dogs can walk and run");
	   }
	   public void bark(){
	      System.out.println("Dogs can bark");
	   }
	}

	public class OverRidingTest{

	   public static void main(String args[]){
	      Animal2 a = new Animal2(); // Animal reference and object
	      Animal2 b = new Dog(); // Animal reference but Dog object

	      a.move();// runs the method in Animal class
	      b.move();//Runs the method in Dog class
	      ((Dog) b).bark();
	   }
	}