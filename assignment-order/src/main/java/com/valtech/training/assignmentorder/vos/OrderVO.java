package com.valtech.training.assignmentorder.vos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.valtech.training.assignmentorder.entities.Customer;
import com.valtech.training.assignmentorder.entities.LineItem;
import com.valtech.training.assignmentorder.entities.Order;
import com.valtech.training.assignmentorder.entities.Order.Status;

public record OrderVO(int orderId,Status status,Customer customer,Set<LineItem> lineItems) {
	
	public static OrderVO from(Order o) {
		return new OrderVO(o.getOrderId(),o.getStatus(),o.getCustomer(),o.getLineItems());
	}
	
	public Order to() {
		return new Order(orderId,customer,lineItems);
	}
	
	public static List<OrderVO> from(List<Order>orders){
		return orders.stream().map(o->OrderVO.from(o)).collect(Collectors.toList());
	}

}
