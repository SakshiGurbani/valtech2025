package spring.test;




import javax.sound.sampled.Line;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.files.Customer;
import spring.files.Customer.CustomerStatus;
import spring.files.CustomerDAO;
import spring.files.CustomerHibernateDAOImpl;
import spring.files.CustomerService;
import spring.files.InventoryService;
import spring.files.Item;
import spring.files.ItemDAO;
import spring.files.ItemHibernateDAOImpl;
import spring.files.LineItem;
import spring.files.LineItemDAO;
import spring.files.LineItemDAOImpl;
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
		CustomerDAO cs=ctx.getBean(CustomerHibernateDAOImpl.class);
		OrderService ois=ctx.getBean(OrderServiceImpl.class);
		OrderDAO os=ctx.getBean(OrderHibernateDAOImpl.class);
		ItemDAO is=ctx.getBean(ItemHibernateDAOImpl.class);
		LineItemDAO ls=ctx.getBean(LineItemDAOImpl.class);
		InventoryService inv=ctx.getBean(InventoryService.class);
		
		
		
//		System.out.println(cs.getClass().getName());
//		cis.save(new Customer( "Gurbani",20,"Jpr","Raj",CustomerStatus.ENABLE));
//		Customer customer=cis.get(1);
//		customer.setAge(21);
//		cs.update(customer);
//		cs.update(new Customer( "Sakshi",20,"Jpr","Rajs"));
//		cis.save(new Customer( "Yashi",15,"Ahm","Guj"));
		
//		Customer c1=new Customer("Devika", 18, "jaipur", "rajasthan", CustomerStatus.ENABLE);
//		cs.save(c1);
//		Customer c1=cs.get(1);
//		Item i1=new Item("phone","vivo",2,3,5);
//		is.save(i1);
//		Item i1=is.get(7);
//		Order o1=new Order(1, Status.ORDERED, c1);
//		os.save(o1);
//		Order o1=os.get(6);
//		
//		LineItem l1=new LineItem(i1, 5, o1);
//		ls.save(l1);
//		c1.setName("Gunjan");
//		cs.update(c1);
//		Customer c4=new Customer("Raj",23,"jpr","ahm",CustomerStatus.ENABLE);
//		cs.save(c4);
//		assertEquals("Raj", c4.getName());
//		c4.setName("Rajesh");
//		cs.update(c4);
//		assertEquals("Rajesh", c4.getName());
//		Item i2=new Item("laptop", "apple", 3, 2, 5);
//		is.save(i2);
//		Item i3=new Item("laptop11", "apple11", 3, 2, 5);
//		is.save(i3);
		
		
		
//		ItemHibernateDAOImpl it=ctx.getBean(ItemHibernateDAOImpl.class);
//		System.out.println(cs.getClass().getName());
//		it.save(new Item("mobile", "model", 7, 2, 9));
		
		
		
//		
//		
//		Item i=is.get(1);
//		inv.updateInventory(1, 6);
//		inv.addInventory(i);
//		
		
		
//		Item i2 = is.get(3);
//		Item ii=is.get(2);
	
//		Customer c = cs.get(5);
//		Item i = is.get(7);
////		
//		Order order = new Order();
//		order.setCustomer(c);
//		order.setStatus(Status.PACKED);
////		order.addItems(li);
//		os.save(order);
//		
//		
//		LineItem li = new LineItem();
//		li.setOrder(order);
//		
//		li.setItem(i);
//		li.setQuantity(1);
//		ls.save(li);
		//ois.placeOrder(order);
//		inv.updateInventory(1, 1);
//		
//		Customer c=cs.get(4);
//		Item i = is.get(7);
//		LineItem li = new LineItem();
//		li.setItem(i);
//		li.setQuantity(3);
//		ls.save(li);
//		Order order = new Order();
//		order.setCustomer(c);
//		order.addItems(li);
//		order.setStatus(Status.DELIVERED);
//		os.save(order);
//		ois.placeOrder(order);
//		
//		inv.updateInventory(7, 3);
//		 
		

	
//		Item i = is.get(7);
//		LineItem lineItem=new LineItem();
//		lineItem.setItem(i);
//		lineItem.setOrder(order);
//		lineItem.setQuantity(8);
//		ls.save(lineItem);
//		
//		
//		Order order = new Order();
//		Order order=os.get(6);
//		order.setCustomer(c);
//		order.addItems(lineItem);
//		order.setStatus(Status.ORDERED);
//		os.save(order);
//		
		
		
		
		
		//ois.placeOrder(order);
//		System.out.println("Place Order== "+order);
		
		

		
		
		
		
			
		
		
		
		
//        
//		
//		li.setQuantity(4);
//		li.setOrder(o);
//		li.setItem(is.get(1));
////		
//		ls.save(li);
////		
//		Customer c=cs.get(1);
////		System.out.println(c);
//		Item i=is.get(7);
//		
//		LineItem li=new LineItem();
//		li.setItem(i);
//		li.setQuantity(2);
//		
//		
//		Order order=new Order();
//		order.setCustomer(c);
//		order.setStatus(Status.DELIVERED);
//		li.setOrder(order);
//		ls.save(li);
//		order.addItems(li);
//		
//		ois.placeOrder(order);
//		System.out.println(order);
		
		
		
		
		
//////		
//		Order o=os.get(4);
//	    o.setCustomer(c);
//	    o.addItems(li);
//	    o.setCustomer(c);
//		o.setStatus(Status.DELIVERED);
////		
//////		
//////		os.save(o);
////		
		
//////		
//		
////		
//		ois.placeOrder(o);
//		
//		
		
        


//		
		OrderHibernateDAOImpl or=ctx.getBean(OrderHibernateDAOImpl.class);
		System.out.println(or.getClass().getName());
		
		ctx.close();
		
		
		
		
	}
	
	
	

}
