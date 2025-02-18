package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;


import day4.Employee.Gender;

class EmployeeTest {

	private Collection<Employee> emps;


   //Test cases
	@Test
	void test() {
		List<Employee> emps=new ArrayList<Employee>();
		System.out.println("Data of the Employees are :-");
		emps.add(Employee.builder().id(87).name("Sakshi").age(20).salary(50000)
				.gender(Gender.FEMALE).level(1).experience(1).build());
		emps.add(Employee.builder().id(56).name("Kushal").age(22).salary(40000)
				.gender(Gender.MALE).level(2).experience(3).build());
		emps.add(Employee.builder().id(100).name("Tanisha").age(21).salary(35000)
				.gender(Gender.FEMALE).level(0).experience(1).build());
		emps.add(Employee.builder().id(102).name("Tisha").age(23).salary(5000)
				.gender(Gender.FEMALE).level(5).experience(7).build());
		emps.add(Employee.builder().id(100).name("Dev").age(18).salary(30000)
				.gender(Gender.MALE).level(2).experience(2).build());
		emps.add(Employee.builder().id(100).name("Vanshika").age(24).salary(4000)
				.gender(Gender.FEMALE).level(1).experience(3).build());
		emps.add(Employee.builder().id(100).name("radha").age(11).salary(20000)
				.gender(Gender.FEMALE).level(1).experience(1).build());
		
		
		
		
		
		
		// Stream APi and salary sum
		
		List<Employee> emply1=emps.stream().filter(emp-> emp.getLevel()<=1).collect(Collectors.toList());
		System.out.println("Employee by level = "+emply1);
		System.out.println("Sum by Level:- "+emply1.stream().mapToDouble(Employee:: getSalary).sum());
		
		//use asserts
	

		List<Employee> emply2=emps.stream().filter(emp-> emp.getGender()==Gender.MALE).collect(Collectors.toList());
		System.out.println("Employee by Gender = "+emply2);
		System.out.println("Sum by Gender:- "+emply2.stream().mapToDouble(Employee:: getSalary).sum());
		

		List<Employee> emply3=emps.stream().filter(emp-> emp.getName().equalsIgnoreCase("sakshi")).
				collect(Collectors.toList());
		System.out.println("Employee by LowerCase = "+emply3);
		System.out.println("Sum by Case:- "+emply3.stream().mapToDouble(Employee:: getSalary).sum());

		
		
		List<Employee> emply4=emps.stream().filter(emp-> emp.getLevel()<1 && emp.getGender()==Gender.FEMALE).collect(Collectors.toList());
		System.out.println("Employee by both level & Gender = "+emply4);
		System.out.println("Level and gender both:- "+emply4.stream().mapToDouble(Employee:: getSalary).sum());
		
		
		//Mapping
		
		Map<Gender,List<Employee>> m=emps.stream().collect(Collectors.groupingBy(Employee::getGender));
		System.out.println("Mapping done by Gender & Employee "+m);
		
	}
	
	
	
	//hash code
	@Test
	void testhashcode() {
		Employee emp=new Employee(123,"Devika",24,20000,Gender.FEMALE,1,4);
		int hash=emp.hashCode();
		System.out.println(emp +" "+emp.hashCode());
		assertEquals(hash,emp.hashCode());
		assertEquals(hash,new Employee(123,"Devika",24,20000,Gender.FEMALE,1,4).hashCode());
		emp.setAge(20);
		System.out.println(emp+" "+emp.hashCode());
		assertNotEquals(hash,emp.hashCode());
		emp.setLevel(6);
		System.out.println(emp+" "+emp.hashCode());
		assertNotEquals(hash,emp.hashCode());

	
	}
	
	
//	@Test
//	void comparebyLevel() {
//		Employee e1=new Employee(123,"Devika",24,20000,Gender.FEMALE,1,4);
//		Employee e2=new Employee(123,"Devika",24,20000,Gender.MALE,1,4);
//		
//		assertTrue(e1.compareTo(e2)>0);
//	}
	
	
	@Test
	void testEquals() {
		Employee ep1=new Employee(1,"Sakshi",20,50000,Gender.FEMALE,1,2);
		Employee ep2=new Employee(1,"Sakshi",20,5000,Gender.FEMALE,1,2);
		
		assertFalse(ep1.equals(ep2));
		assertTrue(ep1.equals(ep1));
	}
	
	
	
	
	
	
	



}
