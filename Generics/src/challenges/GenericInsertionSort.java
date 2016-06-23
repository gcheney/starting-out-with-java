package challenges;

public class GenericInsertionSort<T extends Comparable<T>> implements Comparable<T> {
	
	public T [] sort(T [] array){	
		for(int i=1; i < array.length; i++){
		
			T unsortedValue = array[i];
			int scan = i;
			
			while(scan > 0 && array[scan-1].compareTo(unsortedValue) > 0){
				array[scan] = array[scan-1];
				scan--;
			}
			
			array[scan] = unsortedValue;
		}
		
		return array;
	}

	@Override
	public int compareTo(T o) {
		
		return 0;
	}
}
