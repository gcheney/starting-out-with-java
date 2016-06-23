package grades;

public class Essay extends GradedActivity {
	private double score;  // Numeric score
	
	public void setScore(double grammer, double spelling, double length, double content){
		score = grammer + spelling + length + content;
	}
	
	public double getScore(){
		return score;
	}
	
	public String toString(){
		return "Essay";
	}
	
	public char getGrade()
	{
	   char letterGrade;

	   if (score >= 90)
	      letterGrade = 'A';
	   else if (score >= 80)
	      letterGrade = 'B';
	   else if (score >= 70)
	      letterGrade = 'C';
	   else if (score >= 60)
	      letterGrade = 'D';
	   else
	      letterGrade = 'F';

	   return letterGrade;
	}
}
