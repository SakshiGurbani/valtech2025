package dao;


import java.util.List;

public interface EmployeeDAO {
	
	
	void save(Employee e);
	void update (Employee e);
	
	void delete(int id);
	 
	Employee get(int id);
	
	List<Employee> getAll();
	List<Employee> getEmployeeByDeptId(int deptId);
	
	
	//sorting
	List<Employee> sortEmpById(String sortOrder);
	List<Employee> sortEmpByName(String sortOrder);
	List<Employee> sortEmpByAge(String sortOrder);
	List<Employee> sortEmpByGender(String sortOrder);
	List<Employee> sortEmpBySalary(String sortOrder);
	List<Employee> sortEmpByExperience(String sortOrder);
	List<Employee> sortEmpByLevel(String sortOrder);
	List<Employee> sortEmpByDeptId(String sortOrder);
	
	//searching
	List<Employee> getEmpByName(String name);
	List<Employee> getEmpByAge(String byAge ,int age);
	List<Employee> getEmpBySalary(String bySalary ,int salary);
	List<Employee> getEmpByExperience(String byExp ,int experience);
	List<Employee> getEmpByLevel(String byLevel, int level);

   
	
	
	
	

}
