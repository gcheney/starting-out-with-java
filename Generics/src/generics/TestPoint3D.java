package generics;

public class TestPoint3D {

	public static void main(String[] args) {
		//create a Point3D object
		Point3D<Integer> point = new Point3D<Integer>(10, 10, 20);
		
		//Display coordinate
		System.out.println("Here are the three points:");
		System.out.println(point.getX());
		System.out.println(point.getY());
		System.out.println(point.getZ());
	}

}
