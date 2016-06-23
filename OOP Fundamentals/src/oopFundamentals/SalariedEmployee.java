package oopFundamentals;

public class SalariedEmployee extends Employee {
	   private double salary; //Annual salary
	   
	   //Default Constructor
	   public SalariedEmployee (String name, String address, int number, double salary)
	   {
	       super(name, address, number);
	       setSalary(salary);
	   }
	   
	   //Copy Constructor
	   public SalariedEmployee(SalariedEmployee e){
		   super(e.getName(), e.getAddress(), e.getNumber());
		   this.salary = e.getSalary();
	   }
	   
	   public void mailCheck()
	   {
	       System.out.println("Within mailCheck of Salaried class ");
	       System.out.println("Mailing check to " + getName()
	       + " with salary " + salary);
	   }
	   
	   public double getSalary()
	   {
	       return salary;
	   }
	   
	   public void setSalary(double newSalary)
	   {
	       if(newSalary >= 0.0)
	       {
	          salary = newSalary;
	       }
	   }
	   
	   public double computePay()
	   {
	      System.out.println("Computing salary pay for " + getName());
	      return salary/52;
	   }
}
