package day4;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import day4.Employee.Gender;

class EmployeeTest {

//	private Collection<Employee> emps;
	List<Employee> emps=new ArrayList<Employee>();
	EmployeeService es=new EmployeeService();
	

	
	
    
	@BeforeEach
	void test() {

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
		System.out.println("Data of the Employees are :-"+emps);  
		

	}
	
	
	@Test
	void TestTotalSalaryBySum() {
		assertEquals(109000, es.getTotalSalaryByLevell(emps, 1));
	}
	
	@Test
	void TestTotalSalaryByIgnoreCase() {
		assertEquals(50000, es.getTotalSalaryByIgnoreCase(emps,"sakshi"));
	}
	
	@Test
	void TestTotalSalaryByLevelAndGender() {
		assertEquals(35000, es.getTotalSalaryByLevelAndGender(emps, 1, Gender.FEMALE));
	}
	@Test
	void TestTotalSalaryByGender() {
		assertEquals(70000, es.getTotalSalaryByGender(emps,Gender.MALE));
	}
	
	@Test
	void testMapping() {

		//Mapping
		Map<Gender,List<Employee>> m=emps.stream().collect(Collectors.groupingBy(Employee::getGender));
		System.out.println("Mapping done by Gender & Employee "+m);
		assertNotNull(m);
	}
	
	@Test
	void testSorting() {
		emps.sort(Comparator.comparing(Employee::getName));
		System.out.println(emps);
	}

	
	
	
	//hash code
	@Test
	void testhashcode() {
		Employee emp=new Employee(123,"Devika",24,20000,Gender.FEMALE,1,4);
		int hash=emp.hashCode();
		System.out.println(emp +" "+emp.hashCode());
		assertEquals(hash,emp.hashCode());
//		assertEquals(hash,new Employee(123,"Devika",23,20000,Gender.FEMALE,1,4).hashCode());
		emp.setAge(20);
		System.out.println(emp+" "+emp.hashCode());
		assertNotEquals(hash,emp.hashCode());
		emp.setLevel(6);
		System.out.println(emp+" "+emp.hashCode());
		assertNotEquals(hash,emp.hashCode());

	
	}
	
	
	@Test
	void comparebyLevel() {
		Employee e1=new Employee(123,"Devika",24,20000,Gender.FEMALE,1,4);
		Employee e2=new Employee(123,"Devika",24,20000,Gender.MALE,1,4);
		
		assertTrue(e1.compareTo(e2)>0);
	}
	
	
	@Test
	void testEquals() {
		Employee ep1=new Employee(1,"Sakshi",20,50000,Gender.FEMALE,1,2);
		Employee ep2=new Employee(1,"Sakshi",20,5000,Gender.FEMALE,1,2);
		
		assertFalse(ep1.equals(ep2));
		assertTrue(ep1.equals(ep1));
	}

}
