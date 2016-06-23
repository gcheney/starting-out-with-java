/**
   This program demonstrates the stack trace that is
   produced when an exception is thrown.
*/

public class StackTrace
{
   public static void main(String[] args)
   {
      System.out.println("Calling myMethod...");
      myMethod();
      System.out.println("Method main is done.");
   }

   /**
      MyMethod
   */

   public static void myMethod()
   {
	   try{
		   System.out.println("Calling produceError...");
		   produceError();
		   System.out.println("myMethod is done.");
	   }
	   catch(StringIndexOutOfBoundsException e){
		   e.printStackTrace();
	   }
   }

   /**
      produceError
   */

   public static void produceError() throws StringIndexOutOfBoundsException
   {
       String str = "abc";

       // The following statement will cause an error.
       System.out.println(str.charAt(3));
       System.out.println("peoduceError is done.");
   }
}
