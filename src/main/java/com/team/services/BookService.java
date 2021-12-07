package com.team.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.team.models.Book;
import com.team.repos.BookRepo;

@Service
@Configurable
public class BookService {
	
	@Autowired
	private BookRepo repo;
	
	@Autowired
	OrderService orderService;
	
	List<Book> books;
	
	public List<Book> getAllBooks(){
		books = repo.findAll();
		return books;
	}
	
	public void saveOne(Book b) {
		repo.save(b);
	}
	
	public Book getOne(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteOne(int id) {
		repo.deleteById(id);
	}
	
	public List<Book> getCartBooks(){
		
		List<Integer> bookIds = orderService.getBookIdsFromCart();
				
		List<Book> cartBooks = new ArrayList<>();
		
		
		for(Book book : books) {
			
			for(Integer bookId : bookIds) {
				
				if(book.getBookId() == bookId) {
					cartBooks.add(book);
				}
			}
		}
		
		
		return cartBooks;
		
	}

}
