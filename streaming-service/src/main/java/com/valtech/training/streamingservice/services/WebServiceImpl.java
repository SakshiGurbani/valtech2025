package com.valtech.training.streamingservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WebServiceImpl {
	
	@Autowired
	private WebSeriesRepo webSeriesRepo;
	
  
	

}
