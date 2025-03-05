package spring.files;

import java.util.List;

import spring.files.Customer.CustomerStatus;
import spring.files.Order.Status;



public class OrderServiceImpl implements OrderService {

	
	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO=orderDAO;
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO=itemDAO;
	}
	
	@Override
	public void checkAndAddInventory(Item item) {
		item.setCurrQuant(item.getMaxQuant());
		item.setReOrderQuant(0);
		itemDAO.update(item);
	}
	
	
	@Override
	public void placeOrder(Order o) {
		boolean isValid=true;
		for(LineItems lineItem:o.getLineItems()) {
			if(lineItem.getQuantity()>lineItem.getItem().getCurrQuant()  || o.getCustomer().getCustomerStatus().DISABLE==CustomerStatus.DISABLE) {
				isValid=false;
				o.setStatus(Status.NOTDELIVERED);
				break;
			}
		}
		
		
		if(isValid) {
			o.setStatus(Status.PACKED);
			orderDAO.save(o);
			Item item;
			for(LineItems lineItem:o.getLineItems()) {
				item=itemDAO.get(lineItem.getItem().getId());
				item.setCurrQuant(item.getCurrQuant()-lineItem.getQuantity());
				item.setReOrderQuant(item.getReOrderQuant()+lineItem.getQuantity());
				
				itemDAO.update(item);
				if(item.getCurrQuant()==0) {
					checkAndAddInventory(item);
				}
			}
		
		}
	}
}
