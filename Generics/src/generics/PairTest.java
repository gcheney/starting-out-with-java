package generics;

public class PairTest {

	public static void main(String[] args) {
		Integer x = new Integer(475);
		Double y = new Double(3.3);
		
		Pair<Number, Double> myPair = new Pair<Number, Double>(x, y);
		
		System.out.println("X: " + myPair.getFirst());
		System.out.println("Y: " + myPair.getSecond());
	}

}
