package com.valtech.training.assignmentorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.assignmentorder.services.OrderService;
import com.valtech.training.assignmentorder.vos.PlaceOrderVO;

import ch.qos.logback.core.model.Model;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public String addOrders(@ModelAttribute PlaceOrderVO placeOrderVO, Model model) {
		orderService.save(placeOrderVO);
		return "order";
	}

	@GetMapping("/order")
	public String getOrder(Model model) {
		return "order";
	}
	

}
