package dreamincode.sockets;

import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * This object handles the execution for a single user.
 */
public class ChatUser {
	private static final int USER_THROTTLE = 200;
	private Socket socket;
	private boolean connected;
	private Inport inport;
	/**
	 * Handles all incoming data from this user.
	 */
	private class Inport extends Thread {
		@SuppressWarnings("unused")
		private ObjectInputStream in;
		
		public void run() {
			// Open the InputStream
			try {
				in = new ObjectInputStream(socket.getInputStream());
			} catch(IOException e) {
				System.out.println("Could not get input stream from "+toString());
				return;
			}
			
			// Announce
			System.out.println(socket+" has connected input.");
			
			// Enter process loop			
			while(true) {
				// Sleep
				try {
					Thread.sleep(USER_THROTTLE);
				} catch(Exception e) {
					System.out.println(toString()+" has input interrupted.");
				}
			}
		}
	}
	
	/**
	 * Creates a new Umbra Client User with the socket from the newly connected client.
	 *
	 * @param newSocket  The socket from the connected client.
	 */
	public ChatUser(Socket newSocket) {
		// Set properties
		socket = newSocket;
		connected = true;
		// Get input
		inport = new Inport();
		
		inport.start();
	}
	/**
	 * 
	 * Gets the connection status of this user.
	 *
	 * @return  If this user is still connected.
	 */
	public boolean isConnected() {
		return connected;
	}
	
	/**
	 * Purges this user from connection.
	 */
	public void purge() {
		// Close everything
		try {
			connected = false;
			socket.close();
		} catch(IOException e) {
			System.out.println("Could not purge "+socket+".");
		}
	}
	
	/**
	 * Returns the String representation of this user.
	 *
	 * @return  A string representation.
	 */
	public String toString() {
		return new String(socket.toString());
	}
}

