package oopFundamentals;

/**
 * The Animal clas sis the base class
 * for <ammal and Dog
 * @author glen
 *
 */
public class Animal {
	private String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * The inner mammel class extends animal
	 * @author glen
	 *
	 */
	static class Mammal extends Animal {
		private String species;
		
		public Mammal(String name, String species) {
			super(name);
			this.species = species;
		}
		
		public String getSpecies(){
			return species;
		}
	}
	
	/**
	 * The inner dog class extends mammal
	 * @author glen
	 *
	 */
	static class Dog extends Mammal {
		private String breed;
		
		public Dog(String name, String species, String breed) {
			super(name, species);
			this.breed = breed;
		}
		
		public String getBreed(){
			return breed;
		}
	}
	
	/**
	 * The main class demonstrates
	 * the use of extends and inheritance
	 * @param args
	 */
	public static void main(String args[]){
	      Mammal m = new Mammal("mammal1", "Mammals");
	      Dog dog = new Dog("Dog1", "Mammals", "Terrier");
	      
	      System.out.println(m instanceof Animal);
	      System.out.println(dog instanceof Mammal);
	      System.out.println(dog instanceof Animal);
	      
	      System.out.printf("Name: %s\tSpecies: %s\tBreed: %s", 
	    		  dog.getName(), dog.getSpecies(), dog.getBreed());
	   }
}
