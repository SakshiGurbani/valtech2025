package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.vos.MovieVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl {
    
	
	@Autowired
	private MovieRepo movieRepo;
	
	
	public MovieVO saveOrUpdate(MovieVO mvo) {
		return MovieVO.from(movieRepo.save(mvo.to()));
	}
	
	public List<MovieVO>getAllMovies(){
		return MovieVO.from(movieRepo.findAll());
	}
	
	
 
}
