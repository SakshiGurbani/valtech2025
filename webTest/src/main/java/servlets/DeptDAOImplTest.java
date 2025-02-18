package servlets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeptDAOImplTest {
     
	
	@Test
	void testInsert() {
	DeptDAO dao=new DeptDAOImpl();
//	 dao.save(new Dept(3,"ACC","HYD"));
//	Dept d=new Dept(3,"ACC","BLR");
//	dao.update(d);
//	d=dao.getDept(3);
	
//	dao.first();
//	dao.last();
	dao.next(1);
	
	}
}
