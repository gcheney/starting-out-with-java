package serialization;

import java.io.Serializable;

public class Employee implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private transient int SSN;
	private int number;
   
	public Employee(String name, String address, int SSN, int number) {
	   this.name = name;
	   this.address = address;
	   this.SSN = SSN;
	   this.number = number;
	}
   
	public void mailCheck()
	{
      System.out.println("Mailing a check to Employee #" + number
    		  + "\nName: "+ name + "\nAddress: " + address 
    		  + "\nSSN: " + SSN);
	}
}
