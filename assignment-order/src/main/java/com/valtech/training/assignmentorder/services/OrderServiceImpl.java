package com.valtech.training.assignmentorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignmentorder.entities.Customer.CustomerStatus;
import com.valtech.training.assignmentorder.entities.Item;
import com.valtech.training.assignmentorder.entities.LineItem;
import com.valtech.training.assignmentorder.entities.Order;
import com.valtech.training.assignmentorder.entities.Order.Status;
import com.valtech.training.assignmentorder.repos.ItemRepo;
import com.valtech.training.assignmentorder.repos.OrderRepo;
import com.valtech.training.assignmentorder.vos.OrderVO;
import com.valtech.training.assignmentorder.vos.PlaceOrderVO;

import jakarta.transaction.TransactionScoped;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService  {
	
	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public void resetInventory(Item item) {
		item.setCurrQuant(item.getMaxQuant());
		item.setReOrderQuant(0);
		itemRepo.save(item);
		
	}
	
	@Override
	public void save(PlaceOrderVO pvo) {
		int cid=pvo.cid();
		int itemId=pvo.itemId();
		int quantity=pvo.quanity();
		
		LineItem li=new LineItem();
		li.setItem(itemService.getItem(itemId).to());
		li.setQuantity(quantity);
		
		Order o=new Order();
		o.setCustomer(customerService.getCustomer(cid).to());
		o.addItems(li);
		
		boolean value=true;
		
		for(LineItem lineItem:o.getLineItems()) {
			if(lineItem.getQuantity()>lineItem.getItem().getCurrQuant() || o.getCustomer().getCustomerStatus()==CustomerStatus.DISABLE) {
				value=false;
				o.setStatus(Status.REJECTED);
				orderRepo.save(o);
				break;
			}
		}
		if(value) {
			o.setStatus(Status.PACKED);
			orderRepo.save(o);
			Item item;
			for(LineItem lineItem:o.getLineItems()) {
				item=itemRepo.getReferenceById(lineItem.getItem().getId());
				item.setCurrQuant(item.getCurrQuant()-lineItem.getQuantity());
				item.setReOrderQuant(item.getReOrderQuant()+lineItem.getQuantity());
				itemRepo.save(item);
				if(item.getCurrQuant()==0) {
					resetInventory(item);
				}
			}
		}
	}
	
	@Override
	public OrderVO update(OrderVO orderVO) {
		return OrderVO.from(orderRepo.save(orderVO.to()));
	}
	
	@Override
	public void delete(int id) {
		orderRepo.deleteById(id);
	}
	
	@Override
	public OrderVO get(int id) {
		return OrderVO.from(orderRepo.getReferenceById(id));
	}
	
	
	@Override
	public List<OrderVO> getAll(){
		return OrderVO.from(orderRepo.findAll());
	}
}



