// File Name GreetingClient.java
package socketDemo;

import java.net.*;
import java.io.*;

public class GreetingClient
{
   public static void run()
   {
      String serverName = "127.0.0.1";
      int port = 6066;
      
      try
      {
         System.out.println("Connecting to server " + serverName + " on port " + port);
         
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to server " + client.getRemoteSocketAddress());
         
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream output = new DataOutputStream(outToServer);

         output.writeUTF("Hello from client " + client.getLocalSocketAddress());
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream input = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + input.readUTF());
         client.close();
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
