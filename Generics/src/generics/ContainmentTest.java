package generics;

public class ContainmentTest {

	public static void main(String[] args) {
		Integer x[] = {1, 2, 3, 4};
		
		ContainmentClass<Integer> ob = new ContainmentClass<Integer>(x);
		
		if(ob.contains(2))
			System.out.println("2 is in ob");
		if(!ob.contains(5))
			System.out.println("5 is NOT in ob");
	}

}
