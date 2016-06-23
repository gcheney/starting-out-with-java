package employees;

public class ProductionWorker extends Employee{
	private double payRate;
	private String type;
	
	public ProductionWorker(String n, int num, String hd, double pr, String t) {
		super(n, num, hd);
		payRate = pr;
		type = t;
	}
	
	public double getPayRate(){
		return payRate;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
}
