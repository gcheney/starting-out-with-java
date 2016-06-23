package regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;


public class RegexReplace {
	
	private static BufferedReader br;
	private static PrintWriter pw;
	private static Pattern pattern;
	private static Matcher matcher;
	private static Scanner keyboard;
	private static String regex, input, replace, fileName;
	
	public static void main( String args[] ){
		
		 try
		 {
			keyboard = new Scanner(System.in);
			System.out.print("Enter the name of the file to change: ");
			fileName = keyboard.next();
			
			br = new BufferedReader(new FileReader(fileName));
			pw = new PrintWriter(new FileWriter("NewFile.txt"));
			
			System.out.print("Enter a word to replace followed by"
					+ " the word to replace it with: ");
			regex = keyboard.next();
			replace = keyboard.next();
			
			pattern = Pattern.compile(regex);
			
			while((input = br.readLine()) != null)
			{
				matcher = pattern.matcher(input);
				input = matcher.replaceAll(replace);
				pw.write(input + "\n");
			}
			
			pw.close();
			br.close();
			keyboard.close();
			
			System.exit(0);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
