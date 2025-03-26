package com.valtech.training.assignmentorder.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignmentorder.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

	Order getReferenceById(int id);

	void deleteById(int id);

}
