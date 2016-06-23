package challenges;

//Overloaded method
public class Area {
	public static double getArea(double radius){
		double pi = Math.PI;
		
		return pi*(radius*radius);
	}
	
	public static double getArea(double width, double length){
		return width*length;
	}
	
	public static double getArea(double radius, int height){
		double pi = Math.PI;
		
		return pi*(radius*radius)*height;
	}
}
