package challenges;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CashRegisterTest {

	public static void main(String[] args) {
		RetailItem item = new RetailItem("TV", 10, 500);
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("How many TVs do you wish to purchase? ");
		int amount = keyboard.nextInt();
		
		CashRegister cr = new CashRegister(item, amount);
		
		try 
		{
			PrintWriter pw = new PrintWriter(new FileWriter("Receipt.txt"));
			pw.write(cr.toString());
			pw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}
