package generics;

public class Pair<T, S extends T> {
	private T first;
	private S second;
	
	public Pair(T firstArg, S secondArg){
		first = firstArg;
		second = secondArg;
	}
	
	public T getFirst(){
		return first;
	}
	
	public S getSecond(){
		return second;
	}
}
