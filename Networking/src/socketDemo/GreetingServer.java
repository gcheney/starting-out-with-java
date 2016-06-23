// File Name GreetingServer.java
package socketDemo;

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread
{
   private ServerSocket serverSocket;
   
   public GreetingServer() throws IOException
   {
	  int port = 6066;
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            
            System.out.println("Just connected to client " + server.getRemoteSocketAddress());
            
            InputStream inFromClient = server.getInputStream();
            DataInputStream input = new DataInputStream(inFromClient);
            
            System.out.println(input.readUTF());
            
            OutputStream outToClient = server.getOutputStream();
            DataOutputStream output = new DataOutputStream(outToClient);
            
            output.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
            
            server.close();
            break;
         }
         catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }
         catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
}