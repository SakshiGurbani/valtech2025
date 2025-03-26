package com.valtech.training.springsecurity.services;

import com.valtech.training.springsecurity.entity.User;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;

public interface UserManagerService {
	
	void registerUser(User user);

	void changePassword(String username, ChangePasswordVO changePassword);

}
