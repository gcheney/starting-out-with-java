package generics;

public class TestPoint {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Create two Double objects
		//Must wrap primitive types in object wrapper class
		Double dblX = new Double(1.5);
		Double dblY = new Double(2.3);
		
		double x = 2.2;
		Point<Double> dPoint = new Point<Double>(x, dblY);
		
		//Integer point
		Integer intX = new Integer(1);
		Integer intY = new Integer(5);
		
		Point<Integer> iPoint = new Point<Integer>(intX, intY);
		
		System.out.println("Double x value is " + dPoint.getX());
		dPoint.setX(3.3);
		doSomething(iPoint, 7);
		printPoint(iPoint);
		printPoint(dPoint);
	}
	
	/**
	 * The printPoint method prints a Point objects 
	 * X and Y coordinates
	 * @param point A Point object
	 */
	public static void printPoint(Point<? extends Number> point){
		//? character is type wildcard - only except classes that inherit from Number
		System.out.println("X coordinate is " + point.getX());
		System.out.println("Y coordinate is " + point.getY());
	}
	
	//Different syntax using type parameter - 
	//extends sets to upper bound - no class above extened class allowed
	public static <T extends Number> void doSomething(Point<T> p, T x){
		p.setX(x);
	}
	
	//Different syntax using type parameter - 
	//super sets to lower bound - no class below super class allowed
	public static  void doSomething(Point<? super Integer> p){
		System.out.println("Y coordinate is " + p.getY());
	}

}
