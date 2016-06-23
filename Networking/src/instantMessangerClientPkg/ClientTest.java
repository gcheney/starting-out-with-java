package instantMessangerClientPkg;

import javax.swing.JFrame;

public class ClientTest {

	public static void main(String[] args) {
		String localHost = "127.0.0.1"; //local host IP address
		Client client = new Client(localHost); 
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.startRunning();
	}

}
