package com.valtech.training.resultservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.resultservice.entities.Result;

public interface ResultRepo extends JpaRepository<Result, Long>{

}
