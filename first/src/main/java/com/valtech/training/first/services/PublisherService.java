package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;

public interface PublisherService {

	List<Publisher> getAllPublishers();
	
	Long countAllPublishers();

}