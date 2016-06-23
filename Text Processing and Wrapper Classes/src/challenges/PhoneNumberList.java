package challenges;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumberList {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Harrison, Rose");
		names.add("FFRR, Rose");
		names.add("Smith, John");
		names.add("Smith, Will");
		
		ArrayList<String> numbers = new ArrayList<String>();
		numbers.add("555-4477");
		numbers.add("555-6655");
		numbers.add("555-0099");
		numbers.add("555-5678");
		
		System.out.print("Enter a name to search for: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int i = 0; i < names.size(); i++) {
			if(names.get(i).startsWith(str)) {
				System.out.println(names.get(i) 
						+ ": " + numbers.get(i));
			}
		}
	}

}
