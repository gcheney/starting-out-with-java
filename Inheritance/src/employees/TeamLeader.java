package employees;

public class TeamLeader extends ProductionWorker {
	private double bonus;
	
	public TeamLeader(String n, int num, String hd, double pr, String t, double bonus) {
		super(n, num, hd, pr, t);
		this.bonus = bonus;
	}
	
	public double getBonus(){
		return bonus;
	}

}
