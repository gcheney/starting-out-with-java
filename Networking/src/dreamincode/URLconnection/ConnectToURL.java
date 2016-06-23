package dreamincode.URLconnection;

import java.net.*;
import java.io.*;

public class ConnectToURL {
    // Variables to hold the URL object and its connection to that URL.
    private static URL URLObj;
    private static URLConnection connect;
	
    public static void main(String[] args) {
        try {
            // Establish a URL and open a connection to it. Set it to output mode.
        	String urlStr = "http://www.dreamincode.net/forums/topic/174079-getting-better-at-programming-java/";
            URLObj = new URL(urlStr);
            connect = URLObj.openConnection();
            connect.setDoOutput(true);	
        } catch (MalformedURLException e) {
            System.out.println("The URL specified was unable to be parsed or uses an invalid protocol. Please try again.");
            System.exit(1); 
        } catch (Exception e) {
            System.out.println("An exception occurred. " + e.getMessage());
            System.exit(1);
        }
		
		
        try {
            // Create a buffered writer to the URLConnection's output stream and write our forms parameters.
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connect.getOutputStream()));
            writer.write("username=MyUsername&pass=MyPassword&submit=Login");
            writer.close();
			
            // Now establish a buffered reader to read the URLConnection's input stream.
            BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));			
            String lineRead = "";
			
            // Read all available lines of data from the URL and print them to screen.
            while ((lineRead = reader.readLine()) != null) {
                System.out.println(lineRead);
            }
			
            reader.close();
        } catch (Exception e) {
            System.out.println("There was an error reading or writing to the URL: " + e.getMessage());
        }
    }
}

