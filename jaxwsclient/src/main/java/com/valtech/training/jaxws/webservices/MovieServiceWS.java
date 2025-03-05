package com.valtech.training.jaxws.webservices;


import java.util.List;

import javax.jws.WebService;



@WebService
public interface MovieServiceWS {

	List<Movie> getAllMovies();

	Movie getMovie(long id);

	Movie createMovie(Movie m);
	

}
