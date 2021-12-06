package com.team.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.team.models.MyUserDetails;
import com.team.models.User;
import com.team.repos.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		Optional<User> user = userRepo.findByUserEmail(userEmail);
		
		//user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ userEmail));
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		
		return user.map(MyUserDetails::new).get();
	}

}
