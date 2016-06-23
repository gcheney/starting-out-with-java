package challenges;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestScoresExample {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		int [] scores = new int [3];
		scores[0] = 2;
		scores[1] = 99;
		scores[2] = 95;
		
		TestScores [] test = new TestScores[5];
		ObjectOutputStream outputFile = null;
		ObjectInputStream inputStream = null;
		
		try {
			for(int i = 0; i < test.length; i++){
				test[i] = new TestScores(scores);
			}
		} 
		catch (InvalidTestScoreException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		//Serialize 
		try {
			outputFile = new ObjectOutputStream(new FileOutputStream("TestScores.dat"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		for(int i = 0; i < test.length; i++){
			System.out.println(test[i].toString());
			outputFile.writeObject(test[i]);
		}
		
		outputFile.close();
		
		inputStream = new ObjectInputStream(new FileInputStream("TestScores.dat"));
		
		for(int i = 0; i < test.length; i++)
		{
			try {
				test[i] = (TestScores)inputStream.readObject();
				System.out.println(test[i].toString());
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
