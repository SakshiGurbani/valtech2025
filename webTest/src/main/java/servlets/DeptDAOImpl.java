package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.Employee;
import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

public class DeptDAOImpl implements DeptDAO {
	
	private Map<Integer,Dept> depts;
	
	ServletContext sc;
	public DeptDAOImpl(ServletContext sc){
//		depts=new HashMap<Integer ,Dept>();
		this.sc=sc;
	}
	
	
//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//			
//		}
//		
//	}
	
	
	
	




	private Connection getConnection(ServletContext sc) throws SQLException{
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgress");
		String url=(String)sc.getAttribute("url");
		String username=(String)sc.getAttribute("username");
		String password=(String)sc.getAttribute("password");
		return DriverManager.getConnection(url,username,password);
		
	}
	
	
	
	@Override
	public void save(Dept d) {
		try(Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("INSERT INTO DEPT (NAME,LOCATION,ID) VALUES(?,?,?)");
		
			setValuesToPreparedStatement(d, ps);
            int rowsAffected=ps.executeUpdate();
            
            System.out.println("rows"+rowsAffected);			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	private void setValuesToPreparedStatement(Dept d, PreparedStatement ps) throws SQLException {
		ps.setString(1, d.getName());
		ps.setString(2, d.getLocation());
		ps.setInt(3, d.getId());
		
	}



	@Override
	public void update(Dept d) {
		try(Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("UPDATE  DEPT  SET NAME=?,LOCATION=? WHERE ID=?");
			setValuesToPreparedStatement(d,ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows updated "+rowsAffected);
			
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	@Override
	public Dept getDept(int id) {
		try(Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,LOCATION FROM DEPT WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//next return true=next row is there ,if false =end of row
				Dept d=populateEmployee(rs);
				return d;
			}else {
				new RuntimeException("No employee with id "+id+"found");
			}
		}catch(Exception ex) {
			throw new RuntimeException(ex);
			
		}
	    return null;
		
	}
	
	@Override
	public void delete(int id) {
		try (Connection con=getConnection(this.sc)){
			PreparedStatement ps=con.prepareStatement("DELETE FROM DEPT WHERE ID=?");
			ps.setInt(1, id);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows delete "+rowsAffected);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Set<Dept> getAll(){
		Set<Dept> depts=new HashSet<Dept>();
		
		  try (Connection con=getConnection(this.sc)){
			  PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,LOCATION FROM EMPLOYEE ");
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
				  depts.add(populateEmployee(rs));
				  
			  }
			  
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
			return depts;
	}

	private Dept populateEmployee(ResultSet rs) throws SQLException {
		return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
	}
	



	@Override
	public Dept first() {
		try (Connection con=getConnection(this.sc)){
			DeptDAO dao=new DeptDAOImpl(sc);
			PreparedStatement ps=con.prepareStatement
					("SELECT ID ,NAME ,LOCATION FROM DEPT WHERE ID =(SELECT MIN(ID) FROM DEPT)");
//			ps.setInt(1, deptId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//next return true=next row is there ,if false =end of row
				Dept d=populateEmployee(rs);
				return d;
			}else {
				new RuntimeException("No employee with no found");
			}
//			int rowsAffected=ps.executeUpdate();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Dept last() {
		try (Connection con=getConnection(this.sc)){
			DeptDAO dao=new DeptDAOImpl(sc);
			PreparedStatement ps=con.prepareStatement
					("SELECT ID ,NAME ,LOCATION FROM DEPT WHERE ID =(SELECT MAX(ID) FROM DEPT)");
//			ps.setInt(1, deptId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//next return true=next row is there ,if false =end of row
				Dept d=populateEmployee(rs);
				return d;
			}else {
				new RuntimeException("No dept with id found");
			}
//			int rowsAffected=ps.executeUpdate();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	
	}

	@Override
	public Dept next(int id) {
//		int next=id;
//		depts.keySet().stream().forEach(i-> );
//		if(id==depts.size()) return depts.get(depts.size());
//		return depts.get(id+1);
		try (Connection con=getConnection(this.sc)){
			DeptDAO dao=new DeptDAOImpl(sc);
			PreparedStatement ps=con.prepareStatement
					("SELECT ID ,NAME ,LOCATION FROM DEPT WHERE ID =(SELECT MIN(ID) FROM DEPT WHERE ID > ?)");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//next return true=next row is there ,if false =end of row
				Dept d=populateEmployee(rs);
				return d;
			}else {
				return dao.first();
//				new RuntimeException("No employee with no found");
			}
//			int rowsAffected=ps.executeUpdate();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		return null;
		
	}

	@Override
	public Dept previous(int id) {
//		if(id==1) return getDept(1);
//		return depts.get(id-1);
		try (Connection con=getConnection(this.sc)){
			DeptDAO dao=new DeptDAOImpl(sc);
			PreparedStatement ps=con.prepareStatement
					("SELECT ID ,NAME ,LOCATION FROM DEPT WHERE ID =(SELECT MAX(ID) FROM DEPT WHERE ID < ?)");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//next return true=next row is there ,if false =end of row
				Dept d=populateEmployee(rs);
				return d;
			}else {
				return dao.last();
//				new RuntimeException("No employee with no found");
			}
//			int rowsAffected=ps.executeUpdate();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
