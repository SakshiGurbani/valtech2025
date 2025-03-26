package com.valtech.project.userService.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.userService.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
