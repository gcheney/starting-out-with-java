
package socketDemo;

import java.io.IOException;


public class NetworkingTest {

	public static void main(String[] args) {	
	    try
	    {
	       Thread t = new GreetingServer(); //create new greeting server
	       t.start(); 							//start the greeting server
	       GreetingClient.run(); 				//run the client server
	    }
	    catch(IOException e)
	    {
	       e.printStackTrace();
	    }
	    
	}

}
