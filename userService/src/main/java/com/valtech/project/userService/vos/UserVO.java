package com.valtech.project.userService.vos;

import com.valtech.project.userService.entities.User;

public record UserVO(long id,String name,String email,String mobile,String password) {
	
	public static UserVO from(User u) {
		return new UserVO(u.getId(), u.getName(), u.getEmail(), u.getMobile(), u.getPassword());
	}
	
	public User to() {
		return new User(id, name, email, mobile, password);
	}

}