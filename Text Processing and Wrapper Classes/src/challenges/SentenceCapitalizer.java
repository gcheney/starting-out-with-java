package challenges;

import java.util.Scanner;

public class SentenceCapitalizer {

	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String newStr = capitalize(str);
		System.out.println(newStr);
	}
	
	public static String capitalize(String s){
		StringBuilder sb = new StringBuilder();
		String [] strArr = s.split(" ");
		
		for(String str : strArr){
			str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
			sb.append(str + " ");
		}
			
		return sb.toString();
	}


}
