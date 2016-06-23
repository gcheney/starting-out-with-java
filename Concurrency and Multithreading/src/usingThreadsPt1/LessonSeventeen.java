package usingThreadsPt1;

public class LessonSeventeen { 
	
	public static void main(String[] args) {
		
		// Create a new Thread that executes the code in GetTime
		Thread getTime = new GetTime();
		
		// Create a new Thread created using the Runnable interface
		// Execute the code in run after 10 seconds		
		Runnable getMail = new GetTheMail(10);
		
		Runnable getMailAgain = new GetTheMail(20);
		
		// Call for the code in the method run to execute		
		getTime.start();
		
		//Wrap the Runnable objects in a new Thread
		//and call for code in run to execute
		Thread mail1 = new Thread(getMail);
		mail1.start();
		
		//other option
		new Thread(getMailAgain).start();
	}
	
}
