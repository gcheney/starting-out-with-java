package challenges;

import java.util.Scanner;

public class WordSeperator {

	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String newStr = seperate(str);
		System.out.println(newStr);
	}
	
	public static String seperate(String s){
		char [] array = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(array[0]);
		for(int i = 1; i < array.length; i++){
			if(Character.isUpperCase(array[i])) 
				sb.append(" " + array[i]);
			else
				sb.append(array[i]);
		}
		
		sb.append(".");
		return sb.toString();
	}

}
