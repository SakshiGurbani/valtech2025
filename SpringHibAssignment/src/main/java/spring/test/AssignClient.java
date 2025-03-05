package spring.test;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.files.Customer;
import spring.files.CustomerDAO;
import spring.files.CustomerHibernateDAOImpl;
import spring.files.CustomerService;
import spring.files.Item;
import spring.files.ItemDAO;
import spring.files.ItemHibernateDAOImpl;
import spring.files.LineItems;
import spring.files.LineItemsDAO;
import spring.files.LineItemsDAOImpl;
import spring.files.Order;
import spring.files.Order.Status;
import spring.files.OrderDAO;
import spring.files.OrderHibernateDAOImpl;
import spring.files.OrderService;
import spring.files.OrderServiceImpl;

public class AssignClient {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("order.xml");
		CustomerService cis=ctx.getBean(CustomerService.class);
//		System.out.println(cs.getClass().getName());
//		cs.save(new Customer( "Sakshi",20,"Jpr","Raj"));
//		Customer customer=cs.get(1);
//		customer.setAge(21);
//		cs.update(customer);
//		cs.update(new Customer( "Sakshi",20,"Jpr","Rajs"));
//		cis.save(new Customer( "Yashi",15,"Ahm","Guj"));
		
		
		
//		ItemHibernateDAOImpl it=ctx.getBean(ItemHibernateDAOImpl.class);
//		System.out.println(cs.getClass().getName());
//		it.save(new Item("mobile", "model", 7, 2, 9));
		
		
		CustomerDAO cs=ctx.getBean(CustomerHibernateDAOImpl.class);
		OrderService ois=ctx.getBean(OrderServiceImpl.class);
		OrderDAO os=ctx.getBean(OrderHibernateDAOImpl.class);
		ItemDAO is=ctx.getBean(ItemHibernateDAOImpl.class);
		LineItemsDAO ls=ctx.getBean(LineItemsDAOImpl.class);
		
//		Customer c=cs.get(2);
//////		
//		Order o=new Order();
//		o.setCustomer(c);
//		o.setStatus(Status.DELIVERED);
//		
//		os.save(o);
//		
//		Item i=is.get(1);
//		
//		LineItems li=new LineItems();
//		li.setQuantity(4);
//		li.setOrder(o);
//		li.setItem(i);
//		
//		ls.save(li);
		
//		ois.placeOrder(o);
		
        


//		
		OrderHibernateDAOImpl or=ctx.getBean(OrderHibernateDAOImpl.class);
		System.out.println(or.getClass().getName());
		
		ctx.close();
		
		
		
		
	}
	
	
	

}
