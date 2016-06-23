package challenges;

public class NumberAnalyzer<T extends Number & Comparable<T>> implements Comparable<T>, adder<T> {
	
	private T [] array;
	adder<T> adder;
	
	public NumberAnalyzer(T [] array){
		this.array = array;
	}
	
	public T getHighest(){
		T highest = array[0];
		
		for(int i = 1; i < array.length; i++){
			if(array[i].compareTo(highest) > 0)
				highest = array[i];
		}
		
		return highest;
	}
	
	public T getLowest(){
		T lowest = array[0];
		
		for(int i = 1; i < array.length; i++){
			if(array[i].compareTo(lowest) < 0)
				lowest = array[i];
		}
		
		return lowest;
	}
	
	public T getTotal() {
        T total = adder.zero();
        
        for (T n : array){
            total = adder.add(total, n);
        }
        
        return total;
    }
	
	@Override
	public int compareTo(T o) { 
		return 0;
	}

	@Override
	public T zero() {

		return null;
	}

	@Override
	public T add(T lhs, T rhs) {

		return null;
	}

}


