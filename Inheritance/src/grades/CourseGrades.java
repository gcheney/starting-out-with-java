package grades;

public class CourseGrades implements IAnalyzable {

	GradedActivity [] grades = new GradedActivity[4];
	
	public void setLab(GradedActivity lab){
		grades[0] = lab;
	}
	
	public void setPassFailExam(PassFailExam exam){
		grades[1] = exam;
	}
	
	public void setEssay(Essay essay){
		grades[2] = essay;
	}
	
	public void setFinalExam(FinalExam finalExam){
		grades[3] = finalExam;
	}
	
	public String toString(){
		String str = "Lab: " + grades[0].getGrade() + "\n"
				+ "PFExamL: " + grades[1].getGrade() + "\n"
				+ "Essay: " + grades[2].getGrade() + "\n"
				+ "Final Exam: " + grades[3].getGrade() + "\n";
		
		
		return str;
	}
	
	@Override
	public double getAverage() {
		double average = 0, total = 0;

		for(GradedActivity grade : grades){
			total += grade.getScore();
		}
		
		average = total/grades.length;
		
		return average;
	}

	@Override
	public GradedActivity getHighest() {
		GradedActivity highest = grades[0];

		for(GradedActivity grade : grades){
			if(grade.getScore() > highest.getScore()){
				highest = grade;
			}
		}
		
		return highest;
	}

	@Override
	public GradedActivity getLowest() {
		GradedActivity lowest = grades[0];

		for(GradedActivity grade : grades){
			if(grade.getScore() < lowest.getScore()){
				lowest = grade;
			}
		}
		
		return lowest;
	}

}
