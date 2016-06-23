/**
   This program demonstrates the Pair class which
   has two type parameters.
*/

public class PairTest
{
   public static void main(String[] args)
   {
      // Create an Integer to hold an ID number.   
      Integer idNumber = new Integer(475);
      
      // Create a String to hold a name.
      String name = "Smith, Sally";
      
      // Create a Pair object to hold the ID
      // number and the name.
      Pair<Integer, String> myPair = 
            new Pair<Integer, String>(idNumber, name);
      
      // Display the pair of items.
      System.out.println("ID Number: " + 
                         myPair.getFirst());
      System.out.println("Name: " +
                         myPair.getSecond());
   }
}
