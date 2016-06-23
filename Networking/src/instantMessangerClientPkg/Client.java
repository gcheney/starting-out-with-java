package instantMessangerClientPkg;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Client extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket connection;
	
	//constructor
	public Client(String host){
		this.setTitle("Glen & Youngjae Instant Messanger");
		serverIP = host;
		
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event){
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			}
		);
		this.add(userText, BorderLayout.NORTH);
		
		chatWindow = new JTextArea();
		this.add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		this.setSize(300, 150);
		this.setVisible(true);
	}
	
	//connect to server
	public void startRunning(){
		try {
			try {
				connectToServer();
				setupStreams();
				whileConnected();
			}
			catch(EOFException e){
				showMessage("\nServer terminated the connection\n");
			}
			finally {
				closeConnection();
			}
		}
		catch(IOException ex){
			showMessage(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	//connect tot he server
	private void connectToServer() throws IOException{
		showMessage("Attempting to establish connection...\n");
		
		try {
			connection = new Socket(InetAddress.getByName(serverIP), 6789);
		} 
		catch (UnknownHostException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		} 
		
		showMessage("Now connected to " + connection.getInetAddress().getHostName() + "\n");
	}
	
	//set up streams to send and receive messages
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("Stream setup complete.");
	}
	
	//while connected and chatting with server
	private void whileConnected() throws IOException{
		ableToType(true);
		do {
			try {
				message = (String) input.readObject();
				showMessage("\n" + message);
			}
			catch(ClassNotFoundException e){
				showMessage("Invlaid message string " + e.getMessage());
			}
		} while(!message.equals("SERVER-END"));
	}
	
	//close streams and end connection
	private void closeConnection() throws IOException{
		showMessage("\nClosing the connection.... \n");
		ableToType(false);

		output.close();
		input.close();
		connection.close();
	}
	
	//send message to the server
	private void sendMessage(String textToSend){
		try {
			output.writeObject("CLIENT: " + textToSend);
			output.flush();
			showMessage("\nCLIENT: " + textToSend);
		}
		catch (IOException e){
			chatWindow.append("ERROR sending message - " + e.getMessage());
		}
	}
	
	//change/update the chat window - update the thread
	private void showMessage(final String textToShow){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chatWindow.append(textToShow);
				}
			}
		);
	}
	
	//give client permission to type into the textfield
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(tof);
					}
				}
			);
	}
	
}
