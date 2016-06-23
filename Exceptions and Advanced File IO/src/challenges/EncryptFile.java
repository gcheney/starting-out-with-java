package challenges;

import java.io.*;
import java.util.Scanner;

public class EncryptFile {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		BufferedReader reader;
		
		System.out.print("Enter the name of the file you wish to encrypt: ");
		String fileName = keyboard.next();
		
		try {
			//Open the file for reading
			System.out.println("Opening file...");
			reader = new BufferedReader(new FileReader(fileName));
			
			//create binary file
			System.out.println("Creating encryption file...");
			String outputFileName = fileName.replaceAll(".txt", ".dat");
			FileOutputStream fstream = new FileOutputStream(outputFileName);
			DataOutputStream outputFile = new DataOutputStream(fstream);
			
			//Write contents
			System.out.println("Writing contents to the file...");
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println("Writing line: " + line);
				outputFile.writeUTF(line);
			}
			
			System.out.println("Done");
			
			//close files
			outputFile.close();
			reader.close();
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
