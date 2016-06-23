package dreamincode;

/**
 * This class demonstrates creating custom
 * exception classes and how to handle them
 * @author glen
 */
public class CreatingExceptions {
	
	/**
	 * Custom exception class for divide-by-zero errors
	 */
	public static class DivideByZeroException extends ArithmeticException {

		private static final long serialVersionUID = 1L;
		private String message;
		
		/**
		 * Constructs a new DivideByZeroException with
		 * the default error message
		 */
		public DivideByZeroException() {
			message = "You divided by zero!";
		}
		
		/**
		 * Constructs a new DivideByZeroException with
		 * the supplied messgae
		 * @param message The exceptions error message
		 */
		public DivideByZeroException(String message) {
			  this.message = message;
		}
		
		/**
		 * Returns this exceptions message
		 * @return The message for this exception
		 */
		public String getMessage(){
			return message;
		}
		
		/**
		 * Overridden getStackTrace() method
		 * Gets and returns the last element in the stack trace
		 * @return the last StackTraceElement in the stack trace
		 */
		public StackTraceElement[] getStackTrace(){
			StackTraceElement[] ste = super.getStackTrace();
			StackTraceElement[] s = new StackTraceElement[1];
			s[0] = ste[ste.length-1];
			return s;
		}
	}
	
	/**
	 * Attempts to divide two numbers
	 * @param numerator The numbe to divide
	 * @param denominator The number to divide by
	 * @return The result of the division
	 * @throws DivideByZeroException if the denominator is 0
	 */
	 private static int quotient(int numerator, int denominator) throws DivideByZeroException 
	 {
		  if(denominator == 0) {
			   throw new DivideByZeroException("Attempted to divide by zero!");
		  }
		  
		  return(numerator / denominator);
	 }
 
	 public static void main(String args[]) {
		 
		  int number1=2, number2=0, result=0;
		  
		  try {
			 result = quotient(number1,number2);
			 System.out.print(number2 + " goes into " + number1);
			 System.out.println(" this many times: " + result);
		  } 
		  catch (ArithmeticException e) {
			 System.out.println(e.getMessage());
			 System.out.println(e.getStackTrace()[0]);
			 System.out.println("An Exception occured");
		  }
	 }
}
