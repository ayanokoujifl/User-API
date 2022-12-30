package com.ayanokoujifl.userapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ayanokoujifl.userapi.domain.User;
import com.ayanokoujifl.userapi.repositories.UserRepository;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User us1 = new User("ayanokoujifl", "guleite3@gmail.com", "123");
		User us2 = new User("luis", "guferreiral2004@gmail.com", "123");
		User us3 = new User("gustavo", "ayanokoujifl@gmail.com", "123");
		repo.saveAllAndFlush(Arrays.asList(us1, us2, us3));
	}

}
