package com.valtech.training.assignmentorder.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignmentorder.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long>{

	Item getReferenceById(int id);

}
