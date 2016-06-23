package employees;

public class Supervisor extends Employee {
	private double salary;
	private double bonus;
	private String type;
	
	public Supervisor(String n, int num, String hd, double b, double s, String t) {
		super(n, num, hd);
		bonus = b;
		salary = s;
		type = t;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public double getBonus(){
		return bonus;
	}
	
	@Override
	public String getType() {
		return type;
	}
}
