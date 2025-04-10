package day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day4.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {
	

	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgress");
		
	}

	@Override
	public void save(Employee e) {
		try(Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?)");
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
		ps.setLong(7, e.getId());
	}

	@Override
	public void update(Employee e) {
		try(Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=? WHERE ID=?");
			setValuesToPreparedStatement(e,ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows updated "+rowsAffected);
			
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	
	

	@Override
	public void delete(int id) {
		try (Connection con=getConnection()){
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
		try(Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID=?");
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
				.experience(rs.getInt(6)).level(rs.getInt(7)).build();
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps=new ArrayList<Employee>();
		
	  try (Connection con=getConnection()){
		  PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE ");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) {
			  emps.add(populateEmployee(rs));
			  
		  }
		  
		
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
		return emps;
	}

}
