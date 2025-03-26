package spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.files.Customer;
import spring.files.Customer.CustomerStatus;
import spring.files.CustomerDAO;
import spring.files.CustomerHibernateDAOImpl;
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


class AssignmentClientTest {
	
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("order.xml");
	CustomerDAO cs=ctx.getBean(CustomerHibernateDAOImpl.class);

	OrderService ois=ctx.getBean(OrderServiceImpl.class);
	OrderDAO os=ctx.getBean(OrderHibernateDAOImpl.class);
	ItemDAO is=ctx.getBean(ItemHibernateDAOImpl.class);
	LineItemDAO ls=ctx.getBean(LineItemDAOImpl.class);
	InventoryService inv=ctx.getBean(InventoryService.class);
	

	@Test
	void testCustomerOrder() 	{
		Customer c1=cs.get(1);
		assertEquals("Gunjan", c1.getName());
		assertEquals(20, c1.getAge());
		

		Item it=is.get(2);
		assertEquals(1, it.getCurrQuant());
		
		
		Order o1=os.get(4);
		assertEquals("Gunjan", o1.getCustomer().getName());
		assertEquals(4, o1.getOrderId());
		assertEquals(Status.PACKED, o1.getStatus());
		assertEquals(1, o1.getCustomer().getCid());
		assertEquals("Jpr", o1.getCustomer().getAddress());
		
		
	 	LineItem l1=ls.get(7);
		assertEquals(10, l1.getQuantity());
		assertEquals(1, l1.getItem().getCurrQuant());
		assertEquals(4, l1.getOrder().getOrderId());
		assertEquals("Gunjan", l1.getOrder().getCustomer().getName());
		assertEquals(5, l1.getItem().getMaxQuant());
		assertEquals(1, l1.getOrder().getCustomer().getCid());
		inv.updateInventory(2, 1);
		assertEquals(1, it.getCurrQuant());
		inv.updateInventory(7, 3);
		assertEquals(1,it.getCurrQuant());

	}	
	
	
	
	
		
	



	}
	

	
//	@Test
//	void testLineItems() 	{
//		LineItem lineItem = ls.get(2);
//		System.out.println(lineItem);
//		assertEquals(4, lineItem.getOrder().getCustomer());
//	}
	
	
	


