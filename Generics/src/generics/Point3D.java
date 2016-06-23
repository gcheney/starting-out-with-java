package generics;

/**
 * The Pont3D class holds a generic type Z coordinate
 * @author glen
 *
 */

public class Point3D<T extends Number> extends Point<T> {
	private T zCoordinate;
	
	/**
	 * Constructor
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param z The Z coordinate
	 */
	public Point3D(T x, T y, T z) {
		super(x, y);
		zCoordinate = z;
	}
	
	public void setZ(T z){
		zCoordinate = z;
	}
	
	public T getZ()
	{
		return zCoordinate;
	}
	
}
