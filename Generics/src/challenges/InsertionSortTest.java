package challenges;


public class InsertionSortTest {
		public static void main(String [] args){
			Integer [] intArray = {1, 3, 5, 2, 6, 7, 8, 4, 3, 44, 66, 33, 77};
			String [] strArray = {"john", "joey", "larry", "curly", "moe"};
	
			GenericInsertionSort<String> sortString = new GenericInsertionSort<String>();
			String [] sortedStrArray = sortString.sort(strArray);
			
			for(String str : sortedStrArray){
				System.out.print(str + ", ");
			}
			
			System.out.println(); //for space
			
			GenericInsertionSort<Integer> sortInt = new GenericInsertionSort<Integer>();
			Integer [] sortedIntArray = sortInt.sort(intArray);
			
			for(Integer i : sortedIntArray){
				System.out.print(i + ", ");
			}
	}

}
