package challenges;

public class BackwordString {

	public static void main(String[] args) {
		String str = "gravity";
		String revStr = reverse(str);
		System.out.println(revStr);
	}
	
	public static String reverse(String s){
		StringBuilder sb = new StringBuilder(s);
		
		return sb.reverse().toString();
	}

}
