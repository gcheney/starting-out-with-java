package challenges;

import java.util.Scanner;

public class PasswordVerifier {

	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		boolean valid = verify(str);
		if(valid)
			System.out.println("Valid password.");
		else
			System.out.println("Invalid password");

	}
	
	public static boolean verify(String s){
		boolean isValid = false, length = false, 
				digit = false, upper = false, lower = false;
		
		if(s.length() >= 6)
			length = true;
		
		char [] cstring = s.toCharArray();
		
		for(char c : cstring){
			if(Character.isUpperCase(c))
				upper = true;
			if(Character.isLowerCase(c))
				lower = true;
			if(Character.isDigit(c))
				digit = true;
		}
		
		if(length && upper && lower && digit)
			isValid = true;
		
		return isValid;
	}

}
