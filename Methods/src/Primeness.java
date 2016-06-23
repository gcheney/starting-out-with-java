import java.util.Arrays;


public class Primeness {
	
	//global array just to keep track of it in this example, 
	//but you can easily do this within another function.
	 
	// will contain true or false values for the first 10,000 integers
	public static boolean[] primes=new boolean[10000]; 
	
	public static void main(String [] args) {
		for(int n = 0; n < 5000; n++) {
			if(isPrime(n))
				System.out.print(n + " ");
		}
		
		System.out.println();
		for(int n = 0; n < 5000; n++) {
			if(isPrime(n))
				System.out.print(n + " ");
		}
		
		fillSieve();
		System.out.println();
		
		for(int i = 0; i < 10000; i++)
			if(isPrime(i))
				System.out.print(i + " ");
	}
	
	//checks whether an int is prime or not.
	public static boolean isPrime(int n) {
	  for(int i=2; i<n; i++) {
	      if(n%i == 0)
	          return false;
	  }
	  
	  return true;
	}
	
	//checks whether an int is prime or not.
	public static boolean isPrimeBetter(int n) 
	{
	    //check if n is a multiple of 2
	    if (n%2 == 0) 
	    	return false;
	    
	    //if not, then just check the odds squared
	    for(int i=3; i*i <=n; i+=2) 
	    {
	        if(n%i == 0)
	            return false;
	    }
	    
	    return true;
	}
	
	
	public static void fillSieve() {
		
	    Arrays.fill(primes, true);       	 // assume all integers are prime.
	    primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
	    
	    for (int num = 2; num < primes.length; num++) 
	    {
	        //if the number is prime, 
	        //then go through all its multiples and make their values false.
	        if(primes[num]) {
	            for (int multiple = 2; num*multiple < primes.length; multiple++) {
	                primes[num*multiple] = false;
	            }
	        }
	    }
	}
	 
	public static boolean isPrimeAsArray(int n) {
		
	    return primes[n]; //simple, huh?
	}
	
}
