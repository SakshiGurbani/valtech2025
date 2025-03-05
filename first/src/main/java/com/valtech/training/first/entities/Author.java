package com.valtech.training.first.entities;

import java.util.List;
import java.util.Set;



import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "authseq")
	@SequenceGenerator(name="authseq",sequenceName = "author_seq",allocationSize = 1)
	private int id;
	private String name;
	private String address;
	
//	@ManyToMany(targetEntity=Book.class,mappedBy = "authors" ,fetch=FetchType.LAZY)
//     @JoinTable(name="book_author",
//   joinColumns = @JoinColumn(name="author_id"),inverseJoinColumns =@JoinColumn (name="book_id"))
	@ManyToMany(targetEntity=Book.class,mappedBy = "author" ,fetch=FetchType.LAZY)	
	private Set<Book> book;

	
	
	public Author() {}


	public Author(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Book> getBook() {
		return book;
	}


	public void setBooks(Set<Book> book) {
		this.book = book;
		
	}
	
	
	

}
