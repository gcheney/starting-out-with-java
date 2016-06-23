package generics;

public class GenArrays<T extends Number & Comparable<T>> {
	T ob;
	T vals[]; //OK
	
	public GenArrays(T o, T[] nums){
		ob = o;
		//vals = new T[10] //cant create an array of T
		
		//this statement is ok
		vals = nums; //OK to assign reference to existent array
	}
	
	public T[] sort() {
		for(int i = 0; i < vals.length - 1; i++) {
			int minIndex = i;
			T minValue = vals[i];
			
			for(int j = i+1; j < vals.length; j++) {
				if(vals[j].compareTo(vals[i]) < 0) { //j < i
					minValue = vals[j];
					minIndex = j;
				}
			}
			
			vals[minIndex] = vals[i];
			vals[i] = minValue;
		}
		
		return vals;
	}
	
	public T[] reverse() {
		for(int i = 0; i < vals.length/2; i++) {
			T temp = vals[i];
			vals[i] = vals[vals.length - i - 1];
			vals[vals.length - i - 1] = temp;
		}
		
		return vals;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < vals.length; i++)
			sb.append((i+1) + ". " + vals[i] + "\n");
		
		return sb.toString();
	}

}
