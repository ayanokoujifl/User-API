package com.ayanokoujifl.userapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayanokoujifl.userapi.domain.User;
import com.ayanokoujifl.userapi.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping
	public List<User> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Integer id) {
		return service.findById(id);
	}
}
