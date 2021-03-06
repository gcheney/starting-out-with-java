/**
   This program demonstrates a simple generic method.
*/

public class GenericMethodDemo
{
   public static void main(String[] args)
   {
      String[] names = { "Alfonso", "Beatrice", "Celine" };
      displayArray(names);
      
      Double[] digits = { 10.1, 12.3, 44.5};
      displayArray(digits);
   }
   
   /**
      The displayArray method displays each element
      in an array.
      @param array The array to display.
   */
   
   public static <E> void displayArray(E[] array)
   {
      for (E element : array)
         System.out.println(element);
   }
}