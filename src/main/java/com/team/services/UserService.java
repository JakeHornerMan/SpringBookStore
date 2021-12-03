package com.team.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.team.repos.UserRepo;
import com.team.models.User;

public class UserService {
	
	@Autowired
    private UserRepo repo;

	public void save(User user) {
        repo.save(user);
    }
}
