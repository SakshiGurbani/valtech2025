package com.valtech.training.registerservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService  {
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public SubscriptionVO addSubscription(SubscriptionVO svo) {
		List<User> user=userRepo.findAll();
		return SubscriptionVO.from(subscriptionRepo.save(svo.to(user)));
	}
	
	@Override
	public SubscriptionVO getSubscription(long subId) {
		return SubscriptionVO.from(subscriptionRepo.getReferenceById(subId));
	}
	
	@Override
	public List<SubscriptionVO> getAllSubscription(){
		return SubscriptionVO.from(subscriptionRepo.findAll());
	}
	

}
