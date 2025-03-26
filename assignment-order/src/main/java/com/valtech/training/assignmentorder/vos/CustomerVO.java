package com.valtech.training.assignmentorder.vos;

import java.util.List;
import java.util.stream.Collectors;
import com.valtech.training.assignmentorder.entities.Customer;
import com.valtech.training.assignmentorder.entities.Customer.CustomerStatus;


public record CustomerVO(int cid,String name,int age,String address,String perAdd,CustomerStatus customerStatus) {

	public static CustomerVO from(Customer c) {
//		String status=c.getCustomerStatus().name();
		return new CustomerVO(c.getCid(),c.getName(),c.getAge(),c.getAddress(),c.getPerAdd(),c.getCustomerStatus());
		
	}
	
	public Customer to() {
//		CustomerStatus status=CustomerStatus.valueOf(customerStatus);
		return new Customer(cid, name, age, address, perAdd, customerStatus);
	}
	
	public static List<CustomerVO> from (List<Customer>customer){
		return customer.stream().map(c->CustomerVO.from(c)).collect(Collectors.toList());
	}


}
