import java.text.DecimalFormat;
import java.util.Scanner;


public class ArrayOperationsTest {

	public static void main(String[] args) {
		final int NUM_STUDENTS = 3;
		final int NUM_CLASSES = 3;
		int classGrade [][] = new int [3][3];
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<NUM_CLASSES; i++){
			for(int j=0; j<NUM_STUDENTS; j++){
				System.out.print("Enter the grade for student " 
							+ (j + 1) + " in class " + (i + 1) + ": ");
				classGrade[i][j] = scanner.nextInt();
			}
		}
		
		int total = getTotal(classGrade);
		double average = getAverage(classGrade);
		int rowTotal = getRowTotal(classGrade, 1);
		int columnTotal = getColumnTotal(classGrade, 1);
		int highest = getHighest(classGrade);
		int lowest = getLowest(classGrade);
		
		DecimalFormat df = new DecimalFormat("##.00");
		
		System.out.println("Total: " + total);
		System.out.println("Average: " + df.format(average));
		System.out.println("Column 1 Total: " + columnTotal);
		System.out.println("Row 1 Total: " + rowTotal);
		System.out.println("Highest: " + highest);
		System.out.println("Lowest: " + lowest);
	}
	
	public static int getTotal(int [][]array){
		int total = 0;
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				total += array[i][j];
			}
		}
		
		return total;	
	}
	
	public static double getAverage(int [][]array){
		double average = 0;
		int count = 0, total =0;
		
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				total += array[i][j];
				count++;
			}
		}
		
		average = total/count;
		
		return average;	
	}
	
	public static int getRowTotal(int [][]array, int rowNum){
		int rowTotal = 0;
		
		for(int i=0; i<array.length; i++){
			rowTotal += array[rowNum][i];
		}
		
		return rowTotal;	
	}
	
	public static int getColumnTotal(int [][]array, int colNum){
		int colTotal = 0;
		
		for(int i=0; i<array.length; i++){
			colTotal += array[i][colNum];
		}
		
		return colTotal;	
	}
	
	public static int getHighest(int [][]array){
		int highest = array[0][0];
		
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				if(array[i][j] > highest){
					highest = array[i][j];
				}
			}
		}
		
		return highest;	
	}
	
	public static int getLowest(int [][]array){
		int lowest= array[0][0];
		
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				if(array[i][j] < lowest){
					lowest = array[i][j];
				}
			}
		}
		
		return lowest;	
	}

}
