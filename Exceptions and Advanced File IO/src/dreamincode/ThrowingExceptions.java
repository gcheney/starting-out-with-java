package dreamincode;

public class ThrowingExceptions{
	
	private static class SubClass
	{
		private int quotient(int numerator, int denominator) throws ArithmeticException 
		{
			if(denominator == 0) {
				throw new ArithmeticException("Cannot divide by zero!");
			}
			return(numerator / denominator);
		}
	 }
	
	public static void main(String args[]){
		int number1=2, number2=0, result=0;
		try {
			SubClass subClass = new SubClass();
			result = subClass.quotient(number1,number2);
			System.out.print(number2 + " goes into " + number1);
			System.out.println(" this many times: " + result);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}


