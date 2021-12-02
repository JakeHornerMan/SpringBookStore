package com.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookStoreApplication.class, args);
	}
	
	/*
	 ALTER TABLE User MODIFY COLUMN user_id INT auto_increment
	 INSERT INTO User (roles, user_email, user_password)
		VALUES ("", "jake@gmail.com", "password");
	INSERT INTO User (roles, user_email, user_password)
		VALUES ("", "kat@gmail.com", "password");
	 */

}
