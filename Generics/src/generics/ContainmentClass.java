package generics;

public class ContainmentClass<T extends Number> implements Containment<T> {
	T [] arrayRef;
	
	//Constructor
	public ContainmentClass(T[] o){
		arrayRef = o;
	}
	
	//Implement contains
	public boolean contains(T o) {
		for(T element : arrayRef) {
			if(element.equals(o))
				return true;
		}
		
		return false;
	}
	
}
