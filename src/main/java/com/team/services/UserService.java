package com.team.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.repos.UserRepo;
import com.team.models.User;

@Service
public class UserService {
	
	@Autowired
    private UserRepo repo;

	public void save(User user) {
        repo.save(user);
    }
	
	public User encryptAndSave(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);
        
        save(user);
        return user;
	}
}
