/**
   The Pair class demonstrates a generic class
   with two type parameters.
*/

public class Pair<T, S>
{
   private T first;     // The first item
   private S second;    // The second item
   
   /**
      Constructor
      @param firstArg  Assigned to the first item.
      @param secondArg Assigned to the second item.
   */
   
   public Pair(T firstArg, S secondArg)
   {
      first = firstArg;
      second = secondArg;
   }
   
   /**
      getFirst method
      @return The first item in the pair.
   */
   
   public T getFirst()
   {
      return first;
   }
   
   /**
      getSecond method
      @return The second item in the pair.
   */
   
   public S getSecond()
   {
      return second;
   }
}
