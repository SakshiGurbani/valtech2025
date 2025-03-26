package com.valtech.training.assignmentorder.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignmentorder.entities.LineItem;

@Repository
public interface LineItemRepo extends JpaRepository<LineItem, Long>{

}
