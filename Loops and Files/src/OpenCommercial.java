/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String companyName;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();       	 /* Make sure the line is printed immediately. */
    companyName = keyboard.readLine();

    String address = "http://www." + companyName + ".com";
    URL url = new URL(address);
    
    BufferedReader in = new BufferedReader(
    		new InputStreamReader(url.openStream()));
    
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
    	System.out.println(inputLine);
    }

    in.close();
    
    System.out.println("\n*********REVERSE ORDER*******\n");
    
    in = new BufferedReader(new InputStreamReader(url.openStream()));
    
    String [] lines = new String[5];
    for (int i = 0; i < 5; i++) {
    	lines[i] = in.readLine();
    }
    
    for (int i = lines.length-1; i >= 0; i--) {
    	System.out.println(lines[i]);
    }
    
    in.close();
    System.exit(0);
  }
  
}