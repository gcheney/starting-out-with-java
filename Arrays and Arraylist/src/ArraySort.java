import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

	public static void main(String[] args) {
		Integer [] values = {20, 11, 33, 45, 67, 63};
		printArray(values);
		
		Arrays.sort(values, new Comparator<Integer>() {
			@Override
			public int compare(Integer value1, Integer value2) {
				return value2 - value1;
			}
		});
		
		printArray(values);
		System.exit(0);
	}
	
	public static void printArray(Integer [] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

}
