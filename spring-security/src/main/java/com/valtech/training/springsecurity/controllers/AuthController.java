package com.valtech.training.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.springsecurity.entity.User;
import com.valtech.training.springsecurity.services.UserManagerService;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;
import com.valtech.training.springsecurity.vos.UserVO;

@Controller
public class AuthController {
	
	@Autowired
	private UserManagerService userManagerService;
	
	@GetMapping("/changePassword")
	public String showChangePasswordForm() {
		return "changePassword";
	}
   
	
	@PostMapping("/changePassword")
	public String changePassword(@AuthenticationPrincipal User user,@ModelAttribute ChangePasswordVO changePassword) {
		System.out.println("User="+user);
		userManagerService.changePassword(user.getUsername(),changePassword);
		return "redirect:logout";
	} 
    
	@GetMapping("/register")
	public String showRegisterForm() {
		return "register";
	}
	
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserVO uvo){
		userManagerService.registerUser(uvo.to());
		return "login";
	}//form-model (request parameters) //pass in json-requestbody
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody//return data directly--dont write go to jsp page
	public String hello() {
		return "hello";
	}
	@GetMapping("/user")
	@ResponseBody
	public String user() {
	return "User";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
	return "Admin";
	}
}
