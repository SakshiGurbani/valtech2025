package com.valtech.training.assignmentorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.training.assignmentorder.services.CustomerService;
import com.valtech.training.assignmentorder.vos.CustomerVO;



@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//	@RequestMapping("/customer")
//	public String customer() {
//		return "customer";
//	}
	
	@PostMapping("/customer")
//	@RequestMapping(path="customer",method=RequestMethod.POST)
	public String allCustomerForm(@ModelAttribute CustomerVO cvo,Model model) {		
		customerService.saveCustomer(cvo);
		model.addAttribute("customer", customerService.getAllCustomers());
		return "customer";
	}
	
	@GetMapping("/customer")
	public String customers(Model model) {
		model.addAttribute("customer", customerService.getAllCustomers());
		return "customer";
	}
	
	

}
