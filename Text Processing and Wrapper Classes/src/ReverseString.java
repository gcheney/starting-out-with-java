import java.util.Scanner;

public class ReverseString {
	
	public static void main(String [] args) {
		
		String str;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string to reverse: ");
		str = input.nextLine();
		
		//str = reverseWords(str);
		
		//System.out.println(str);
		
		str = reverseLetters(str);
		
		System.out.println(str);
		
		System.exit(0);
	}
	
	public static String reverseWords(String s) {
		String [] words = s.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = words.length-1; i >= 0; --i) {
			sb.append(words[i] + " ");
		}
		
		return sb.toString();
	}
	
	public static String reverseLetters(String s) {
		String [] words = s.split(" ");
		char [] letters;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = words.length - 1; i >= 0; --i) {
			letters = words[i].toCharArray();
			
			for(int j = letters.length - 1; j >= 0; --j) {
				sb.append(letters[j]);
			}
			
			sb.append(" ");
		}
		
		return sb.toString();
	}

}
