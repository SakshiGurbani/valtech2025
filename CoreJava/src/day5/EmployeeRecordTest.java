package day5;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import day4.Employee.Gender;

class EmployeeRecordTest {

	@Test
	void test() {
		EmployeeRecord er=new EmployeeRecord(1,"Abc",23,Gender.FEMALE,12000,5,2);
		assertEquals(1, er.id());
		assertEquals("Abc", er.name());
		assertEquals(3,er.age());
		assertEquals(4, er.gender());
		assertEquals(5, er.salary());
		assertEquals(6, er.experience());
		assertEquals(7, er.level());
		
		System.out.println(er);
		EmployeeRecord er1=new EmployeeRecord(1,"Abc",23,Gender.FEMALE,12000,5,2);
		assertEquals(er.hashCode(), er1.hashCode());
		assertEquals(er, er1);
		EmployeeRecord er2=new EmployeeRecord(1,"Abc",23,Gender.MALE,12000,5,2);
		assertFalse(er1.hashCode()== er2.hashCode());
		assertNotEquals(er1, er2);
		assertEquals(2500, er.computeBonus());
	}

}
