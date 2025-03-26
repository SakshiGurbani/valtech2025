package day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import day4.Employee.Gender;

public class EmployeeService {
	
	public double getTotalSalaryByLevell(List<Employee>emply1,int level) {
		List<Employee> emps=emply1.stream().filter(emp-> emp.getLevel()<=level).collect(Collectors.toList());
		return emps.stream().mapToDouble(Employee:: getSalary).sum();
		
	}
	
	public double getTotalSalaryByGender(List<Employee>emply2,Gender gender) {

		List<Employee> emps=emply2.stream().filter(emp-> emp.getGender()==gender).collect(Collectors.toList());
		return emps.stream().mapToDouble(Employee:: getSalary).sum();
		
	}
	
	public double getTotalSalaryByLevelAndGender(List<Employee> emply3,int level,Gender gender) {
		List<Employee> emps=emply3.stream().filter(emp-> emp.getLevel()<1 && emp.getGender()==gender).collect(Collectors.toList());
		return emps.stream().mapToDouble(Employee:: getSalary).sum();
		
		
	}
	
	public double getTotalSalaryByIgnoreCase(List<Employee>emply4,String name) {
		List<Employee> emps=emply4.stream().filter(emp-> emp.getName().equalsIgnoreCase("sakshi")).
				collect(Collectors.toList());
		return emps.stream().mapToDouble(Employee:: getSalary).sum();
		
	}

}
