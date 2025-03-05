package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaxws.HelloWorld;
import com.valtech.training.jaxws.webservices.Movie;
import com.valtech.training.jaxws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {
	
	@Autowired
	private MovieServiceWS movieServiceWS;
	@Autowired
	private HelloWorld helloWorld;
	

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Jax WS"));
		movieServiceWS.createMovie(new Movie("Shershah","Action","Hindi",List.of("Siddharth Malhotra","Kiara Advani")));
		movieServiceWS.createMovie(new Movie("YJHD","Romance","Hindi",List.of("Ranbir Kapoor","Deepika Padukone")));
		System.out.println(movieServiceWS.getAllMovies());
	}

}
