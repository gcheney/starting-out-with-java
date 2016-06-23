package challenges;

import java.util.*;

public class PointList<T extends Point<? extends Number>> {
	private List<T> list;
	
	public PointList() {
		list = new ArrayList<T>();
	}
	
	public void add(T obj) {
		list.add(obj);
	}
	
	public String toString(int index){
		String str = list.get(index).getX() +", "
				+ list.get(index).getY();
		
		return str;
	}
	
	public T getPoint(int index){
		return list.get(index);
	}
}
