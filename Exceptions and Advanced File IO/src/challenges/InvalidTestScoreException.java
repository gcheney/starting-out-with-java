package challenges;

@SuppressWarnings("serial")
public class InvalidTestScoreException extends Exception {
		public InvalidTestScoreException(int score){
			super("Error: Inavlid Test Score: " + score);
		}
}
