package com.valtech.training.registerservice.services;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService  {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subRepo;
	
	@Override
	public UserVO addUserToSubscription(UserVO uvo) {
		Subscription sub=subRepo.getReferenceById(uvo.subId());
		User user=uvo.to(sub);
		return UserVO.from(userRepo.save(user));
		
	}
	
	@Override
	public UserVO getUserById(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public List<UserVO> getUserBySubscriptionId(long subId){
		return UserVO.from(userRepo.findAllBySubscriptionId(subId));
		
	}
	@Override
	public UserVO signIn(UserVO uvo) {
		Subscription sub=new Subscription();
		sub.setAmount(1000);
		sub.setSubscriptionStart(LocalDate.now());
		sub.setSubscriptionEnd(LocalDate.now().plusYears(1));
		sub.addUser(uvo.to(sub));
		sub=subRepo.save(sub);
		User newUser = uvo.to(sub);
		return UserVO.from(userRepo.save(newUser));
	}

	@Override
	public void deleteUserFromSubscription(@PathVariable long id) {
		User user = userRepo.getReferenceById(id);
		userRepo.delete(user);
	}
	
	

}
