package challenges;

public class GenericBinarySearch<T> implements Comparable<T> {
	
	public static <T extends Comparable<T>> int binarySearch (T [] array, int first, int last, T value) {
		
		//test base case for value not found
		if(first > last)
			return -1;
		
		int midpoint = (first + last)/2;
		
		//search for value recursively
		if(array[midpoint].compareTo(value) == 0)
			return midpoint;
		else if(array[midpoint].compareTo(value) < 0)
			return binarySearch(array, midpoint+1, last, value);
		else
			return binarySearch(array, first, midpoint-1, value);
	}

	@Override
	public int compareTo(T o) {
		
		return 0;
	}
}
