package com.valtech.training.assignmentorder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignmentorder.entities.Customer;
import com.valtech.training.assignmentorder.repos.CustomerRepo;
import com.valtech.training.assignmentorder.vos.CustomerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {
     
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerVO getCustomer(int id) {
		Customer c=customerRepo.getReferenceById((long) id);
		return CustomerVO.from(c);
		
	}
	
	
	@Override
	public CustomerVO saveCustomer(CustomerVO cvo) {
		Customer c=cvo.to();
		c=customerRepo.save(c);
		return CustomerVO.from(c);
	}


	@Override
	public List<CustomerVO> getAllCustomers() {
		return customerRepo.findAll().stream().map(cus->CustomerVO.from(cus)).collect(Collectors.toList());
		
	}
	
	
}
