package com.valtech.training.springsecurity.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.valtech.training.springsecurity.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	UserDetails findByUsername(String username);

}
