package challenges;

import java.io.*;
import java.util.Scanner;

public class DecryptFile {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the name of the file you wish to decrypt: ");
		String fileName = keyboard.next();
		
		try {
			//Open the file for reading
			System.out.println("Opening file...");
			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream inputFile = new DataInputStream(fstream);
			
			//create new txt file
			System.out.println("Creating decrypted file...");
			String outputFileName = fileName.replaceAll(".dat", "2.txt");
			PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
			
			//Write contents
			System.out.println("Writing contents to the file...");
			
			boolean endOfFile = false;
			
			while(!endOfFile){
				try {
					String line = inputFile.readUTF();
					writer.write(line + "\n");
				}
				catch(EOFException e){
					endOfFile = true;
				}
			}
			
			
			System.out.println("Done");
			
			//close files
			inputFile.close();
			writer.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
