package com.valtech.training.assignmentorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.training.assignmentorder.services.ItemService;
import com.valtech.training.assignmentorder.vos.ItemVO;




@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
//	
//	@RequestMapping("/item")
//	public String item() {
//		return "item";
//	}
	
//	@RequestMapping(path="item",method=RequestMethod.POST)
//	public String allItemForm(@ModelAttribute("ivo") ItemVO ivo,Model model) {
//		System.out.println(ivo);
//		itemService.saveItem(ivo);
//		model.addAttribute("ivo", itemService.getAllItem());
//		return "item";
//		
//	}
	@GetMapping("/item")
	public String items(Model model) {
		model.addAttribute("item",itemService.getAllItem());
		return"item";
	}
	
//	
	@PostMapping("/item")
	public String allItemForm(@ModelAttribute ItemVO ivo,Model model) {
		itemService.saveItem(ivo);
		model.addAttribute("item", itemService.getAllItem());
		return "item";
		
	}
	
	
	


}
