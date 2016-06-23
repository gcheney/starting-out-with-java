package employees;

public abstract class Employee {
	private String name;
	private int number;
	private String hireDate;
	
	public Employee(String name, int number, String hireDate){
		this.name = name;
		this.number = number;
		this.hireDate = hireDate;
	}
	
	public String getName(){
		return name;
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getDate(){
		return hireDate;
	}
	
	public abstract String getType();
}
