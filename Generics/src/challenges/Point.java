package challenges;

public class Point<T extends Number> {
	private T xCoordinate, yCoordinate;
	
	/**
	 * Constructor
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	
	public Point(T x, T y){
		xCoordinate = x;
		yCoordinate = y;
	}
	
	/**
	 * The setX method sets the C coordinate
	 * @param x the value for the x coordinate
	 */
	
	public void setX(T x){
		xCoordinate = x;
	}
	
	public void setY(T y){
		yCoordinate = y;
	}
	
	public T getX()
	{
		return xCoordinate;
	}
	
	public T getY(){
		return yCoordinate;
	}
	
	public String toString(){
		String str = xCoordinate + ", " + yCoordinate;
		
		return str;
	}
}