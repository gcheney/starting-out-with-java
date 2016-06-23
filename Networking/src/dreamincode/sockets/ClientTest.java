package dreamincode.sockets;

import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientTest {
	private static Socket socket;
	private static PrintWriter printWriter;
	
	public static void main(String[] args) {
		try {
			socket = new Socket("localhost", 63400);
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			printWriter.println("Hello Socket");
			printWriter.println("EYYYYYAAAAAAAA!!!!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
