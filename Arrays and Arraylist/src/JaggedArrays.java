
public class JaggedArrays {

	public static void main(String[] args) {
		int[][] example = new int[5][];
		// create a jagged array
		example[0] = new int[5];
		example[1] = new int[2];
		example[2] = new int[3];
		example[3] = new int[7];
		example[4] = new int[10];
		 
		for (int i = 0; i < example.length; i++) {
		     for (int j = 0; j < example[i].length; j++) {
		          System.out.println("At example[" + i + "]["+j+"]: ");
		     }
		}
		
		System.exit(0);
	}

}
