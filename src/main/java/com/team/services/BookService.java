package com.team.services;

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
	
	public List<Book> getAll(){
		return repo.findAll();
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

}
