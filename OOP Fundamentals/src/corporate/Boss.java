package corporate;

import oopFundamentals.SalariedEmployee;
import payroll.Employee;
//import payroll.*;

public class Boss
{
	SalariedEmployee boss;
	
	public Boss(SalariedEmployee e){
		boss = new SalariedEmployee(e);
	}
	
	public void payEmployee(Employee e)
	{
		e.mailCheck();
	}
	
	public double getBossSalary(){
		return boss.getSalary();
	}
	
	public String toString(){
		return boss.toString();
	}
	
	public static void main(String [] args){
		SalariedEmployee s = new SalariedEmployee("Mohd Mohtashim", "Ambehta, UP", 3, 360000.00);
		Boss theBoss = new Boss(s);
		System.out.println(theBoss);
		System.out.println("Salary: " + theBoss.getBossSalary());
	}
}
