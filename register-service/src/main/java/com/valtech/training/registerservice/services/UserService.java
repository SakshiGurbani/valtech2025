package com.valtech.training.registerservice.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO addUserToSubscription(UserVO uvo);

	UserVO getUserById(long id);

	List<UserVO> getUserBySubscriptionId(long subId);

	UserVO signIn(UserVO uvo);

	void deleteUserFromSubscription(@PathVariable long id);

}