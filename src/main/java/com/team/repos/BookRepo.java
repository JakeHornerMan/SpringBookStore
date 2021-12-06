package com.team.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.models.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
	

}
