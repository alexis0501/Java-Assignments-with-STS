package com.alexismayoral.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexismayoral.bookclub.models.Book;
import com.alexismayoral.bookclub.repositories.BookRepository;

@Service
public class MainService {
	
	@Autowired
	private BookRepository bookRepo;
	
	//find all books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	//find one book using id
	public Book findOneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	//create book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

//	 NOTE TO SELF: create and update are the same so copy and paste, 
//	 just function name
	
	//update book
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	//delete book using id
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
		
}
