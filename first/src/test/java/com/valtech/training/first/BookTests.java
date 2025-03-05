package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;
@SpringBootTest
public class BookTests {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PublisherService publisherService;
	
	@Test
	void testBook() {
		
		assertEquals(6,bookService.getAllBooks().size());
//		assertEquals(6, bookService.countAllBooks());
//		assertEquals(6, bookService.countAllAuthors);
		assertEquals(5, bookService.getBooksByYearBetween(2000,2006).size());
		assertEquals(3, bookService.getBooksByPriceGreaterThan(100).size());
//		assertEquals(2, bookService.findAllPriceByAuthorsId(1).size());
//		assertEquals(2, bookService.findAllPriceByAuthorsId(1));
		System.out.println(bookService.getBookInfoByAuthor(2));
		System.out.println(bookService.findAllPriceByAuthorId(1));
		
		
	}

}
