package com.ayanokoujifl.userapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayanokoujifl.userapi.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
