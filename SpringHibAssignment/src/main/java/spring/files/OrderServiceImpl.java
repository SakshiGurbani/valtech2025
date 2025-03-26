package spring.files;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.files.Customer.CustomerStatus;
import spring.files.Order.Status;



public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO=orderDAO;
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO=itemDAO;
	}
	
	
	
	
	@Override
	public void placeOrder(Order o) {
		boolean isValid=true;
		for(LineItem lineItem:o.getLineItems()) {
			if(lineItem.getQuantity()>lineItem.getItem().getCurrQuant()  
					|| o.getCustomer().getCustomerStatus().DISABLE==CustomerStatus.DISABLE) {
				isValid=false;
				o.setStatus(Status.REJECTED);
				break;
			}
		}
		
		
		if(isValid) {
			o.setStatus(Status.PACKED);
			orderDAO.save(o);
		}
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//			Item item;
//			for(LineItem lineItem:o.getLineItems()) {
//				item=itemDAO.get(lineItem.getItem().getId());
//				item.setCurrQuant(item.getCurrQuant()-lineItem.getQuantity());
//				item.setReOrderQuant(item.getReOrderQuant()+lineItem.getQuantity());
//				
//				itemDAO.update(item);
////				if(item.getCurrQuant()==0) {
////					checkAndAddInventory(item);
////				}
//			}
		
		}
	}

