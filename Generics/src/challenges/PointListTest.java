package challenges;

public class PointListTest {

	public static void main(String[] args) {
		Point<Integer> p1 = new Point<Integer>(1, 2);
		Point<Integer> p2 = new Point<Integer>(2, 3);
		
		PointList<Point<Integer>> pList = new PointList<Point<Integer>>();
		
		pList.add(p1);
		pList.add(p2);
		
		System.out.println(pList.toString(0));
		
		Point<Integer> p3 = pList.getPoint(1);
		System.out.println(p3.toString());
	}

}
