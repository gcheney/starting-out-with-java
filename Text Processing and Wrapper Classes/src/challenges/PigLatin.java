package challenges;

import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String newStr = pigLatin(str);
		System.out.println(newStr);
	}
	
	public static String pigLatin(String s){
		StringBuilder sb = new StringBuilder();
		
		String [] strArr = s.split(" ");
		
		for(String str : strArr)
		{
			if(str.length()==1)
				sb.append(str + "ay ");
			else 
			{
				char c = str.charAt(0);
				str = str.substring(1) + c;
				sb.append(str + "ay ");
			}
		}
		
		return sb.toString().toUpperCase();
	}

}
