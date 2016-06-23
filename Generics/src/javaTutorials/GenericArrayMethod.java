package javaTutorials;

import java.util.Scanner;

public class GenericArrayMethod {

	public static void main(String[] args) {
		String [] strings = {"Johnny", "marge", "fatfuck", "fucker", "shitdick", "fuckface"};
		
		System.out.println("Original Order: ");
		for(String str : strings) {
			System.out.print(str + " ");
		}
		
		System.out.print("\nEnter the strings to switch seperated by a space: ");
		Scanner keyboard = new Scanner(System.in);
		String firstWord = keyboard.next();
		String secondWord = keyboard.next();

		switchPosition(strings, firstWord, secondWord);
		
		System.out.println("\nSwitched Order: ");
		for(String str : strings) {
			System.out.print(str + " ");
		}
		
		String maximum = findMax(strings, 0, strings.length);
		System.out.printf("\nMaximum String is: %s", maximum);
		
		System.out.println();
		
		Double [] doubles = {10.4, 3.5, 22.3, 66.7, 22.9, 44.3};
		Double [] doubles2 = {10.4, 3.5, 22.3, 66.7, 22.9, 44.3};
		System.out.println("Arrays equal?: " + arraysEqual(doubles, doubles2));
		
		System.out.println("\nOriginal Order: ");
		for(Double d : doubles)
			System.out.print(d + " ");
		
		switchPosition(doubles, 3.5, 22.3);
		
		System.out.println("\nSwitched Order: ");
		for(Double d : doubles)
			System.out.print(d + " ");
		
		double maxDouble = findMax(doubles, 0, doubles.length);
		System.out.println("\nMaximum Double is: " + maxDouble);
		
	}
	
	public static <T extends Comparable<T>> void switchPosition(T [] array, T obj1, T obj2) {
		boolean found = false;
		int index1 = -1, index2 = -1;
		
		for(int i = 0; i < array.length && !found; i++)
		{
			if(array[i].compareTo(obj1) == 0) {
				index1 = i;
			}
			else if(array[i].compareTo(obj2) == 0) {
				index2 = i;
			}
			
			if(index1 >= 0 && index2 >= 0) {
				found = true;
			}
		}
		
		if(found) {
			swap(array, index1, index2);
		}
		else
		{
			System.out.print("The following values could not be located: ");
			if(index1 < 0) {
				System.out.print(obj1 + " ");
			}
			if(index2 < 0) {
				System.out.print(obj2 + " ");
			}
		}
	}
	
	public static <T> void swap(T[] a, int i, int j){
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static <T extends Comparable<T>> T findMax(T [] a, int begin, int end){
		T maxElem = a[begin];
		
		for(int index = ++begin; index < end; ++index) {
			if(maxElem.compareTo(a[index]) < 0) {
				maxElem = a[index];
			}
		}
		
		return maxElem;
	}
	
	//Determine if to array are the same
	public static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] arr1, V [] arr2){
		//If lengths different, not same
		if(arr1.length != arr2.length) {
			return false;
		}
		else 
		{
			for(int i = 0; i < arr1.length; i++) {
				if(arr1[i].compareTo(arr2[i]) != 0) {
					return false;
				}
			}
			
			return true;
		}
	}

}
