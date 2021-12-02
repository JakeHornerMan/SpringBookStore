package com.team.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.models.User;


public interface UserRepo extends JpaRepository<User,Integer>{

}
