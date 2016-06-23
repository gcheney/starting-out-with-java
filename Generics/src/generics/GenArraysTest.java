package generics;

import java.util.*;

public class GenArraysTest {
	
	public static void main(String[] args) {
		Integer ints [] = {1, 66, 33, 2, 5, 6};
		Double doubles [] = {1.1, 22.2, 3.3, 43.4, 5.5, 62.6};
		
		GenArrays<Integer> intarray = new GenArrays<Integer>(50, ints);
		GenArrays<Double> doubleArray = new GenArrays<Double>(50.5, doubles);
		
		List<Double> doubleList = Arrays.asList(doubleArray.sort());
		
		for(Double d : doubleList)
			System.out.println(d);
		
		System.out.println("Original order...");
		for(int i = 0; i < ints.length; i++)
			System.out.print(ints[i] + "\n");
			
		System.out.println("Reverse order...");
		List<Integer> intList = Arrays.asList(intarray.reverse());
		
		for(Integer i : intList)
			System.out.println(i);
		
		//GenArrays<Integer> gens[] = new GenArrays<Integer>[10]; //WRONG!
		
		System.out.println();
		//This is OK
		GenArrays<?>[] gens = new GenArrays<?>[2];
		
		gens[0] = intarray;
		gens[1] = doubleArray;
		
		for(int i = 0; i < gens.length; i++){
			gens[i].sort();
			System.out.println(gens[i] + "\n");
		}
		
	}
	
}
