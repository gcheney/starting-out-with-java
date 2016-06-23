package instantMessangerServerPkg;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("unused")
public class Server extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private ServerSocket server;
	private Socket connection; 
	
	//Construcor
	public Server() {
		this.setTitle("Glen & Youngjae Instant Messanger");
		
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(new ChatMessage());
		this.add(userText, BorderLayout.NORTH);
		
		chatWindow = new JTextArea();
		this.add(new JScrollPane(chatWindow));
		this.setSize(300, 150);
		this.setVisible(true);
	}
	
	private class ChatMessage implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			sendMessage(event.getActionCommand());
			userText.setText("");
		}
	}
	
	//set up and run the server
	public void startServer() {
		try {
			server = new ServerSocket(6789, 100);
			
			while (true) {
				try {
					//connect and have conversation
					waitForConnection();
					setupStreams();
					whileConnected();
				}
				catch(EOFException e){
					showMessage("\nServer ended the connection!");
				}
				finally {
					closeStreams();
				}
			}
			
		}
		catch(IOException e){
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	//wait for connection, then display connect information
	private void waitForConnection() throws IOException {
		showMessage("Waiting for a client to connect..\n");
		connection = server.accept();
		showMessage("Now connected to " + connection.getInetAddress().getHostName() + "\n");
	}
	
	//get stream to send and receive data
	private void setupStreams() throws IOException {
		//creates the pathway that allows connection to send streams
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush(); //incase data gets left behind
		
		//allows for input from other user
		input = new ObjectInputStream(connection.getInputStream());
		
		showMessage("Establishing host streams....");
	}
	
	//During the chat conversation
	private void whileConnected() throws IOException {
		Date date = new Date( );
		message = "Streams succesfully established.\n "
				+ "New chat started at " + date.toString() 
				+ "\nYou are now connected, and may begin chatting!\n";
		sendMessage(message);
		ableToType(true);//enable textbox
		
		do {
			try {
				//get string from user and display it
				message = (String) input.readObject();
				showMessage("\n" + message);
			}
			catch(ClassNotFoundException e){
				showMessage("I dont know what the user sent!");
				showMessage(e.getMessage());
			}
		} while(!message.equals("CLIENT-END"));
	}
	
	//Close the streams and sockets after the client has left the chat
	private void closeStreams() throws IOException {
		Date date = new Date();
		showMessage("\nClosing connections... \n");
		showMessage("Chat ended at " + date.toString() + "\n");
		ableToType(false);
		
		/*
	    Scanner scan = new Scanner(chatWindow.getText());
	    String messageLog = "";
	    while(scan.hasNextLine()){
	    	String line = scan.nextLine();
	    	if(line.startsWith("C") || line.startsWith("S")){
	    		messageLog += line+"\n";
	    	}
	    }
	    */
		
		writeLog();
		output.close();
		input.close();
		connection.close();
	}
	
	//send a message to the client 
	private void sendMessage(String textToSend){
		try {
			output.writeObject("SERVER: " + textToSend);
			output.flush();
			showMessage("\nSERVER: " + textToSend);
		}
		catch(IOException e) {
			chatWindow.append("\nERROR: MESSAGE SENDING FAILED");
		}
	}
	
	//updates chat window - thread updates certain parts of the GUI
	private void showMessage(final String textToShow){
		SwingUtilities.invokeLater( //new thread to live update chat window
			new Runnable() {
				public void run(){
					chatWindow.append(textToShow); //adds message to end of document and updates ONLY chat window
				}
			}
		);
	}
	
	//let the user type with their text box
	private void ableToType(final boolean tof){
		//new thread to live update chat window
		SwingUtilities.invokeLater( 
			new Runnable() {
				public void run(){
					//manages users ability to type into the textbox
					userText.setEditable(tof);
				}
			}
		);
	}
	
	//create message log record
	private void writeLog(){
		String messageLog = chatWindow.getText();
	    Date date = new Date( );
	    SimpleDateFormat sd = new SimpleDateFormat("E yyyy.MM.dd '@' hh:mm:ss a zzz");
	    String fileDir = "/Users/glen/Documents/Codes/workspace/InstantMessangerServer/Message_Logs/";
	    String fileName = "Message Log: " + sd.format(date);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(fileDir, fileName));
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		writer.write(messageLog);
		writer.close();
	}
	
}
