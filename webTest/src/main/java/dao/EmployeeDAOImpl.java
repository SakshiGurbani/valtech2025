package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

//import day4.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {
	
//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//			
//		}
//		
//	}
//	
	ServletContext sc;
	
	
	public EmployeeDAOImpl(ServletContext sc) {
		this.sc = sc;
	}

	private Connection getConnection(ServletContext sc) throws SQLException{
		
		String url=(String)sc.getAttribute("url");
		String username=(String)sc.getAttribute("username");
		String password=(String)sc.getAttribute("password");
		return DriverManager.getConnection(url,username,password);
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgress");
		
	}

	@Override
	public void save(Employee e) {
		try(Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID,ID) VALUES(?,?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
            int rowsAffected=ps.executeUpdate();
            
            System.out.println("rows"+rowsAffected);			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}

	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, e.getDeptId());
		ps.setLong(8, e.getId());
	}

	@Override
	public void update(Employee e) {
		try(Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=?,DEPTID=? WHERE ID=?");
			setValuesToPreparedStatement(e,ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows updated "+rowsAffected);
			
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	
	

	@Override
	public void delete(int id) {
		try (Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("DELETE FROM EMPLOYEE  WHERE ID=?");
			ps.setInt(1, id);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows delete "+rowsAffected);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	

	@Override
	public Employee get(int id) {
		try(Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL ,DEPTID FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//next return true=next row is there ,if false =end of row
				Employee e=populateEmployee(rs);
				return e;
			}else {
				new RuntimeException("No employee with id "+id+"found");
			}
		}catch(Exception ex) {
			throw new RuntimeException(ex);
			
		}
	    return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		
		return Employee.builder().id(rs.getLong(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5))
				.experience(rs.getInt(6)).level(rs.getInt(7)).deptId(rs.getInt(8)).build();
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps=new ArrayList<Employee>();
		
	  try (Connection con=getConnection(this.sc)){
		  PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID FROM EMPLOYEE ");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) {
			  emps.add(populateEmployee(rs));
			  
		  }
		  
		
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
		return emps;
	}

//	@Override
//	public void save(servlets.Employee emp) {
//		// TODO Auto-generated method stub
//		
//	}
	
	@Override
	public List<Employee> getEmployeeByDeptId(int deptId) {
		List<Employee> employeeList=new ArrayList<Employee>();
		
	  try (Connection con=getConnection(this.sc)){
		  PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL ,DEPTID FROM EMPLOYEE WHERE DEPTID=? ");
			ps.setInt(1, deptId);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) {
			  employeeList.add(populateEmployee(rs));
			  
		  }
		  
		
	} catch (SQLException e) {
		throw new RuntimeException("Database error by fetching details from employee by deptId" ,e);
	}
		return employeeList;
	}

	
	
	
	
	
	
	
	@Override
	public List<Employee> sortEmpById(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> sortEmpByName(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> sortEmpByAge(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> sortEmpByGender(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getGender).reversed()).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> sortEmpBySalary(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> sortEmpByExperience(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getExperience)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getExperience).reversed()).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> sortEmpByLevel(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getLevel)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getLevel).reversed()).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> sortEmpByDeptId(String sortOrder) {
		List<Employee> emp_list=getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getDeptId)).collect(Collectors.toList());
		}else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getDeptId).reversed()).collect(Collectors.toList());
		}
	}
	
	
	
	
	
	
	
	//searching functions
	@Override
	public List<Employee> getEmpByName(String name) {
		List<Employee> emp=getAll();
		return emp.stream().filter(e-> e.getName().contains(name)).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmpByAge(String byAge, int age) {
		List<Employee> emp=getAll();
		if("age".equals(byAge)) {
			return emp.stream().filter(a-> a.getAge()==age).collect(Collectors.toList());
		}else if ("greaterThanAge".equals(byAge)){
			return emp.stream().filter(a-> a.getAge()>age).collect(Collectors.toList());
		}else {
			return emp.stream().filter(a-> a.getAge()<age).collect(Collectors.toList());
		}
	}

	@Override
	public List<Employee> getEmpBySalary(String bySalary, int salary) {
		List<Employee> emp=getAll();
		if("salary".equals(bySalary)) {
			return emp.stream().filter(a-> a.getSalary()==salary).collect(Collectors.toList());
		}else if ("greaterThanSalary".equals(bySalary)){
			return emp.stream().filter(a-> a.getSalary()>salary).collect(Collectors.toList());
		}else {
			return emp.stream().filter(a-> a.getSalary()<salary).collect(Collectors.toList());
		}
			}

	@Override
	public List<Employee> getEmpByExperience(String byExp, int experience) {
		List<Employee> emp=getAll();
		if("experience".equals(byExp)) {
			return emp.stream().filter(a-> a.getExperience()==experience).collect(Collectors.toList());
		}else if ("greaterThanExp".equals(byExp)){
			return emp.stream().filter(a-> a.getAge()>experience).collect(Collectors.toList());
		}else {
			return emp.stream().filter(a-> a.getAge()<experience).collect(Collectors.toList());
		}
		
	}

	@Override
	public List<Employee> getEmpByLevel(String byLevel, int level) {
		List<Employee> emp=getAll();
		if("level".equals(byLevel)) {
			return emp.stream().filter(a-> a.getLevel()==level).collect(Collectors.toList());
		}else if ("greaterThanLevel".equals(byLevel)){
			return emp.stream().filter(a-> a.getLevel()>level).collect(Collectors.toList());
		}else {
			return emp.stream().filter(a-> a.getLevel()<level).collect(Collectors.toList());
		}
	}
	
	
	
	
	
	
	
	
	

}
