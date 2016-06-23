
public class AssignmentTest {
	
	public static void main(String[] args) {
		//Primitive types = make copies
		int i = 2;
		int j = i;
		System.out.println("i: " + i + " j: " + j);
		
		j = 3;
		System.out.println("i: " + i + " j: " + j);
		
		String line1 = "String Test";
		String line2 = line1;
		System.out.println("line1: " + line1 + " line2: " + line2);
		
		line2 = "Fuck it";
		System.out.println("line1: " + line1 + " line2: " + line2);
		
	
		//References types makes assignments to memory location
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Before the changes");
		StringBuilder sb2 = sb1;
		
		System.out.println("sb1: " + sb1.toString());
		System.out.println("sb2: " + sb2.toString());
		
		
		sb2.append(" After the change");
		System.out.println("sb1: " + sb1.toString());
		System.out.println("sb2: " + sb2.toString());
		
		//Use the copy constructor to avoid this
		StringBuilder sb3 = new StringBuilder(sb1);
		sb3.append("Another append?");
		System.out.println("sb1: " + sb1.toString());
		System.out.println("sb3: " + sb3.toString());
	}

}
