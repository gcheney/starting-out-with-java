package challenges;

public class LandTractTest {

	public static void main(String[] args) {
		LandTract tract1 = new LandTract(50, 50);
		LandTract tract2 = new LandTract(tract1);
		
		System.out.println(tract1.toString());
		System.out.println(tract2.toString());
		
		if(tract1.equals(tract2))
			System.out.println("Equal");
		else
			System.out.println("Not equal");
	}

}
