package challenges;

import java.util.Scanner;

public class BinarySearchTest {

	public static void main(String[] args) {
		
		String [] strArray = {"john", "joe", "aaron", "arod", "betsy", "clark"};
		
		GenericInsertionSort<String> sortString = new GenericInsertionSort<String>();
		String [] sortedArr = sortString.sort(strArray);
		
		int count = 0;
		System.out.println("Sorted Names: ");
		for(String str : sortedArr){
			System.out.printf("Index #%d: %s\n", count, str);
			count++;
		}
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a name to search for: ");
		String name = keyboard.next().toLowerCase();
		
		int index = GenericBinarySearch.binarySearch(sortedArr, 0, sortedArr.length - 1, name);
		
		if(index >= 0)
			System.out.printf("The search item %s was found at index %d", name, index);
		else
			System.out.println("Item not found in Array");
	}
	
	

}
