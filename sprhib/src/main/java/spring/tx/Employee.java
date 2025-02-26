package spring.tx;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Employee implements Comparable<Employee> {
	
	public enum Gender{
		MALE,FEMALE,OTHER;
	}

	@Id
	private long id;
	private String name;
	private int age;
	private float salary;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int level;
	private int experience;
	

	public Employee() {
	
	}
	
	
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
		
		//w/o this u need to create a employee object first then pass to string builder
	}
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	public Employee(long id, String name, int age, float salary, Gender gender, int level, int experience) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.level = level;
		this.experience = experience;
	}
	
	
	
	//Create a builderclass of employee
	public static class EmployeeBuilder{
		private Employee emp;
		
		public EmployeeBuilder(Employee emp) { //constructor
			this.emp=emp;   //modifying existing object
		}
		
		public Employee build() {
			return emp;
		}
		
		public EmployeeBuilder id(long id) {
			emp.setId(id);
			return this;
		}
		
		public EmployeeBuilder name(String name) {
			emp.setName(name);
			return this;
		}
		
		public EmployeeBuilder age(int age) {
			emp.setAge(age);
			return this;
		}
		
		public EmployeeBuilder salary(float salary) {
			emp.setSalary(salary);
			return this;
		}
		
		public EmployeeBuilder gender(Gender gender) {
			emp.setGender(gender);
			return this;
		}
		
		
//		public EmployeeBuilder gender(String gender) {
//			emp.setGender(Gender.valueOf(gender));
//			return this;
//		}
//		
		
		
		public EmployeeBuilder level(int level) {
			emp.setLevel(level);
			return this;
		}
		
		public EmployeeBuilder experience(int experience) {
			emp.setExperience(experience);
			return this;
		}
			
	
	}
	
	
	
	
	
	
	
	//To string
	@Override
	public String toString() {
		
		return new StringBuilder()
				.append(id)
				.append(" ")
				.append(name)
				.append(" ")
				.append(age)
				.append(" ")
				.append(salary)
				.append(" ")
				.append(level)
				.append(" ")
				.append(gender)
				.append(" ")
				.append(experience)
				.toString();
	}
	
	
    //hashcode
	@Override
	public int hashCode() {
		
		return (toString()+"Employee").hashCode();
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)) return false;
		Employee other = (Employee) obj;
		
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
	
   //Comparable function
	@Override
	public int compareTo(Employee e) {
		
		if(this.level != e.level) {
			return Integer.compare(this.level, e.level);
		}
		
		
		if(this.experience !=e.experience) {
			return Integer.compare(this.experience, e.experience);
		}
		
		
		if(this.salary !=e.salary) {
			return Float.compare(this.salary, e.salary);
		}
		
		
		return this.gender.compareTo(e.gender);
	
		
		
	}
	
	
	

	
	 
	
	
	
	
	

	

	
}
  
