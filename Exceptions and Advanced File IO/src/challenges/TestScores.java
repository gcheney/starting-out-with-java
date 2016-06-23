package challenges;

import java.io.Serializable;

public class TestScores implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int numTest = 3;
	private int [] testScores = new int [numTest];
	
	public TestScores(int [] tests) throws InvalidTestScoreException{
		for(int i = 0; i < tests.length; i++){
			if(tests[i] <= 100 && tests[i] >= 0)
				testScores[i] = tests[i];
			else
				throw new InvalidTestScoreException(tests[i]);
		}
	}
	
	public String toString(){
		return "Fuuck!";
	}
}
