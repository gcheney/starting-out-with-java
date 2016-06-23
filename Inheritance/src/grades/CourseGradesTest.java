package grades;

public class CourseGradesTest {

	public static void main(String[] args) {
		GradedActivity lab = new GradedActivity();
		lab.setScore(90);
		
		PassFailExam passFail = new PassFailExam(10, 1, 70);
		
		Essay essay = new Essay();
		essay.setScore(20, 20, 20, 20);
		
		FinalExam exam = new FinalExam(20, 5);
		
		CourseGrades grades = new CourseGrades();
		grades.setLab(lab);
		grades.setEssay(essay);
		grades.setPassFailExam(passFail);
		grades.setFinalExam(exam);
		
		System.out.print(grades.toString());
		System.out.println("Average: " + grades.getAverage());
		System.out.println("Highest: " + grades.getHighest().toString());
		System.out.println("Lowest: " + grades.getLowest().toString());
	}

}
