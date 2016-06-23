package generics;

public class GenericMethodDemo {

	public static void main(String[] args) {
		String[] names = {"Alfonso", "Beatrice", "Celine"};
		Integer [] intNumbers = {1, 2, 3};
		Double [] dblNumbers = {11.3, 2.2, 33.25};
		
		displayNames(names);
		displayNumbers(intNumbers);
		displayNumbers(dblNumbers);
		
		System.exit(0);
	}
	
	/**
	 * The displayNames method displays each name
	 * @param array The array to display
	 */
	public static <E> void displayNames(E [] array){
		for(E element : array)
			System.out.println(element);
	}
	
	/**
	 * The displayNumbers method displays each number
	 * @param array An array of Numbers to display
	 */
	public static <E extends Number> void displayNumbers(E [] array){
		for(E element : array)
			System.out.println(element);
	}
}
