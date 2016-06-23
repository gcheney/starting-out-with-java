package challenges;
import java.util.Scanner;

public class WordCounter {

	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int count = wordCount(str);
		System.out.println(count);
	}
	
	public static int wordCount(String s){
		String [] strArr = s.split(" ");
		
		return strArr.length;
	}

}
