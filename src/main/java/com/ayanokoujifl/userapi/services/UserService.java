package com.ayanokoujifl.userapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayanokoujifl.userapi.domain.User;
import com.ayanokoujifl.userapi.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	@Transactional(readOnly = true)
	public List<User>findAll() {
		return repo.findAll();
	}
	
	public User findById(Integer id) {
		return repo.findById(id).get();
	}
}
