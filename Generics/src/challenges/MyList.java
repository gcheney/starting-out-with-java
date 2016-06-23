package challenges;

import java.util.*;

public class MyList <T extends Comparable<T>> {
	private List<T> list;
	
	public MyList() {
		list = new ArrayList<T>();
	}
	
	public void add(T obj) {
		list.add(obj);
	}
	
	public T largest(){
		T largest = list.get(0);
		
		for(int i = 1; i < list.size(); i++) {
			T element = list.get(i);
			if(largest.compareTo(element) < 0)
				largest = element;
		}
		
		return largest;
	}
	
	public T smallest(){
		T smallest = list.get(0);
		
		for(T element : list) {
			if(smallest.compareTo(element) > 0)
				smallest = element;
		}
		
		return smallest;
	}
}
