package com.valtech.training.assignmentorder.services;

import java.util.List;

import com.valtech.training.assignmentorder.vos.CustomerVO;

public interface CustomerService {



	CustomerVO saveCustomer(CustomerVO cvo);

	List<CustomerVO> getAllCustomers();

	CustomerVO getCustomer(int id);

}