package challenges;

public class LandTract {
	private int length;
	private int width;
	
	public LandTract(int length, int width){
		this.length = length;
		this.width = width;
	}
	
	//Copy Constrcutor
	public LandTract(LandTract lt){
		length = lt.getLength();
		width = lt.getWidth();
	}
	
	public int getLength(){
		return length;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getArea(){
		return length*width;
	}
	
	/**
	 * toString method 
	 * @return A string indicating the objects 
	 * current state
	 */
	public String toString(){
		String str = "Lenght: " + getLength() 
				+ " Width: " + getWidth() 
				+ " Area: " + getArea();
		
		return str;
	}
	
	public boolean equals(LandTract lt){
		//return lt.getArea() == this.getArea();
		boolean same;
		
		if(lt.getArea() == this.getArea())
			same = true;
		else
			same = false;
		
		return same;
	}
}
