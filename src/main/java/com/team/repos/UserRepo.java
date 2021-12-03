package com.team.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.models.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	Optional<User> findByUserEmail(String userEmail);
	
	User save(User user);
}
