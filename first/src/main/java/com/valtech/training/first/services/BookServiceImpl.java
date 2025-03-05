package com.valtech.training.first.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.repos.BookRepo;
import com.valtech.training.first.repos.QuestionRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
//	
//	@Override
//	public Long countAllBooks() {
//		return bookRepo.findAll();
//	}


	@Override
	public List<Book> getBooksByYearBetween(int i, int j) {
		return bookRepo.findAllByYearBetween(i, j);
	}


	@Override
	public List<Book> getBooksByPriceGreaterThan(int i) {
		return bookRepo.findAllByPriceGreaterThan(i);
		
	}
	
	@Override
	
	
	public List<BookInfoDTO> getBookInfoByAuthor(long id){
		return bookRepo.getBookInfoByAuthor(id);
	}


	@Override
	public Long countAllBooks() {
		
		return bookRepo.count();
	}


	@Override
	public List<Integer> findAllPriceByAuthorId(int i) {
	 return bookRepo.findAllPriceByAuthorsid(i);
	}


//	@Override
//	public List<Integer> findPriceByAuthorId(int i) {
//	  return  
//	}


//	@Override
//	public List<Integer> findAllPriceByAuthorId(int id) {
//		
//		return bookRepo.findAllByAuthorsId(id);
//	}


//	@Override
//	public Long countAllBooks() {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public List<Integer> findPriceByAuthorId(int i) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
