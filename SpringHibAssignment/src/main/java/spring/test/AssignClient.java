package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.files.Customer;
import spring.files.CustomerService;
import spring.files.Item;
import spring.files.ItemDAO;
import spring.files.ItemHibernateDAOImpl;
import spring.files.OrderHibernateDAOImpl;

public class AssignClient {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("order.xml");
		CustomerService cs=ctx.getBean(CustomerService.class);
		System.out.println(cs.getClass().getName());
//		cs.save(new Customer( "Sakshi",20,"Jpr","Raj"));
//		Customer customer=cs.get(1);
//		customer.setAge(21);
//		cs.update(customer);
//		cs.update(new Customer( "Sakshi",20,"Jpr","Rajs"));
		
		
		
		ItemHibernateDAOImpl it=ctx.getBean(ItemHibernateDAOImpl.class);
		System.out.println(cs.getClass().getName());
		it.save(new Item("mobile", "model", 7, 2, 9));
		ctx.close();
		
		
	}
	
	
	

}
