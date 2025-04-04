package com.valtech.training.question.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valtech.training.question.entities.Questions;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Long> {
	List<Questions> findAllByTopic(String topic);

	Integer countByTopic(String topic);
}
