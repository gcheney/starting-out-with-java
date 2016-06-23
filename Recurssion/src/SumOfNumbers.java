import java.util.*;


public class SumOfNumbers {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = scanner.nextInt();
		num = sum(num);
		System.out.println(num);
	}
	
	public static int sum(int n){
		if(n==0)
			return 0;
		else
			return n + sum(n-1);
	}
}
