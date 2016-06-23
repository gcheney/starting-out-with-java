package employees;

import java.util.ArrayList;

public class EmployeeTest {

	public static void main(String[] args) {
		TeamLeader leader = new TeamLeader("John", 2222, "08/09/12", 18.50, "Leader", 20.55);
		ProductionWorker worker = new ProductionWorker("John", 2222, "08/09/12", 15.50, "worker");
		Supervisor supervisor = new Supervisor("John", 2222, "08/09/12", 15.50, 10.00,  "Supervisor");
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(leader);
		employeeList.add(worker);
		employeeList.add(supervisor);
		
		for(Employee employee : employeeList){
			System.out.println(employee.getType());
		}
	}

}
