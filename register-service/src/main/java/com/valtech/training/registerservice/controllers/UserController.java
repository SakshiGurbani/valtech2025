package com.valtech.training.registerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@PostMapping("/")
	public UserVO signIn(@RequestBody UserVO uvo) {
		return userService.signIn(uvo);
	}
	
	@PostMapping("/subscription/{sid}")
	public  void addUserToSubscription(@PathVariable long sid,UserVO uvo) {
		userService.addUserToSubscription(uvo);
		
		
	}
	
//	public ResponseEntity<UserVO> getUser(@PathVariable long id){
//		try {
//			
//		}catch(EntityNotFoundException e) {
//			return Respo'
//		}
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteUserFromSubscription(@PathVariable long id) {
//		
//	}
//	
//	public UserVO getUser(@    long id)

}
